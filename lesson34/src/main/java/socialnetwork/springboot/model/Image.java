package socialnetwork.springboot.model;


import lombok.Builder;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Value
@Builder
@Table("image")
public class Image {
  @Id
  @Column("image_id")
  int imageId;
  @Column("image_name")
  String imageName;
}
