package com.example.chat;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;




/*
websocket Config 작성
위에서 만든 handler를 이용해서 websocket를 활성화 하기 위한 config 파일 작성
@EnableWebsocket을 작성하여 활성화
endpoint 작성 /ws/chat
CORS : setAllowedOrigins("*")작성
 */



@RequiredArgsConstructor
@Configuration
@EnableWebSocketMessageBroker
public class WebSockConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/sub");
        config.setApplicationDestinationPrefixes("/pub");

    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("ws-stomp").setAllowedOriginPatterns("*")
                .withSockJS();
    }
}
