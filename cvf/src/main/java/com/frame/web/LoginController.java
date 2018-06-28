package com.frame.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.http.Cookie;
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

import com.base.BaseAction;
import com.entities.TAdmin;
import com.frame.service.LoginService;
import com.utils.HttpUtils;
import com.utils.TimeUtils;

import contant.Contant;
import encryption.AESUtil;
import encryption.RSA;
/**
 * 登录控制器
 * @author bobo
 *
 */
@Controller
public class LoginController extends BaseAction{
	@Autowired
	private LoginService loginService;

	@Qualifier("mysqlJdbcTemplate")
	@Autowired
	private JdbcTemplate mysqlJdbcTemplate;
	/**
	 * 用户登录
	 */
	@RequestMapping(value="dologin",method=RequestMethod.POST)
	public String login(HttpServletRequest request){
		String ip = HttpUtils.getIpAddress(request);
		String username = request.getParameter("username");
		String password = request.getParameter("password"); 
		Long time = (Long)request.getSession().getAttribute(Contant.TIME);
		if (time == null || time == 0) {
			return "redirect:login";
		}
		
		boolean isSure = ValidateCodeServlet.validate(request, request.getParameter("checkcode"));
		//进行解密 在这里需要控制在一分钟内 使用时间搓加密
		password = RSA.decryptStringByJs(password);
		long n = TimeUtils.getNow();
		if ((n - time) > 60000) {
			return "redirect:login";
		}
		//对于密码进行对称加密 进行数据匹配
		password = password.substring(0, password.length()-String.valueOf(time).length());
		password = AESUtil.encrypt(Contant.SECURITY, password);
		TAdmin tUser =  loginService.findCurUser(username,password,ip);
		if (null == tUser || !isSure) {
			return "redirect:login";
		}
		HttpSession session = request.getSession();
		session.setAttribute(Contant.USER_KEY, tUser);
		return "redirect:/home";
	}
	
	
	/**
	 * 检测用户名是否可以注册
	 */
	@RequestMapping(value="check",method=RequestMethod.GET)
	public void checkRegisterUserName(HttpServletRequest request,HttpServletResponse response){
		

		PrintWriter printWriter = null;
		try {
			response.setContentType("text/html; charset=UTF-8");
			response.setHeader("Expires", "-1");  
	        response.setHeader("Cache-Control", "no-cache");  
	        response.setHeader("Pragma",  "no-cache"); 
	        
			request.setCharacterEncoding("UTF-8");  
			String name = request.getParameter("name");
			byte[] bytes = name.getBytes("ISO-8859-1");
			name = new String(bytes, "UTF-8");
			logger.info(name);
			boolean isIn = loginService.checkUserName(name);
			printWriter = response.getWriter();
			String msg = "可以注册";
			if (isIn) {
				msg = "注册账号已经存在";
			}else{
				
			}
			printWriter.print(msg);
			printWriter.flush();
			printWriter.close();
		} catch (IOException e) {
			logger.error("error", e);
		}

	}
	
	/**
	 * 用户注册
	 */
	@RequestMapping(value="register",method=RequestMethod.POST)
	public String register(HttpServletRequest request,HttpServletResponse response){
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		long time = (long)request.getSession().getAttribute(Contant.TIME);
		if (time == 0) {
			return "redirect:login";
		}
		password = RSA.decryptStringByJs(password);
		long n = TimeUtils.getNow();
		if ((n - time) > 60000) {
			return "redirect:login";
		}
		//对于密码进行对称加密 进行数据匹配
		password = password.substring(0, password.length()-String.valueOf(time).length());
		password = AESUtil.encrypt(Contant.SECURITY, password);
		
		TAdmin user = new TAdmin();
		user.setPassWord(password);
		user.setAdmin_name(userName);
		user.setEmail(email);
		user.setTelephone(mobile);
		try {
			loginService.saveNewUser(user);
			return "redirect:login";
		} catch (Exception e) {
			return "redirect:register";
		}
	}
	/**
	 * 主要用于反爬虫 后续处理
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="t",method=RequestMethod.GET)
	@ResponseBody
	public void getTime(HttpServletRequest request,HttpServletResponse response) {
		Cookie[] cookie = request.getCookies();
		Enumeration es = request.getHeaderNames();
		String type = request.getAuthType();
		String ip = HttpUtils.getIpAddress(request);
		Long t = TimeUtils.getNow();
		request.getSession().setAttribute(Contant.TIME, t);
		try {
			response.getWriter().print(t);
			response.getWriter().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 用户注销
	 * @throws IOException 
	 */
	@RequestMapping(value="quit",method=RequestMethod.GET)
	public void doQuit(HttpServletRequest request,HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Enumeration<String> em = session.getAttributeNames();
		while(em.hasMoreElements()){
			request.getSession().removeAttribute(em.nextElement().toString());
		}
		String path = request.getContextPath();
		path = request.getScheme() +"://"+ request.getServerName()+":"+request.getServerPort()+path+"";
		 
		session.removeAttribute(Contant.USER_KEY);
		session.invalidate();
		response.sendRedirect(path);
		//response.sendRedirect(request.getContextPath() + "index");
	}
}
