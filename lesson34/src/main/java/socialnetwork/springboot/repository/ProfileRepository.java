package socialnetwork.springboot.repository;

import socialnetwork.springboot.model.Profile;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface ProfileRepository extends Repository<Profile, Long> {
  @Query("select u.user_id, u.login, i.image_name from \"profile\"" +
      " join \"user\" u on u.user_id = profile.user_id" +
      " join image i on i.image_id = profile.image_id" +
      " where u.user_id=:userId")
  Profile getProfile(@Param("userId") int userId);

  @Modifying
  @Query("insert into profile (user_id, image_id) values (:userId, :imageId)")
  void setNewImage(@Param("userId") int userId, @Param("imageId") int imageId);

  @Modifying
  @Query("update profile " +
      "set image_id=:imageId " +
      "where user_id=:userId")
  void changeImage(@Param("userId") int userId, @Param("imageId") int imageId);

  @Query("select image_name from image " +
      "join profile p on image.image_id = p.image_id " +
      "where p.user_id=:userId")
  void getImageByUserId(@Param("userId") int userId);
}
