package tn.esprit.spring.service;

/*import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.ChatRoom;
import tn.esprit.spring.repositry.ChatRoomRepository;

@Service
public class ChatRoomServiceImpl implements IChatRoomService {

	@Autowired private ChatRoomRepository chatRoomRepository;
	@Override
	public Optional<Integer> getChatId(int senderId, int recipientId, boolean createIfNotExist) {
		return chatRoomRepository
				.findBySenderIdAndRecipientId(senderId, recipientId)
				.map(ChatRoom::getChatId)
				.or(() -> {
					if(!createIfNotExist) {
						return  Optional.empty();
					}
					int chatId = Integer.parseInt(Integer.toString(senderId) + Integer.toString(recipientId));

					ChatRoom senderRecipient = new ChatRoom
							.Builder()
							.chatId(chatId)
							.senderId(senderId)
							.recipientId(recipientId)
							.build();

					ChatRoom recipientSender =new ChatRoom
							.Builder()
							.chatId(chatId)
							.senderId(recipientId)
							.recipientId(senderId)
							.build();
					chatRoomRepository.save(senderRecipient);
					chatRoomRepository.save(recipientSender);

					return Optional.of(chatId);
				});
	}

}*/
