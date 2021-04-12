package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.ChatMessage;
import tn.esprit.spring.entities.MessageStatus;
import tn.esprit.spring.exception.ResourceNotFoundException;

public interface IChatMessageService {
	ChatMessage save(ChatMessage chatMessage) ;
	long countNewMessages(int senderId, int recipientId);
	List<ChatMessage> findChatMessages(int senderId, int recipientId) throws ResourceNotFoundException;
	ChatMessage findById(int id) throws ResourceNotFoundException;
	void updateStatuses(int senderId, int recipientId, MessageStatus status) throws ResourceNotFoundException;
}
