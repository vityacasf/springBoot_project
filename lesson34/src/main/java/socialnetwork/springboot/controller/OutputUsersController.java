package socialnetwork.springboot.controller;

import socialnetwork.springboot.model.User;
import socialnetwork.springboot.service.UserService;
import socialnetwork.springboot.session.AuthorizedUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class OutputUsersController {
  private final UserService userService;
  private final AuthorizedUser authorizedUser;

  @GetMapping
  protected String outputUsers(Model model,
                               @RequestParam(required = false) Integer pageSize,
                               @RequestParam(required = false) Integer pageNumber) {
    List<User> users;
    users = userService.getUserFromPage(pageSize, pageNumber);

    int pageCount = userService.getPageCount(pageSize);

    model.addAttribute("pageCount", pageCount);
    model.addAttribute("pageSize", pageSize);
    model.addAttribute("pageNumber", pageNumber);
    model.addAttribute("login", authorizedUser.getLogin());
    model.addAttribute("users", users);
    return "/Users";
  }
}
