package tn.esprit.spring.repositry;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.ChatRoom;

@Repository
public interface ChatRoomRepository extends JpaRepository<ChatRoom, Integer> {
	Optional<ChatRoom> findBySenderIdAndRecipientId(int senderId, int recipientId);
}
