package com.frame.web.freemaker;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.base.BaseAction;
import com.frame.service.DataDictionaryService;
import com.pojo.ResultMeta;
import com.templet.model.StoreRoom;
import com.templet.word.DBDataDictionary;
import com.utils.ExcelParserUtil;
import com.utils.FreeMakerUtils;

import contant.Contant;

@Controller
@RequestMapping("db")
public class DataDictionaryTempleAction extends BaseAction{
	
	@Autowired
	private DataDictionaryService dataDictionaryService;
	
	@Autowired
	@Qualifier("sybaseJdbcTemplate")
	private JdbcTemplate sybaseJdbcTemplate;
	
	@Autowired
	@Qualifier("mysqlJdbcTemplate")
	private JdbcTemplate mysqlJdbcTemplate;
	
	@RequestMapping(value = "/dictionary", method = RequestMethod.POST)
	@ResponseBody
	public void exportUserForDoc(HttpServletRequest request,HttpServletResponse response) throws IOException{  
       String dbName = request.getParameter("dbname");
       String db =  request.getParameter("dbkey");
       
		DBDataDictionary dataDictionary = new DBDataDictionary();
		StoreRoom storeRoom = dataDictionary.CreateDBInfOBean(sybaseJdbcTemplate, "基础");
	
         // 提示：在调用工具类生成Word文档之前应当检查所有字段是否完整    
         // 否则Freemarker的模板殷勤在处理时可能会因为找不到值而报错 这里暂时忽略这个步骤了    
         File file = null;    
         InputStream fin = null;    
         ServletOutputStream out = null;    
         try {    
             // 调用工具类WordGenerator的createDoc方法生成Word文档    
        	 Map<String, Object> dataMap = new HashMap<String, Object>();
        	 dataMap.put("storeRoom", storeRoom);
             file = FreeMakerUtils.createDoc(dataMap, "datadictionary");    
             fin = new FileInputStream(file);    
                 
             response.setCharacterEncoding("utf-8");    
             response.setContentType("application/msword");    
             // 设置浏览器以下载的方式处理该文件默认名为resume.doc    
             response.addHeader("Content-Disposition", "attachment;filename=datadictionary.doc");    
                 
             out = response.getOutputStream();    
             byte[] buffer = new byte[1024];  // 缓冲区    
             int bytesToRead = -1;    
             // 通过循环将读入的Word文件的内容输出到浏览器中    
             while((bytesToRead = fin.read(buffer)) != -1) {    
                 out.write(buffer, 0, bytesToRead);    
             }    
         } finally {    
             if(fin != null) fin.close();    
             if(out != null) out.close();    
             if(file != null) file.delete(); // 删除临时文件    
         }    
       }
	
	
	/**
     * 导入清单,数据处理
     *
     * @return
     */
    @RequestMapping(value = "/import", method = RequestMethod.POST,produces=MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String importDetailedExcel(@RequestParam("file") MultipartFile uploadExcels) {
    	ResultMeta resultMeta = new ResultMeta();
        try {
    		FileOutputStream outStream = null;
    		InputStream inStream = null;
    		try {
    			
    			outStream = new FileOutputStream(Contant.TMP_DIR+uploadExcels.getOriginalFilename());
    			inStream = uploadExcels.getInputStream();
    			int flag = 0;
    			while((flag=inStream.read())!=-1){
    				outStream.write(flag);
    			}
    			outStream.flush();
    			outStream.close();
    			inStream.close();
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
			
    		
    		
    	dataDictionaryService.compareSourceDBToDestDB(uploadExcels);

		resultMeta.success("成功");
        } catch (Exception e) {
        	resultMeta.failure("文件类型不对，文件解析失败");
        }
        return JSONObject.toJSONString(resultMeta);
    }
}
