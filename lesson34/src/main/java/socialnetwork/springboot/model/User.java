package socialnetwork.springboot.model;

import lombok.Builder;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Value
@Builder
@Table("user")
public class User {
  @Id
  @Column("user_id")
  int userId;
  String login;
  String password;
}
