package com.socket;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import contant.Contant;

/**
 * 
 * @author bobo
 *servlet的监听
 */
@WebListener()
public class SocketServletListener implements ServletRequestListener {
    public void requestDestroyed(ServletRequestEvent sre) {
    }
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest request=(HttpServletRequest) sre.getServletRequest();
        HttpSession session=request.getSession();
        Object obj = session.getAttribute(Contant.TMP_PRE);
        float precent = 0f;
        if (obj!=null) {
			precent = (Float)obj;
		}
        System.out.println("SocketServletListener bobo"+precent);
        //session.setAttribute("ClientIPadd", sre.getServletRequest().getRemoteAddr());//把HttpServletRequest中的IP地址放入HttpSession中，关键字可任取，此处为ClientIP
    }
}