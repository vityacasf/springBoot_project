package socialnetwork.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;
import socialnetwork.springboot.session.AuthorizedUser;

@Configuration
public class SessionConfig {
  @Bean
  @Scope(
      value = WebApplicationContext.SCOPE_SESSION,
      proxyMode = ScopedProxyMode.TARGET_CLASS)
  public AuthorizedUser authorizedUser() {
    return new AuthorizedUser();
  }
}
