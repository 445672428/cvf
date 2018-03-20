package com.frame.intercept;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.entities.TUser;
import com.utils.ThreadLocalContainer;

import contant.Contant;

/**
 * 对url进行拦截
 * @author bobo
 *
 */
public class UrlRequestInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		TUser tUser = (TUser)request.getSession().getAttribute(Contant.USER_KEY);
		ThreadLocalContainer container = ThreadLocalContainer.getCurrentContext();
		container.settUser(tUser);
		//TODO这里判断用户是否存在
		request.setAttribute("CONTEXTPATH", request.getContextPath());
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String  url = uri.substring(contextPath.length());
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,HttpServletResponse response, Object handler,ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request,HttpServletResponse response, Object handler, Exception ex)throws Exception {
		
	}
}
