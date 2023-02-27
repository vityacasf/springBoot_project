package socialnetwork.springboot.repository;

import socialnetwork.springboot.model.User;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends Repository<User, Long> {
  @Query("select * from \"user\" where login = :login")
  User findUserByLogin(@Param("login") String login);

  @Query("insert into \"user\" (login, password) values (:login, :password)")
  @Modifying
  boolean insertNewUser(@Param("login") String login, @Param("password") String password);

  @Query("select user_id from \"user\" where login=:login")
  int getUserIdByLogin(@Param("login") String login);

  @Query("select \"user\".user_id, \"user\".login from friend_request " +
      "inner join \"user\" on sender_id = user_id " +
      "where recipient_id = :recipientId")
  List<User> getUsersOfAllIncomingRequests(@Param("recipientId") int recipientId);

  @Query("select \"user\".user_id, \"user\".login from friend_request " +
      "inner join \"user\" on recipient_id = user_id " +
      "where sender_id = :senderId")
  List<User> getUsersOfAllOutgoingRequests(@Param("senderId") int senderId);

  @Query("select user_id, login from \"user\" " +
      "join friend " +
      "on first_user_id = user_id " +
      "where second_user_id = :userId " +
      "union " +
      "select user_id, login from \"user\" " +
      "join friend " +
      "on second_user_id = user_id " +
      "where first_user_id = :userId")
  List<User> getAllFriends(@Param("userId") int userId);

  @Query("select password from \"user\" where login = :login")
  Optional<String> getUserHashedPassword(@Param("login") String login);

  @Query("select user_id, login from \"user\" where user_id = :userId")
  Optional<User> getUserById(@Param("userId") int userId);

  @Query("select * from \"user\" order by user_id asc limit :pageSize OFFSET :firstUserNumber")
  List<User> getUserFromPage(@Param("firstUserNumber") int firstUserNumber, @Param("pageSize") int pageSize);

  @Query("select count(user_id) from \"user\"")
  int getUsersCount();

  @Query("select * from \"user\" where login=:login")
  User getUserByLogin(@Param("login") String login);
  @Modifying
  @Query("update \"user\" " +
      "set password=:password " +
      "where user_id=:userId")
  void changeUserPassword(@Param("userId") int userId, @Param("password") String password);

  @Modifying
  @Query("update \"user\" " +
      "set login=:login " +
      "where user_id=:userId")
  void changeUserLogin(@Param("userId") int userId, @Param("login") String login);
}
