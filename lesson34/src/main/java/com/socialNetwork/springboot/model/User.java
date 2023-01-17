package com.socialNetwork.springboot.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class User {
  long id;
  String username;
  String password;
  String role;
}
