package socialnetwork.springboot.converter;

import socialnetwork.springboot.dto.UserDto;
import socialnetwork.springboot.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface UserConverter {
  List<UserDto> toDto(List<User> users);
}
