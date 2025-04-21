package Instagram;

import java.util.List;

import Instagram.Entity.Post;
import Instagram.Service.FeedService;
import Instagram.Service.FollowService;
import Instagram.Service.PostService;
import Instagram.Service.UserService;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        FollowService followService = new FollowService();
        PostService postService = new PostService();
        FeedService feedService = new FeedService(userService, postService, followService);

        int user1Id = userService.addUser("john_doe", "John Doe", "john.doe@example.com");
        int user2Id = userService.addUser("jane_smith", "Jane Smith", "jane.smith@example.com");
        int user3Id = userService.addUser("alice_wonder", "Alice Wonder", "alice.wonder@example.com");

        // Initialize follow data for each user.
        followService.initializeUserFollowData(user1Id);
        followService.initializeUserFollowData(user2Id);
        followService.initializeUserFollowData(user3Id);

        // Follow users
        followService.followUser(user1Id, user2Id, userService);
        followService.followUser(user1Id, user3Id, userService);
        followService.followUser(user2Id, user3Id, userService);

        // Upload posts
        postService.uploadPost(user1Id, "Hello, world!", userService);
        postService.uploadPost(user2Id, "Having a great day!", userService);
        postService.uploadPost(user3Id, "Learning new things.", userService);
        postService.uploadPost(user1Id, "Another post by John.", userService);
        postService.uploadPost(user2Id, "Check this out!", userService);
        postService.uploadPost(user3Id, "Coding is fun!", userService);
        postService.uploadPost(user1Id, "Last post for now.", userService);
        postService.uploadPost(user2Id, "Thinking about the weekend.", userService);
        postService.uploadPost(user3Id, "Almost Friday!", userService);
        postService.uploadPost(user1Id, "One more thought.", userService);
        postService.uploadPost(user2Id, "Weekend vibes.", userService);
        postService.uploadPost(user3Id, "Friday!", userService);

        // Get user 1's news feed
        System.out.println("User 1's News Feed:");
        List<Post> user1Feed = feedService.getNewsFeed(user1Id);
        for (Post post : user1Feed) {
            System.out.println(userService.getUser(post.getUserId()).getUsername() + ": " + post.getContent());
        }
        System.out.println();

        // Delete a post by user 1
        int postToDelete = -1;
        for (Post post : user1Feed) {
            if (post.getContent().equals("Hello, world!")) {
                postToDelete = post.getPostId();
                break;
            }
        }
        if (postToDelete != -1) {
            postService.deletePost(user1Id, postToDelete);
            System.out.println("Deleted post by User 1.");
        }
        System.out.println();

        // Get user 1's news feed after deletion
        System.out.println("User 1's News Feed after deletion:");
        List<Post> user1FeedAfterDelete = feedService.getNewsFeed(user1Id);
        for (Post post : user1FeedAfterDelete) {
            System.out.println(userService.getUser(post.getUserId()).getUsername() + ": " + post.getContent());
        }
        System.out.println();

        // User 1 unfollows User 2
        followService.unfollowUser(user1Id, user2Id, userService);
        System.out.println("User 1 unfollowed User 2.");
        System.out.println();

        // Get user 1's news feed after unfollowing
        System.out.println("User 1's News Feed after unfollowing User 2:");
        List<Post> user1FeedAfterUnfollow = feedService.getNewsFeed(user1Id);
        for (Post post : user1FeedAfterUnfollow) {
            System.out.println(userService.getUser(post.getUserId()).getUsername() + ": " + post.getContent());
        }
        System.out.println();

        // Get user 2's news feed
        System.out.println("User 2's News Feed:");
        List<Post> user2Feed = feedService.getNewsFeed(user2Id);
        for (Post post : user2Feed) {
            System.out.println(userService.getUser(post.getUserId()).getUsername() + ": " + post.getContent());
        }
        System.out.println();

    }
}
