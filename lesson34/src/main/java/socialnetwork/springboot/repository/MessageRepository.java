package socialnetwork.springboot.repository;

import socialnetwork.springboot.dto.MessageDto;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageRepository extends Repository<MessageDto, Long> {
  @Query("select sender_id, recipient_id, text from message " +
      " where sender_id = :userId and recipient_id = :friendId " +
      "or sender_id = :friendId and recipient_id = :userId")
  List<MessageDto> getMessages(@Param("userId") int userId, @Param("friendId") int friendId);

  @Query("insert into message (sender_id, recipient_id, text) values ( :senderId, :recipientId, :text)")
  @Modifying
  void saveMessage(@Param("senderId") int senderId,
                   @Param("recipientId") int recipientId,
                   @Param("text") String text);

  @Query("delete from message " +
      "where sender_id = :senderId " +
      "and recipient_id = :recipientId " +
      "or sender_id = :recipientId " +
      "and recipient_id = :senderId")
  @Modifying
  void delAllMessages(@Param("senderId") int senderId, @Param("recipientId") int recipientId);
}
