package socialnetwork.springboot.service;

import socialnetwork.springboot.repository.FriendRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FriendRequestService {
  private final FriendRequestRepository friendRequestRepository;

  public boolean friendRequestIsExists(int senderId, int recipientId) {
    return friendRequestRepository.getFriendRequest(senderId, recipientId) != null;
  }

  public boolean createRequest(int senderId, int recipientId) {
    return friendRequestRepository.createRequest(senderId, recipientId);
  }

  public boolean delRequest(int senderId, int recipientId) {
    return friendRequestRepository.delFriendRequest(senderId, recipientId);
  }
}
