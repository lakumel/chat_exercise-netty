package com.example.chat.chatdto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatMessage {



    public enum MessageType {

        ENTER, TALK
    }


        //메세지 타입
        private MessageType type;
        //방번호
        private String roomId;
        //메세지 보낸 사람
        private String sender;
        //메세지
        private String message;



}
