package Instagram.Entity;

import java.time.LocalDateTime;

public class Post {
    private int postId;
    private int userId;
    private String content;
    private LocalDateTime timestamp;

    public Post(int postId, int userId, String content, LocalDateTime timestamp) {
        this.postId = postId;
        this.userId = userId;
        this.content = content;
        this.timestamp = timestamp;
    }

    public int getPostId() {
        return postId;
    }

    public int getUserId() {
        return userId;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", userId=" + userId +
                ", content='" + (content.length() > 20 ? content.substring(0, 20) + "..." : content) + // limit to 20 chars
                ", timestamp=" + timestamp +
                "}";
    }
}
