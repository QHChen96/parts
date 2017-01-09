package com.chenqinhao.parts.websocket;

import com.chenqinhao.parts.consts.WebSocketConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;


/**
 * Created by Administrator on 2017/1/9.
 */
@Component("systemWebSocketHandler")
public class SystemWebSocketHandler implements WebSocketHandler{
    private static final Logger logger = LoggerFactory.getLogger(SystemWebSocketHandler.class);
    @Override
    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
        logger.debug("connect to the websocket success...");
        webSocketSession.sendMessage(new TextMessage("OK"));
    }

    @Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {
        logger.debug("message:" + webSocketMessage.toString());
        for (int i = 0; i < 10; i++){
            webSocketSession.sendMessage(new TextMessage(0+""));
            Thread.sleep(2000);
        }
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
