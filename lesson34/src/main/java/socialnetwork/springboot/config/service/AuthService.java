package socialnetwork.springboot.config.service;

import socialnetwork.springboot.model.User;
import socialnetwork.springboot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService implements UserDetailsService {
  private final UserService userService;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    final User user = userService.getUserByLogin(username);
    return new org.springframework.security.core.userdetails.User(
        user.getLogin(),
        user.getPassword(),
        List.of(new SimpleGrantedAuthority("ROLE_USER")));
  }
}
