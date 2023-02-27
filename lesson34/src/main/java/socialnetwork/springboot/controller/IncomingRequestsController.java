package socialnetwork.springboot.controller;

import socialnetwork.springboot.model.User;
import socialnetwork.springboot.service.FriendRequestService;
import socialnetwork.springboot.service.UserService;
import socialnetwork.springboot.session.AuthorizedUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/incomingRequests")
@RequiredArgsConstructor
public class IncomingRequestsController {
  private final UserService userService;
  private final FriendRequestService friendRequestService;
  private final AuthorizedUser authorizedUser;

  @GetMapping
  protected String getListOfUsersWithIncomingRequest(Model model) {
    List<User> listOfUsersWithIncomingRequest =
        userService.getUsersOfAllIncomingRequests(authorizedUser.getUserId());

    model.addAttribute("listOfUsersWithIncomingRequest", listOfUsersWithIncomingRequest);
    return "/IncomingRequests";
  }

  @PostMapping
  protected String deleteIncomingRequest(@RequestParam int requestUserId) {
    log.info("del friend request. Id=[{}]", requestUserId);
    friendRequestService.delRequest(requestUserId, authorizedUser.getUserId());
    return "redirect:incomingRequests";
  }
}
