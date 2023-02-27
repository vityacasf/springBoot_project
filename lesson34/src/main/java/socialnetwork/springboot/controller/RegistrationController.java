package socialnetwork.springboot.controller;

import socialnetwork.springboot.dto.AuthorizationUserDto;
import socialnetwork.springboot.service.ImageService;
import socialnetwork.springboot.service.ProfileService;
import socialnetwork.springboot.service.UserService;
import socialnetwork.springboot.session.AuthorizedUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Slf4j
@Controller
@RequiredArgsConstructor
public class RegistrationController {
  private final UserService userService;
  private final AuthorizedUser authorizedUser;
  private final ProfileService profileService;
  private final ImageService imageService;

  @GetMapping(path = "/registrationPage")
  protected String userRegistration(Model model) {

    model.addAttribute("dto", new AuthorizationUserDto());
    return "Registration";
  }

  @PostMapping(path = "/registration", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
  protected String registerNewUser(
      Model model,
      @Valid @ModelAttribute("dto") AuthorizationUserDto dto,
      BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return "Registration";
    }
    String username = dto.getLogin();
    String password = dto.getPassword();

    if (userService.register(username, password)) {
      log.info("User does not exist, registering a new user. Login[{}]", username);

      authorizedUser.setUserId(userService.getUserIdByLogin(dto.getLogin()));
      authorizedUser.setLogin(username);

      imageService.setPlaceholder(authorizedUser.getUserId());
      return "redirect:users";
    } else {
      log.info("User is already to exist. Login[{}]", username);
      String error = "User is already to exist";
      model.addAttribute("error", error);
      return "Authorization";
    }
  }
}
