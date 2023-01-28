package com.socialNetwork.springboot.model;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class AppUser {

  long id;
  String username;
  String password;
  String role;

}