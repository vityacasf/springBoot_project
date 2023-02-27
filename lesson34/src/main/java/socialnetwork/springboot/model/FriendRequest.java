package socialnetwork.springboot.model;

import lombok.Builder;
import lombok.Value;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Value
@Builder
@Table("friend_request")
public class FriendRequest {
  @Column("request_id")
  int requestId;
  @Column("sender_id")
  int senderId;
  @Column("recipient_id")
  int recipientId;
}
