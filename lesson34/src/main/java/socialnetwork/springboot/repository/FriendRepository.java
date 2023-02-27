package socialnetwork.springboot.repository;

import socialnetwork.springboot.model.User;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface FriendRepository extends Repository<User, Long> {
  @Modifying
  @Query("insert into friend (first_user_id, second_user_id) values ( :senderId, :recipientId)")
  boolean addFriend(@Param("senderId") int senderId, @Param("recipientId") int recipientId);

  @Modifying
  @Query("delete from friend " +
      "where first_user_id = :userId and second_user_id = :friendId " +
      "or first_user_id = :friendId and second_user_id = :userId")
  boolean delFriend(@Param("userId") int userId, @Param("friendId") int friendId);
}
