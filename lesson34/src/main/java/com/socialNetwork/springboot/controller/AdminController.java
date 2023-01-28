package com.socialNetwork.springboot.controller;

import com.socialNetwork.springboot.Service.UserService;
import com.socialNetwork.springboot.converter.UserConverter;
import com.socialNetwork.springboot.dto.UserDto;
import com.socialNetwork.springboot.model.AppUser;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/admins")
@RestController
@RequiredArgsConstructor
public class AdminController {

  private final UserService userService;
  private final UserConverter userConverter;

  @GetMapping("/{id}")
  public UserDto get(@PathVariable final Long id) {
    final AppUser user = userService.getUser(id);
    return userConverter.toDto(user);
  }

}
