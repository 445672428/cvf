package com.frame.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.base.BaseAction;
import com.entities.ResultMeta;
/**
 * 异常拦截所以页面通知
 * @author bobo
 *
 */
@ControllerAdvice  
@ResponseBody
public class ExceptionAdvice extends BaseAction{
	
	/** 
     * 400 - Bad Request 
     */  
    @ResponseStatus(HttpStatus.BAD_REQUEST)  
    @ExceptionHandler(HttpMessageNotReadableException.class)  
    public ModelAndView handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {  
    	ModelAndView v = new ModelAndView("/common/error");
        logger.error("参数解析失败", e);  
        return v;  
    }  
  
    /** 
     * 405 - Method Not Allowed 
     */  
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)  
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)  
    public ModelAndView handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) { 
    	ModelAndView v = new ModelAndView("/common/error");
        logger.error("不支持当前请求方法", e);  
        return v;  
    }  
  
    /** 
     * 415 - Unsupported Media Type 
     */  
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)  
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)  
    public ModelAndView handleHttpMediaTypeNotSupportedException(Exception e) {  
    	ModelAndView v = new ModelAndView("/common/error");
        logger.error("不支持当前媒体类型", e);  
        return v;  
    }  
  
    /** 
     * 500 - Internal Server Error 
     */  
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)  
    @ExceptionHandler(Exception.class)  
    public ModelAndView handleException(Exception e) {  
    	ModelAndView v = new ModelAndView("/common/error");
        logger.error("服务运行异常", e);  
        return v;  
    }  
}
