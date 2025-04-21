package Instagram.Entity;

import java.time.LocalDateTime;

public class FeedItem {
    private int postId;
    private int userId;
    private LocalDateTime timestamp;

    public FeedItem(int postId, int userId, LocalDateTime timestamp) {
        this.postId = postId;
        this.userId = userId;
        this.timestamp = timestamp;
    }

    public int getPostId() {
        return postId;
    }

    public int getUserId() {
        return userId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
