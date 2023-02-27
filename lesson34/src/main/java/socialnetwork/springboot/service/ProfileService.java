package socialnetwork.springboot.service;

import socialnetwork.springboot.model.Profile;
import socialnetwork.springboot.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileService {
  private final ProfileRepository profileRepository;

  public Profile getProfile(int userId) {
    return profileRepository.getProfile(userId);
  }

  public void changeImage(int userId, int imageId) {
    profileRepository.changeImage(userId, imageId);
  }
}
