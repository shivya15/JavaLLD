package Splitwise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Splitwise.Entity.ExpenseType;
import Splitwise.Service.ExpenseService;
import Splitwise.Service.UserService;

public class Main {
    public static void main(String[] args) {
        // Initialize services
        UserService userService = new UserService();
        ExpenseService expenseService = new ExpenseService(userService);

        // Add users
        int user1Id = userService.addUser("John Doe", "1234567890", "john.doe@example.com");
        int user2Id = userService.addUser("Jane Smith", "9876543210", "jane.smith@example.com");
        int user3Id = userService.addUser("Alice Wonder", "5555555555", "alice.wonder@example.com");
        int user4Id = userService.addUser("Bob Builder", "1112223333", "bob.builder@example.com");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nExpense Sharing App Menu:");
            System.out.println("1. Add Expense");
            System.out.println("2. Show all balances");
            System.out.println("3. Show balance for a single user");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter payer user ID: ");
                        int payerId = scanner.nextInt();
                        System.out.print("Enter total amount: ");
                        double amount = scanner.nextDouble();
                        System.out.print("Enter number of users involved: ");
                        int numberOfUsers = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        List<Integer> involvedUsers = new ArrayList<>();
                        System.out.print("Enter space-separated list of user IDs involved: ");
                        String[] userIds = scanner.nextLine().split(" ");
                        for (String userIdStr : userIds) {
                            involvedUsers.add(Integer.parseInt(userIdStr));
                        }

                        System.out.print("Enter expense type (EQUAL, EXACT, PERCENT): ");
                        String expenseTypeStr = scanner.next();
                        ExpenseType expenseType = ExpenseType.valueOf(expenseTypeStr.toUpperCase());

                        List<Double> shares = new ArrayList<>();
                        if (expenseType != ExpenseType.EQUAL) {
                            System.out.print("Enter space-separated shares: ");
                            String[] sharesStr = scanner.nextLine().split(" ");
                            if(expenseType == ExpenseType.EXACT && sharesStr.length != involvedUsers.size()){
                                throw new IllegalArgumentException("Number of shares must be equal to number of users for EXACT type");
                            }
                            for (String shareStr : sharesStr) {
                                shares.add(Double.parseDouble(shareStr));
                            }
                        }
                        scanner.nextLine(); //consume the extra line.
                        expenseService.addExpense(payerId, amount, involvedUsers, expenseType, shares);
                        System.out.println("Expense added successfully.");
                        break;
                    case 2:
                        expenseService.showBalances();
                        break;
                    case 3:
                        System.out.print("Enter user ID to show balance: ");
                        int userIdToShow = scanner.nextInt();
                        expenseService.showBalances(userIdToShow);
                        break;
                    case 4:
                        System.out.println("Exiting App.");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
