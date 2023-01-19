package com.socialNetwork.springboot.Service;

import com.socialNetwork.springboot.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
  private List<User> users = new ArrayList<>();

  {
    users.add(new User(1, "viktor", "12345", "user"));
  }

  public List<User> showUsers(){
    return users;
  }


}
