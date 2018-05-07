package com.frame.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.socket.TextMessage;

import com.entities.Friends;
import com.entities.TUser;
import com.frame.multil.service.SearchService;
import com.frame.service.SocketService;
import com.push.WebsocketEndPoint;

import contant.Contant;
@Controller
public class SocketAction {
	@Autowired
	private SearchService searchService;
	@Autowired
	private SocketService socketService;
    @Bean//这个注解会从Spring容器拿出Bean
    public WebsocketEndPoint getPointHandler() {
        return new WebsocketEndPoint();
    }
    
	@RequestMapping(value="chat/chatfriends.do",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public @ResponseBody Map<String,List<Friends>> getMyAllFriends(HttpServletRequest request,HttpServletResponse response){
		TUser user = (TUser)request.getSession().getAttribute(Contant.USER_KEY);
		Map<String,List<Friends>> list = socketService.findMyAllFriends(user);
		return list;
	}
    
    @RequestMapping("/websocket/login")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String username = request.getParameter("username");
        System.out.println(username+"登录");
        HttpSession session = request.getSession(false);
        session.setAttribute("SESSION_USERNAME", username);
        return new ModelAndView("websocket");
    }

    @RequestMapping("/websocket/send")
    @ResponseBody
    public String send(HttpServletRequest request) {
        String username = request.getParameter("username");
        getPointHandler().sendMessageToUser(username, new TextMessage("你好，测试！！！！"));
        return null;
    }
}
