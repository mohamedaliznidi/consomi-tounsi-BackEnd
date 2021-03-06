package tn.esprit.spring.controler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;



import tn.esprit.spring.entities.*;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ChatController {


    @MessageMapping("/chat.newUser")
    @SendTo("/topic/public")
    public ChatMessage register(@Payload final ChatMessage chatMessage,SimpMessageHeaderAccessor headerAccessor) {
    	headerAccessor.getSessionAttributes().put("username",chatMessage.getSender());
    	return chatMessage;
    }
    
    @MessageMapping("/chat.send")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload final ChatMessage chatMessage) {
    	
    	return chatMessage;
    }


}


