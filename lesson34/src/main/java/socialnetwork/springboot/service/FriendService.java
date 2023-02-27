package socialnetwork.springboot.service;

import socialnetwork.springboot.repository.FriendRepository;
import socialnetwork.springboot.repository.FriendRequestRepository;
import socialnetwork.springboot.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FriendService {
  private final FriendRequestRepository friendRequestRepository;
  private final FriendRepository friendRepository;
  private final MessageRepository messageRepository;

  public boolean addFriend(int senderId, int recipientId) {
    friendRequestRepository.delFriendRequest(senderId, recipientId);
    return friendRepository.addFriend(senderId, recipientId);
  }

  public boolean delFriend(int userId, int friendId) {
    messageRepository.delAllMessages(userId, friendId);
    return friendRepository.delFriend(userId, friendId);
  }

}
