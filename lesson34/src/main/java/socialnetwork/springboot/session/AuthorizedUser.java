package socialnetwork.springboot.session;

import lombok.Data;

@Data
public class AuthorizedUser {
  private Integer userId;
  private String login;
}
