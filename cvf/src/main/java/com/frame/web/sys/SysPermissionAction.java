package com.frame.web.sys;

import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSONObject;
import com.entities.ResultMeta;
import com.mybatis.pojo.SysApp;
import com.mybatis.pojo.SysElement;
import com.mybatis.pojo.SysOrganize;
import com.mybatis.pojo.SysSource;
import com.mybatis.pojo.SysUser;
import com.mybatis.service.MSysPermissionService;
import com.utils.ComUtils;
import com.utils.TimeUtils;

import contant.Contant;

@Controller
@RequestMapping(value="permission")
public class SysPermissionAction {
	
	// 允许上传的格式
	private static final String[] IMAGE_TYPE = new String[] { ".bmp", ".jpg", ".jpeg", ".gif", ".png" };
	
	@Autowired
	private MSysPermissionService msysPermissionService;
	
	
	/**
	 * 组织信息录入
	 * @throws IOException 
	 */
	@RequestMapping(value="group",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	@ResponseBody
	public String groupInformation(String groupname,String groupbrief,String groupparentid,String groupdetails,HttpServletRequest request,HttpServletResponse response) throws IOException{
		Map<String, MultipartFile> fileMap = null;
		if (request instanceof MultipartHttpServletRequest) {
            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
            // 获取上传的文件
            fileMap = multipartHttpServletRequest.getFileMap();

        }
		ResultMeta resultMeta = new ResultMeta();
        // 对文件进处理
        MultipartFile file = null;
		FileOutputStream outStream = null;
		InputStream inStream = null;
		boolean isLegal = false;
        for(Map.Entry<String, MultipartFile> entry : fileMap.entrySet()){
        	file = fileMap.get(entry.getKey());
        }
		String imgType = "";
		String msg = "添加成功";
        if (null != file) {
        	String fileName = file.getOriginalFilename();
        	if (!"".equals(fileName)) {
        		// 校验图片格式
    			for (String type : IMAGE_TYPE) {
    				if (StringUtils.endsWithIgnoreCase(fileName, type)) {
    					isLegal = true;
    					imgType = type;
    					break;
    				}
    			}
    			
            	try {
            		if (isLegal) {
        				inStream = file.getInputStream();
        				BufferedImage image = ImageIO.read(inStream);
        				if (!(Contant.W==image.getWidth()&&Contant.H ==image.getHeight())) {
        					isLegal = false;
        					msg = "上传图片大小不合适";
        					resultMeta.failure(msg);
        					return JSONObject.toJSONString(resultMeta);
        				}
    				}else{
    					msg = "上传文件类型不正确";
    					resultMeta.failure(msg);
    					return JSONObject.toJSONString(resultMeta);
    				}
            		
    			} catch (IOException e) {
    				e.printStackTrace();
    				msg = "上传文件类型不正确";
    				resultMeta.failure(msg);
    				return JSONObject.toJSONString(resultMeta);
    			}
			}
        	
		}
        
		String id = ComUtils.getUuid();
		SysOrganize sysOrganize = new SysOrganize();
		sysOrganize.setId(id);
		sysOrganize.setName(groupname);
		sysOrganize.setCode(id);
		sysOrganize.setBrief(groupbrief);
		sysOrganize.setInstruction(groupdetails);
		sysOrganize.setIcon(id);
		sysOrganize.setParentid(groupparentid);
		Date createtime = new Date();
		sysOrganize.setCreatetime(createtime);
        
		int cnt = msysPermissionService.insertOneOrganize(sysOrganize);
		
		if (cnt==0) {
			msg = "数据写入失败";
			resultMeta.failure(msg);
			 JSONObject.toJSONString(resultMeta);
		}
		if (null != file&&!"".equals(file.getOriginalFilename())) {
			try {
				outStream = new FileOutputStream(Contant.USR_DIR+id+imgType);
				int flag = 0;
				while((flag=inStream.read())!=-1){
					outStream.write(flag);
				}
				outStream.flush();
				outStream.close();
				inStream.close();
			} catch (Exception e) {
				e.printStackTrace();
				msg = "图片写入失败";
			}
		}
		
		resultMeta.success(msg);
		return JSONObject.toJSONString(resultMeta);
		
	}
	
	/**
	 * 人员信息录入
	 * @throws IOException 
	 */
	@RequestMapping(value="staff",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	@ResponseBody
	public String sysUserAdd(String txtName,String txtAddress,Integer card_type,String txtIDCard,String txtMob,String txtEmail){
		SysUser sysUser = new SysUser();
		sysUser.setAddress(txtAddress);
		sysUser.setUsername(txtName);
		sysUser.setEmail(txtEmail);
		sysUser.setTel(txtMob);
		sysUser.setRealname(txtIDCard);
		sysUser.setPassword(txtIDCard);
		sysUser.setCreate_id(card_type);
		String create_time = TimeUtils.getCurrentTime();
		sysUser.setCreate_time(create_time);
		int cnt = msysPermissionService.insertOneUser(sysUser);
		ResultMeta resultMeta = new ResultMeta();
		if (cnt>0) {
			resultMeta.success("添加成功");
		}else{
			resultMeta.failure("添加失败");
		}
		return JSONObject.toJSONString(resultMeta);
	}
	
	/**
	 * 资源种类录入
	 * @return
	 */
	@RequestMapping(value="source",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	@ResponseBody
	public String sourceInformation(String card_type,String sourceName,String sourceType){
		SysSource sysSource = new SysSource();
		sysSource.setCid(ComUtils.getUniqID());
		sysSource.setType(card_type);
		sysSource.setName(sourceName);
		sysSource.setPid(sourceType);
		Date createtime = new Date();
		sysSource.setCreatetime(createtime);
		int cnt = msysPermissionService.insertOneSource(sysSource);
		ResultMeta resultMeta = new ResultMeta();
		if (cnt>0) {
			resultMeta.success("添加成功");
		}else{
			resultMeta.failure("添加失败");
		}
		return JSONObject.toJSONString(resultMeta);
	}
	/**
	 * 要素名称录入
	 * @return
	 */
	@RequestMapping(value="element",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	@ResponseBody
	public String elementInformation(String card_type,String elementName){
		SysElement sysElement = new SysElement();
		sysElement.setName(elementName);
		sysElement.setPid(card_type);
		sysElement.setCreatetime(new Date());
		int cnt = msysPermissionService.insertOnesysElement(sysElement);
		ResultMeta resultMeta = new ResultMeta();
		if (cnt>0) {
			resultMeta.success("添加成功");
		}else{
			resultMeta.failure("添加失败");
		}
		return JSONObject.toJSONString(resultMeta);
	}
	/**
	 * 应用名称录入
	 * @return
	 */
	@RequestMapping(value="app",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	@ResponseBody
	public String appInformation(String appName,String appAliasName,String urlFunctionName,String urlName){
		SysApp sysApp = new SysApp();
		sysApp.setAliasname(appAliasName);
		sysApp.setName(appName);
		sysApp.setUrlFunctionName(urlFunctionName);
		sysApp.setUrlName(urlName);
		sysApp.setCreatetime(new Date());
		int cnt = msysPermissionService.insertOneSysApp(sysApp);
		ResultMeta resultMeta = new ResultMeta();
		return JSONObject.toJSONString(resultMeta);
	}

}
