package Instagram.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FollowService {
    private Map<Integer, List<Integer>> followers = new HashMap<>(); // userId -> List of followerIds
    private Map<Integer, List<Integer>> following = new HashMap<>();

    public void initializeUserFollowData(int userId) {
        followers.put(userId, new ArrayList<>());
        following.put(userId, new ArrayList<>());
    }

    public void followUser(int userId, int followUserId, UserService userService) {
        if (userService.getUser(userId) != null && userService.getUser(followUserId) != null && userId != followUserId) {
            following.get(userId).add(followUserId);
            followers.get(followUserId).add(userId);
        }
    }

    public void unfollowUser(int userId, int unfollowUserId, UserService userService) {
        if (userService.getUser(userId) != null && userService.getUser(unfollowUserId) != null && userId != unfollowUserId) {
            following.get(userId).remove(Integer.valueOf(unfollowUserId));
            followers.get(unfollowUserId).remove(Integer.valueOf(userId));
        }
    }
    public List<Integer> getFollowers(int userId) {
        return followers.getOrDefault(userId, new ArrayList<>());
    }

    public List<Integer> getFollowing(int userId) {
        return following.getOrDefault(userId, new ArrayList<>());
    }
}
