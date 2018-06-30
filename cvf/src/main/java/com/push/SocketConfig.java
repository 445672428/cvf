package com.push;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebMvc
@EnableWebSocket
public class SocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer {

	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        //允许连接的域,只能以http或https开头，不限制时使用“*”号
        String[] allowsOrigins = { "*" };
		// 前台 可以使用websocket环境
		registry.addHandler(myWebSocketHandler(), "/websocket/socketServer").addInterceptors(new HandshakeInterceptor());

		// 前台 不可以使用websocket环境，则使用sockjs进行模拟连接
		registry.addHandler(myWebSocketHandler(), "/sockjs/socketServer").addInterceptors(new HandshakeInterceptor()).withSockJS();

		registry.addHandler(myHandler(), "/websocket/log").addInterceptors(new MyHandShake());//相对更稳定

		registry.addHandler(myHandler(), "/ws/sockjs/log").addInterceptors(new MyHandShake()).withSockJS();
		
        registry.addHandler(fileChatHandler(), "/websocket/up").setAllowedOrigins(allowsOrigins).addInterceptors(new HandshakeInterceptor());
        
	}

	// websocket 处理类
	@Bean
	public WebSocketHandler myWebSocketHandler() {
		return new WebsocketEndPoint();
	}
	@Bean
    public WebsocketHandler myHandler() {
        return new WebsocketHandler();
    }
	
	@Bean
    public WebSocketHandler fileChatHandler() {
        return new FileChatWebSocketHandlers();
    }
}
