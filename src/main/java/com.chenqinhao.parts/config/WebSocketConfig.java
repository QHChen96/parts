package com.chenqinhao.parts.config;

import com.chenqinhao.parts.websocket.interceptor.WebSocketHandshakeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * Created by Administrator on 2017/1/9.
 */
@Configuration
@EnableWebSocket
@ComponentScan("com.chenqinhao.parts.websocket")
public class WebSocketConfig implements WebSocketConfigurer{
    @Autowired
    private WebSocketHandler systemWebSocketHandler;
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(systemWebSocketHandler, "/webSocketServer")
                .addInterceptors(new WebSocketHandshakeInterceptor());
        webSocketHandlerRegistry.addHandler(systemWebSocketHandler, "/sockjs/webSocketServer")
                .addInterceptors(new WebSocketHandshakeInterceptor()).withSockJS();
    }

}
