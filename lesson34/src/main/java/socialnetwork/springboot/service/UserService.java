package socialnetwork.springboot.service;

import socialnetwork.springboot.model.User;
import socialnetwork.springboot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  private static final int DEFAULT_PAGE_SIZE = 10;
  private static final int DEFAULT_PAGE_NUMBER = 1;

  public boolean register(String username, String password) {

    if (isExists(username)) {
      return false;
    }
    String encryptedPassword = passwordEncoder.encode(password);

    userRepository.insertNewUser(username, encryptedPassword);
    return true;
  }

  public boolean isExists(String username, String password) {
    Optional<String> encryptedPassword = userRepository.getUserHashedPassword(username);
    return encryptedPassword.filter(hash ->  passwordEncoder.matches(password, hash)).isPresent();
  }

  public boolean isExists(String login) {
    return userRepository.findUserByLogin(login) != null;
  }

  public int getUserIdByLogin(String login) {
    return userRepository.getUserIdByLogin(login);
  }

  public List<User> getUsersOfAllOutgoingRequests(int senderId) {
    return userRepository.getUsersOfAllOutgoingRequests(senderId);
  }

  public List<User> getAllFriends(int userId) {
    return userRepository.getAllFriends(userId);
  }

  public List<User> getUsersOfAllIncomingRequests(int recipientId) {
    return userRepository.getUsersOfAllIncomingRequests(recipientId);
  }

  public Optional<User> getUserById(int id) {
    return userRepository.getUserById(id);
  }

  public List<User> getUserFromPage(Integer pageSize, Integer pageNumber) {
    if (pageSize != null && pageNumber != null) {
      return userRepository.getUserFromPage((pageNumber - 1) * pageSize, pageSize);
    }
    return userRepository.getUserFromPage(0, DEFAULT_PAGE_SIZE);
  }

  public int getPageCount(Integer pageSize) {
    if (pageSize != null) {
      return Math.round((float) getUsersCount() / pageSize);
    }
    return Math.round((float) getUsersCount() / DEFAULT_PAGE_SIZE);
  }

  private int getUsersCount() {
    return userRepository.getUsersCount();
  }

  public User getUserByLogin(String login) {
    return userRepository.getUserByLogin(login);
  }

  public void changeUserPassword(int userId, String password) {
    userRepository.changeUserPassword(userId, passwordEncoder.encode(password));
  }

  public void changeUserLogin(int userId, String login) {
    userRepository.changeUserLogin(userId, login);
  }
}
