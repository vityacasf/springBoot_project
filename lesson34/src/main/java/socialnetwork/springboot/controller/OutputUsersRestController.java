package socialnetwork.springboot.controller;

import socialnetwork.springboot.converter.UserConverter;
import socialnetwork.springboot.dto.UserDto;
import socialnetwork.springboot.model.User;
import socialnetwork.springboot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class OutputUsersRestController {
  private final UserService userService;
  private final UserConverter userConverter;

  @GetMapping
  protected List<UserDto> getUsers(@RequestParam(required = false) Integer pageSize,
                                   @RequestParam(required = false) Integer pageNumber) {
    List<User> users;
    users = userService.getUserFromPage(pageSize, pageNumber);
    return userConverter.toDto(users);
  }
}
