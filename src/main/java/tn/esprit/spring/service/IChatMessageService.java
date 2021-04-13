package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.ChatMessage;
import tn.esprit.spring.entities.MessageStatus;
import tn.esprit.spring.exception.ResourceNotFoundException;

public interface IChatMessageService {
	ChatMessage save(ChatMessage chatMessage) ;
	long countNewMessages(String senderId, String recipientId);
	List<ChatMessage> findChatMessages(String senderId, String recipientId) throws ResourceNotFoundException;
	ChatMessage findById(int id) throws ResourceNotFoundException;
	void updateStatuses(String senderId, String recipientId, MessageStatus status) throws ResourceNotFoundException;
}
