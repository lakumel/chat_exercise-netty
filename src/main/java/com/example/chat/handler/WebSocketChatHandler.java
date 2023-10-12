package com.example.chat.handler;

import com.example.chat.chatdto.ChatMessage;
import com.example.chat.chatdto.ChatRoom;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;


/*
websocket Handler작성
socket 통신은 서버와 클라이언트가 1:n으로 관계를 맺습니다. 따라서 한서버에 여러 클라이언트가 접속할 수 있으며
서버에는 여러 클라이언트가 발송한 메세지를 받아 처리해줄 handler의 작성이 필요함
textwebsockethandler를 상속받아 handler를 작성해 줌
client로 받은 메세지를 console log로 출력하고 client로 환영 메세지를 보내줌

*/
@Slf4j
@RequiredArgsConstructor
@Component
public class WebSocketChatHandler extends TextWebSocketHandler {

    private final ObjectMapper objectMapper;


    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        log.info("payload {}", payload);
        ChatMessage chatMessage = objectMapper.readValue(payload, ChatMessage.class);
//        ChatRoom room = chatService.findRoomById(chatMessage.getRoomId());
//        room.handleActions(session, chatMessage, chatService);
}
    }









