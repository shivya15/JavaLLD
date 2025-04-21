package ObserverStategy;
class AmazonNotify {
    public static void main(String[] args){
        Product smartphone = new Product("Iphone 17");
        User user1 = new User("user123", "email", "user123@example.com");
        User user2 = new User("user456", "sms", "+918888888888");
        User user3 = new User("user789", "email", "user789@example.co.in");

        smartphone.addUser(user1);
        smartphone.addUser(user2);
        smartphone.addUser(user3);

        smartphone.setInStock();

    }
}
