package com.chenqinhao.parts.websocket;

import com.chenqinhao.parts.consts.WebSocketConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;

import java.util.*;

/**
 * Created by Administrator on 2017/1/9.
 */
@Component("systemWebSocketHandler")
public class SystemWebSocketHandler implements WebSocketHandler {
    private static final Logger logger = LoggerFactory.getLogger(SystemWebSocketHandler.class);
    private static Map<String, WebSocketSession> client = new HashMap<>();
    @Override
    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
        logger.debug("connectd..." + webSocketSession.getId());
        client.put(webSocketSession.getId(), webSocketSession);
    }

    @Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {
        logger.debug(webSocketMessage.toString());
        WebSocketSession session = client.get((String)webSocketMessage.getPayload());
        System.out.println(webSocketMessage.toString());
        String message =webSocketSession.getId() + "发送消息:" + (String)webSocketMessage.getPayload() + " 给" + session.getId();
        session.sendMessage(new TextMessage(message));
    }

    @Override
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {
        if(webSocketSession.isOpen()) {
            webSocketSession.close();
        }
        logger.debug("Error! connection closed...");
    }

    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
        logger.debug("connection closed... status:" + closeStatus.toString());
    }

    @Override
    public boolean supportsPartialMessages() {
        logger.debug("supportsPartialMessages...");
        return false;
    }
}
