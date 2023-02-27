package socialnetwork.springboot.controller;

import socialnetwork.springboot.service.FriendService;
import socialnetwork.springboot.session.AuthorizedUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequiredArgsConstructor
public class FriendController {
  private final FriendService friendService;
  private final AuthorizedUser authorizedUser;

  @PostMapping(path = "/deleteFriend")
  protected String deleteFriend(int friendId) {
    friendService.delFriend(authorizedUser.getUserId(), friendId);
    log.info("Delete friend. Id=[{}]", friendId);
    return "redirect:friendList";
  }

  @PostMapping(path = "/addFriend")
  protected String addFriend(@RequestParam int friendId) {
    friendService.addFriend(friendId, authorizedUser.getUserId());
    log.info("Add new friend. Id=[{}]", friendId);
    return "redirect:incomingRequests";
  }
}
