package tn.esprit.spring.controler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;

import tn.esprit.spring.entities.Message;
import tn.esprit.spring.entities.OutputMessage;

public class MessageController {
	@MessageMapping("/chat")
	@SendTo("/topic/messages")
	public OutputMessage send(Message message) throws Exception {
	    String time = new SimpleDateFormat("HH:mm").format(new Date());
	    return new OutputMessage(message.getFromLogin(), message.getMessage(), time);
	}
}
