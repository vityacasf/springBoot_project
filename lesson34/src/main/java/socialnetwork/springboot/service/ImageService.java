package socialnetwork.springboot.service;

import socialnetwork.springboot.repository.ImageRepository;
import socialnetwork.springboot.repository.ProfileRepository;

import socialnetwork.springboot.service.storage.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

@Service
@RequiredArgsConstructor
public class ImageService {
  private final StorageService storageService;
  private final ProfileRepository profileRepository;
  private final ImageRepository imageRepository;
  private static final String PLACEHOLDER_NAME = "Placeholder.png";

  public void upload(InputStream stream, String fileName) {
    storageService.uploadFile(stream, fileName);
  }

  public void setPlaceholder(int userId) {
    int imageId = imageRepository.createNewImage(PLACEHOLDER_NAME);
    profileRepository.setNewImage(userId, imageId);
  }

  public URI getImagePath(String imageName) throws URISyntaxException {
    return storageService.getImagePath(imageName);
  }

  public String getImageByUserId(int userId) {
    return imageRepository.getImageByUserId(userId);
  }

  public int createNewImage(String imageName) {
    return imageRepository.createNewImage(imageName);
  }

  public void deleteImage(String imageName) {
    storageService.deleteImage(imageName);
  }
}
