package com.frame.web;

import java.util.List;
import java.util.Map;

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
import com.entities.Friends;
import com.entities.TUser;
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
		boolean isSure = ValidateCodeServlet.validate(request, request.getParameter("checkcode"));
		TUser tUser =  loginService.findCurUser(username,password);
		if (null == tUser || !isSure) {
			return "redirect:login.jsp";
		}
		HttpSession session = request.getSession();
		session.setAttribute(Contant.USER_KEY, tUser);
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
		TUser user = new TUser();
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
