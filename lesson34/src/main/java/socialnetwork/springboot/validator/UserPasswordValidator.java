package socialnetwork.springboot.validator;

import socialnetwork.springboot.dto.AuthorizationUserDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserPasswordValidator implements ConstraintValidator<ValidUserDto, AuthorizationUserDto> {
  @Override
  @SuppressWarnings("PMD")
  public boolean isValid(AuthorizationUserDto dto, ConstraintValidatorContext context) {
    if (dto.getConfirmationPassword() == null) {
      return true;
    }
    if (dto.getPassword().equals(dto.getConfirmationPassword())) {
      return true;
    }
    return false;
  }

}
