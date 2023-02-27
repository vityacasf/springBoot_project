package socialnetwork.springboot.config.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.MalformedJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Slf4j
@Component
public class Jwt {
  @Value("${salt}")
  private String jwtSecret;

  public String generateToken(String login) {
    Date date = Date.from(LocalDateTime.now().plusMinutes(15).atZone(ZoneId.systemDefault()).toInstant());
    return Jwts.builder()
        .setSubject(login)
        .setExpiration(date)
        .signWith(SignatureAlgorithm.HS512, jwtSecret)
        .compact();
  }

  @SuppressWarnings("PMD")
  public boolean validateToken(String token) {
    try {
      Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
      return true;
    } catch (ExpiredJwtException expEx) {
      log.info("Token expired");
    } catch (UnsupportedJwtException unsEx) {
      log.info("Unsupported jwt");
    } catch (MalformedJwtException mjEx) {
      log.info("Malformed jwt");
    } catch (SignatureException sEx) {
      log.info("Invalid signature");
    } catch (Exception e) {
      log.info("invalid token");
    }
    return false;
  }

  public String getLoginFromToken(String token) {
    Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
    return claims.getSubject();
  }
}
