package com.example.chat.chatrepository;

import com.example.chat.chatdto.ChatRoom;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ChatRoomRepository {

    private Map<String, ChatRoom>chatRoomMap;

    @PostConstruct
    private void init(){
        chatRoomMap = new LinkedHashMap<>();
    }
    public List<ChatRoom>findAllRoom() {
        List chatRooms = new ArrayList<>(chatRoomMap.values());
        Collections.reverse(chatRooms);

        return chatRooms;
    }

    public ChatRoom findRoomById(String id){return chatRoomMap.get(id);}

    public ChatRoom createChatRoom(String name){
        ChatRoom chatRoom = new ChatRoom().create(name);
        chatRoomMap.put(chatRoom.getRoomId(),chatRoom);
        return chatRoom;
    }





}
