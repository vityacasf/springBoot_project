package socialnetwork.springboot.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Profile {
  int userId;
  String login;
  String imageName;
}
