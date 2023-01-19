package com.socialNetwork.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
public class User {
  private long id;
  private String username;
  private String password;
  private String role;
}
