package socialnetwork.springboot.controller;

import socialnetwork.springboot.facade.ProfileServiceFacade;
import socialnetwork.springboot.model.Profile;
import socialnetwork.springboot.service.ImageService;
import socialnetwork.springboot.session.AuthorizedUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@Controller
@RequiredArgsConstructor
public class ProfileController {
  private final ImageService imageService;
  private final AuthorizedUser authorizedUser;
  private final ProfileServiceFacade profileServiceFacade;

  @GetMapping("/profile/{userId}")
  protected String outputUserProfile(@PathVariable int userId, Model model) throws URISyntaxException {
    Profile profile = profileServiceFacade.getProfile(userId);
    URI imageUrl = imageService.getImagePath(profile.getImageName());

    if (authorizedUser.getUserId() == userId) {
      model.addAttribute("rightsToChange", true);
    } else {
      model.addAttribute("rightsToChange", false);
    }

    model.addAttribute("imageUrl", imageUrl);
    model.addAttribute("profile", profile);
    return "Profile";
  }

  @GetMapping("/profile/{userId}/edit")
  protected String profileEditPage(Model model,
                                   @PathVariable int userId) {
    model.addAttribute("userId", userId);
    return "EditProfile";
  }

  @PostMapping("/profile/{userId}/edit")
  protected String editProfile(@PathVariable int userId,
                               @RequestParam(required = false) String login,
                               @RequestParam(required = false) String password,
                               @RequestParam(required = false, name = "file") MultipartFile file
  ) throws IOException {
    profileServiceFacade.editProfile(userId, login, password, file);
    return "redirect:/profile/" + userId;
  }
}
