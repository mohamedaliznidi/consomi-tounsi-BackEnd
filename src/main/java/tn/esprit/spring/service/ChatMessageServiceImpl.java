package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.repositry.ChatMessageRepository;

import tn.esprit.spring.entities.ChatMessage;
import tn.esprit.spring.entities.MessageStatus;
import tn.esprit.spring.exception.ResourceNotFoundException;

@Service
public class ChatMessageServiceImpl implements IChatMessageService {

	@Autowired private ChatMessageRepository repository;
	@Autowired private ChatRoomServiceImpl chatRoomService;

	@Override
	public ChatMessage save(ChatMessage chatMessage) {
		chatMessage.setStatus(MessageStatus.RECEIVED);
		repository.save(chatMessage);
		return chatMessage;
	}

	@Override
	public long countNewMessages(int senderId, int recipientId) {
		return repository.countBySenderIdAndRecipientIdAndStatus(
				senderId, recipientId, MessageStatus.RECEIVED);
	}

	@Override
	public List<ChatMessage> findChatMessages(int senderId, int recipientId) throws ResourceNotFoundException {
		var chatId = chatRoomService.getChatId(senderId, recipientId, false);

		var messages =
				chatId.map(cId -> repository.findByChatId(cId)).orElse(new ArrayList<>());

		if(messages.size() > 0) {
			updateStatuses(senderId, recipientId, MessageStatus.DELIVERED);
		}

		return messages;
	}

	@Override
	public ChatMessage findById(int id) throws ResourceNotFoundException {
		return repository
				.findById(id)
				.map(chatMessage -> {
					chatMessage.setStatus(MessageStatus.DELIVERED);
					return repository.save(chatMessage);
				})
				.orElseThrow(() ->
				new ResourceNotFoundException("can't find message (" + id + ")"));
	}

	@Override
	public void updateStatuses(int senderId,int recipientId,MessageStatus status)  throws ResourceNotFoundException {
		Optional<ChatMessage> msgs = repository.findBySenderIdAndRecipientId(senderId,recipientId);
		msgs.map(chatMessage -> {
			chatMessage.setStatus(status);
			return repository.save(chatMessage);
		})
		.orElseThrow(() ->
		new ResourceNotFoundException("can't find message from(" + senderId + ") to (" + recipientId + ")"));
	}

}
