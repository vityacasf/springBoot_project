package socialnetwork.springboot.service;

import socialnetwork.springboot.dto.MessageDto;
import socialnetwork.springboot.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {
  private final MessageRepository messageRepository;

  public List<MessageDto> getMessages(int userId, int friendId) {
    return messageRepository.getMessages(userId, friendId);
  }

  public void saveMessage(int senderId, int recipientId, String text) {
    messageRepository.saveMessage(senderId, recipientId, text);
  }

  public void delAllMessages(int senderId, int recipientId) {
    messageRepository.delAllMessages(senderId, recipientId);
  }
}
