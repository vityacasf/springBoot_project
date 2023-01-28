package com.socialNetwork.springboot.controller;

import com.socialNetwork.springboot.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
@RequiredArgsConstructor
public class ApplicationController {
  private final UserService userService;

  @GetMapping("/home")
  public String home(Model model) {
    model.addAttribute("title", "Главная страница");
    return "home";
  }
  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @GetMapping("/registration")
  public String registration() {
    return "registration";
  }

}
