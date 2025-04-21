package Splitwise.Entity;

public class User {
    private int userId;
    private String name;
    private String phoneNo;
    private String email;

    public User(int userId, String name, String phoneNo, String email) {
        this.userId = userId;
        this.name = name;
        this.phoneNo = phoneNo;
        this.email = email;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", email='" + email + '\'' +
                "}";
    }
}
