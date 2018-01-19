package com.frame.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.entities.User;
import com.frame.multil.service.HotleService;
import com.frame.multil.service.SearchService;
import com.frame.service.LoginService;

import contant.Contant;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
	@Autowired
	private HotleService hotleService;
	@Autowired
	private SearchService searchService;
	
//	@Autowired
//	@Qualifier("sybaseJdbcTemplate")
//	private JdbcTemplate sybaseJdbcTemplate;
	@Qualifier("mysqlJdbcTemplate")
	@Autowired
	private JdbcTemplate mysqlJdbcTemplate;
	/**
	 * 用户登录
	 */
	@RequestMapping(value="login.do",method=RequestMethod.POST)
	public String login(HttpServletRequest request){
		String username = request.getParameter("username");
		String password = request.getParameter("password"); 
		User user = loginService.findCurUser(username,password);
		if (user==null) {
			return "redirect:loginmain.jsp";
		}
		HttpSession session = request.getSession();
		session.setAttribute(Contant.USER_KEY, user);
		return "home";
	}
	
	/**
	 * 用户注册
	 */
	@RequestMapping(value="register.do",method=RequestMethod.POST)
	public String register(HttpServletRequest request,HttpServletResponse response){
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		User user = new User();
		user.setPassWord(password);
		user.setUserName(userName);
		user.setEmail(email);
		user.setMobile(mobile);
		try {
			loginService.saveNewUser(user);
			return "redirect:login.jsp";
		} catch (Exception e) {
			return "forward:register.jsp";
		}
	}
	/**
	 * 全国信息树形结构
	 * @param code
	 * @param level
	 * @return
	 */
	@RequestMapping(value="china.do",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	@ResponseBody
	public String queryChinaDict(String id) {
		JSONArray list = loginService.queryChinaCode(id);
		return list.toString();
	}
	
	/**
	 * 创建文件夹
	 * @param userid
	 * @param filename
	 * @param parentid
	 * @param level
	 * @param uuid
	 * @return
	 */
	@RequestMapping(value="filecreate.do",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	@ResponseBody
	public String filecreate(String userid,String filename,String parentid,Integer level,String uuid) {
		JSONObject object = new JSONObject();
		try {
			object = loginService.saveFileName(userid, filename, parentid, level,uuid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return object.toString();
	}
	
	/**
	 * 查询当前用户的文件夹 和文件
	 * @param userid
	 * @param filename
	 * @param parentid
	 * @param level
	 * @param uuid
	 * @return
	 */
	@RequestMapping(value="queryfiles.do",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	@ResponseBody
	public String querycreate(String userid,String parentid,Integer level) {
		JSONObject	object = loginService.queryFileByUUid(userid, parentid, level);
		return object.toString();
	}
	
	/**
	 * 查询当前用户的文件夹 和文件
	 * @param userid
	 * @param filename
	 * @param parentid
	 * @param level
	 * @param uuid
	 * @return
	 */
	@RequestMapping(value="delfiles.do",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	@ResponseBody
	public String delCurrentFile(String userid,String parentid,Integer level) {
		JSONObject	object = loginService.deleteFileByUUid(userid, parentid, level);
		return object.toString();
	}
	
	/**
	 * 查询当前用户的文件夹 和文件
	 * @param userid
	 * @param filename
	 * @param parentid
	 * @param level
	 * @param uuid
	 * @return
	 */
	@RequestMapping(value="savename.do",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	@ResponseBody
	public String updateFolderName(String id,String name) {
		boolean flag = true;
		try {
			int	count = loginService.updateFileNameById(id, name);
			if (count == 0) {
				flag = false;
			}
		} catch (Exception e) {
			flag = false;
		}
		JSONObject object = new JSONObject();
		if (flag) {
			object.put("succ", flag);
		}else{
			object.put("succ", flag);
		}
		return object.toString();
	}
	
	@RequestMapping(value="data.do",method=RequestMethod.POST)
	public void upData(String param) {
		JSONArray array = JSON.parseArray(param);
		if (array!=null) {
			for(int i = 0; i < array.size(); i++){
				Object obj = array.get(i);
				JSONObject jsonObject = (JSONObject)obj;
				String name = jsonObject.getString("name");
				String code = jsonObject.getString("code");
				String parent_code = jsonObject.getString("parent_code")==null?"":jsonObject.getString("parent_code");
				String sql = "insert into china (name,code,parentcode) values ('"+name+"','"+code+"','"+parent_code+"')";
				mysqlJdbcTemplate.execute(sql);
				System.out.println(sql);
			}
		}
	}
}
