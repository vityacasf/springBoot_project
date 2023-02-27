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
@RequestMapping("/outgoingRequest")
@RequiredArgsConstructor
public class OutgoingRequestController {
  private final UserService userService;
  private final FriendRequestService friendRequestService;
  private final AuthorizedUser authorizedUser;

  @GetMapping
  protected String getUsersOfAllOutgoingRequests(Model model) {
    List<User> listOfUsersWithOutgoingRequest =
        userService.getUsersOfAllOutgoingRequests(authorizedUser.getUserId());

    model.addAttribute("listOfUsersWithOutgoingRequest", listOfUsersWithOutgoingRequest);
    return "/OutgoingRequests";
  }

  @PostMapping
  protected String deleteFriendRequest(@RequestParam int requestUserId) {

    log.info("del friend request. Id=[{}]", authorizedUser.getUserId());
    friendRequestService.delRequest(authorizedUser.getUserId(), requestUserId);
    return "redirect:outgoingRequest";
  }
}
