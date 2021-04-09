package tn.esprit.spring.service;

import java.util.Optional;

public interface IChatRoomService {
	Optional<Integer> getChatId(int senderId, int recipientId, boolean createIfNotExist);
}
