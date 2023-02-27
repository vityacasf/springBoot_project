package socialnetwork.springboot.service.storage;

import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

public interface StorageService {
  void uploadFile(InputStream stream, String fileName);

  URI getImagePath(String imageName) throws URISyntaxException;

  void deleteImage(String oldImage);
}
