package com.socket;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;
import javax.websocket.server.ServerEndpointConfig.Configurator;

import contant.Contant;
/**
 * 
 * @author bobo
 *
 */
public class SocketConfigurator extends Configurator {
    @Override
    public void modifyHandshake(ServerEndpointConfig config, HandshakeRequest request, HandshakeResponse response) {
        HttpSession httpSession = (HttpSession) request.getHttpSession();
        Object obj  = httpSession.getAttribute(Contant.TMP_PRE);
        float precent = 0f;
        if (obj!=null) {
			precent = (Float)obj;
		}
        System.out.println("SocketConfigurator bobo"+precent);
        //config.getUserProperties().put("ClientIP", httpSession.getAttribute("ClientIPadd"));//把HttpSession中保存的ClientIP放到ServerEndpointConfig中，关键字可以跟之前不同
    }
}