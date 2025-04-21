package Instagram.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import Instagram.Entity.Post;

public class PostService {
    private Map<Integer, Post> posts = new HashMap<>();
    private int nextPostId = 1;

    public int uploadPost(int userId, String content, UserService userService) {
        if (userService.getUser(userId) != null && content != null && !content.trim().isEmpty()) {
            int postId = nextPostId++;
            LocalDateTime now = LocalDateTime.now();
            posts.put(postId, new Post(postId, userId, content, now));
            return postId;
        }
        return -1;
    }

    public boolean deletePost(int userId, int postId) {
        if (posts.containsKey(postId) && posts.get(postId).getUserId() == userId) {
            posts.remove(postId);
            return true;
        }
        return false;

    }

    public Post getPost(int postId) {
        return posts.get(postId);
    }

    public Map<Integer, Post> getAllPosts() {
        return posts;
    }

}
