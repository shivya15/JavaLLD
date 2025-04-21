package Instagram.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Instagram.Entity.Post;

public class FeedService {
    private UserService userService;
    private PostService postService;
    private FollowService followService;

    public FeedService(UserService userService, PostService postService, FollowService followService) {
        this.userService = userService;
        this.postService = postService;
        this.followService = followService;
    }

    public List<Post> getNewsFeed(int userId) {
        if (userService.getUser(userId) == null) {
            return new ArrayList<>();
        }

        Set<Integer> relevantUserIds = new HashSet<>(followService.getFollowing(userId));
        relevantUserIds.add(userId);

        List<Post> feed = new ArrayList<>();
        for (Post post : postService.getAllPosts().values()) {
            if (relevantUserIds.contains(post.getUserId())) {
                feed.add(post);
            }
        }

        feed.sort(Comparator.comparing(Post::getTimestamp).reversed());
        return feed.subList(0, Math.min(10, feed.size()));
    }

}
