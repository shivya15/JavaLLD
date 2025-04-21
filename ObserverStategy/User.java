package ObserverStategy;
public class User implements OutOfStockObserver {
    private String userId;
    private String notificationPreference;
    private String contactInfo;

    public User(String userId, String notificationPreference, String contactInfo) {
        this.userId = userId;
        this.notificationPreference = notificationPreference;
        this.contactInfo = contactInfo;
    }

    public String getUserId() {
        return userId;
    }

    public void update(String productName) {
        System.out.println("User " + userId + " (" + notificationPreference + " - " + contactInfo + "): Product '" + productName + "' is back in stock!");
    }

    @Override
    public String toString() {
        return "User " + userId;
    }
}
