package tn.esprit.spring.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;

import tn.esprit.spring.entities.ChatMessage;
import tn.esprit.spring.entities.ChatMessage.MessageType;



@Component
public class WebSocketEventListener {
	
	@Autowired private SimpMessageSendingOperations sendingOperations;
	
	private static final Logger Log = LogManager.getLogger(WebSocketEventListener.class);
	
	@EventListener
	public void handleWevSocketConnectListener(final SessionConnectedEvent event) {
		Log.info("checking connection");
	}
	
	@EventListener
	public void handleWevSocketDisconnectListener(final SessionConnectedEvent event) {
		final StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
		
		final String username = (String) headerAccessor.getSessionAttributes().get("username");
		
		final ChatMessage chatMessage = new ChatMessage.Builder()
				.type(MessageType.DISCONNECT)
				.sender(username)
				.build();
		sendingOperations.convertAndSend("/topic/public",chatMessage);
	}
}
