package com.frame.web.threeparty;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qq.connect.QQConnectException;
import com.qq.connect.api.qzone.Topic;
import com.qq.connect.javabeans.GeneralResultBean;

public class ShuoShuoServlet extends HttpServlet {
	 @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
	        response.setContentType("text/html;charset=utf-8");

	        request.setCharacterEncoding("utf-8");
	        String con = request.getParameter("con");
	        HttpSession session = request.getSession();
	        String accessToken = (String)session.getAttribute("demo_access_token");
	        String openID = (String)session.getAttribute("demo_openid");
	        //请开发者自行校验获取的con值是否有效
	        if (con != "") {
	            Topic topic = new Topic(accessToken, openID);
	            try {
	                GeneralResultBean grb = topic.addTopic(con);
	                if (grb.getRet() == 0) {
	                    response.getWriter().println("<a href=\"http://www.qzone.com\" target=\"_blank\">您的说说已发表成功，请登录Qzone查看</a>");
	                } else {
	                    response.getWriter().println("很遗憾的通知您，发表说说失败！原因： " + grb.getMsg());
	                }
	            } catch (QQConnectException e) {
	                e.printStackTrace();
	            }
	        } 
	    }

	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
	        doGet(request, response);
	    }
}
