package com.springframe;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
/**
 * 异常信息处理
 * @author bobo
 *
 */
public class PageException implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request,HttpServletResponse response, Object handler, Exception ex) {
		 ModelAndView modelAndView = new ModelAndView("error");
	     return modelAndView;
	}

}
