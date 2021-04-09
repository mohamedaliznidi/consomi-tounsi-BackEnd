package tn.esprit.spring.repositry;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.entities.ChatMessage;
import tn.esprit.spring.entities.MessageStatus;


public interface ChatMessageRepository extends JpaRepository<ChatMessage, Integer> {

	long countBySenderIdAndRecipientIdAndStatus(int senderId, int recipientId, MessageStatus status);

	List<ChatMessage> findByChatId(int chatId);

	List<ChatMessage> findBySenderIdAndRecipientId(int senderId, int recipientId);
}
