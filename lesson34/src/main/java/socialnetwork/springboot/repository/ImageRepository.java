package socialnetwork.springboot.repository;

import socialnetwork.springboot.model.Image;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface ImageRepository extends Repository<Image, Long> {
  @Query("insert into image (image_name) values (:imageName) returning image_id")
  int createNewImage(@Param("imageName") String imageName);

  @Query("select image_name from image " +
      "join profile p on image.image_id = p.image_id " +
      "where p.user_id=:userId")
  String getImageByUserId(@Param("userId") int userId);
}
