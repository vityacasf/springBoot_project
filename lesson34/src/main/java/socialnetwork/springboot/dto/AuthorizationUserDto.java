package socialnetwork.springboot.dto;

import socialnetwork.springboot.validator.ValidUserDto;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@ValidUserDto
public class AuthorizationUserDto {
  @NotEmpty(message = "Login should not be empty")
  private String login;
  @NotEmpty(message = "Password should not be empty")
  private String password;
  private String confirmationPassword;
}
