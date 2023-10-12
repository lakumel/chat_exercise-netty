package com.example.chat.chatroomcontroller;


import com.example.chat.chatdto.ChatRoom;
import com.example.chat.chatrepository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Log4j2
@Controller
@RequestMapping("/chat")
public class ChatRoomController {

    private final ChatRoomRepository chatRoomRepository;

    @GetMapping("room")
    public String rooms(Model model) {
        log.info("로그 찍어라");

        return "/chat/room";

    }

    @GetMapping("/rooms")
    @ResponseBody
    public List<ChatRoom>room(){return chatRoomRepository.findAllRoom();}

    @PostMapping("/room")
    @ResponseBody
    public ChatRoom createRoom(@RequestParam String name){
        return chatRoomRepository.createChatRoom(name);
    }

    @GetMapping("/room/enter/{roomId}")
    public String roomDetail(Model model, @PathVariable String roomId){
        model.addAttribute("roomId", roomId);
        return "/chat/roomdetail";
    }

    @GetMapping("/room/{roomId}")
    @ResponseBody
    public ChatRoom roomInfo(@PathVariable String roomId){return  chatRoomRepository.findRoomById(roomId);}

}
