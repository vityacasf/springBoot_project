package socialnetwork.springboot.controller;

import socialnetwork.springboot.service.FriendRequestService;
import socialnetwork.springboot.session.AuthorizedUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequestMapping("/friendRequest")
@RequiredArgsConstructor
public class FriendRequestController {
  private final FriendRequestService friendRequestService;
  private final AuthorizedUser authorizedUser;

  @PostMapping
  protected String sendFriendRequest(@RequestParam int recipientId) {

    if (friendRequestService.friendRequestIsExists(authorizedUser.getUserId(), recipientId)) {
      log.info("Request is exists. Id=[{}]", recipientId);
    } else {
      friendRequestService.createRequest(authorizedUser.getUserId(), recipientId);
      log.info(
          "Request not exists. Create new request senderId=[{}] recipientId=[{}]",
          authorizedUser.getUserId(),
          recipientId
      );
    }
    return "redirect:users";
  }
}
