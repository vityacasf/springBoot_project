package socialnetwork.springboot.repository;

import socialnetwork.springboot.model.FriendRequest;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface FriendRequestRepository extends Repository<FriendRequest, Long> {
  @Query("select * from friend_request where sender_id = :senderId and recipient_id = :recipientId")
  FriendRequest getFriendRequest(@Param("senderId") int senderId, @Param("recipientId") int recipientId);

  @Modifying
  @Query("insert into friend_request (sender_id, recipient_id) values (:senderId, :recipientId)")
  boolean createRequest(@Param("senderId") int senderId, @Param("recipientId") int recipientId);

  @Modifying
  @Query("delete from friend_request where sender_id = :senderId and recipient_id = :recipientId")
  boolean delFriendRequest(@Param("senderId") int senderId, @Param("recipientId") int recipientId);
}
