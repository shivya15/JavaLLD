package Splitwise.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Splitwise.Entity.Expense;
import Splitwise.Entity.ExpenseType;

public class ExpenseService {
    private Map<Integer, Map<Integer, Double>> balances = new HashMap<>();
    private UserService userService;
    private Map<ExpenseType, ExpenseCalculationService> expenseCalculationServices;
    private int nextExpenseId = 1;

    public ExpenseService(UserService userService) {
        this.userService = userService;
        this.expenseCalculationServices = new HashMap<>();
        this.expenseCalculationServices.put(ExpenseType.EQUAL, new EqualExpenseCalculationService());
        this.expenseCalculationServices.put(ExpenseType.EXACT, new ExactExpenseCalculationService());
        this.expenseCalculationServices.put(ExpenseType.PERCENT, new PercentExpenseCalculationService());
    }

    private void initializeBalance(int userId) {
        balances.put(userId, new HashMap<>());
    }

    public void addExpense(int paidByUser, double amount, List<Integer> involvedUsers, ExpenseType splitType, List<Double> shares) {
        if (!balances.containsKey(paidByUser)) {
            initializeBalance(paidByUser);
        }
        for (int user : involvedUsers) {
            if (!balances.containsKey(user)) {
                initializeBalance(user);
            }
        }

        if (involvedUsers == null || involvedUsers.isEmpty()) {
            throw new IllegalArgumentException("Involved users list cannot be null or empty.");
        }

        if (splitType != ExpenseType.EQUAL && (shares == null || shares.isEmpty())) {
            throw new IllegalArgumentException("Shares list cannot be null or empty for non-EQUAL expense.");
        }

        if (splitType == ExpenseType.EXACT && shares.size() != involvedUsers.size()) {
            throw new IllegalArgumentException("Number of shares must equal number of users for EXACT expense.");
        }

        if (splitType == ExpenseType.PERCENT) {
            double totalPercent = 0;
            for (double percent : shares) {
                totalPercent += percent;
            }
            if (Math.abs(totalPercent - 100) > 0.01) {
                throw new IllegalArgumentException("Sum of percentages must be 100 for PERCENT expense.");
            }
        }

        Expense expense = new Expense(nextExpenseId++, paidByUser, amount, splitType, shares, involvedUsers);
        expenseCalculationServices.get(splitType).calculateExpense(expense, balances);
    }



    public Map<Integer, Double> getUserBalance(int userId) {
        if (!balances.containsKey(userId)) {
            initializeBalance(userId);
        }
        Map<Integer, Double> userBalances = new HashMap<>();
        for (Map.Entry<Integer, Double> entry : balances.get(userId).entrySet()) {
            int otherUserId = entry.getKey();
            double balance = Math.round(entry.getValue() * 100.0) / 100.0;
            if (balance != 0) {
                userBalances.put(otherUserId, balance);
            }
        }
        return userBalances;
    }

    public Map<Integer, Map<Integer, Double>> getAllUserBalances() {
        Map<Integer, Map<Integer, Double>> allBalances = new HashMap<>();
        for (Integer userId : balances.keySet()) {
            allBalances.put(userId, getUserBalance(userId));
        }
        return allBalances;
    }

    public void showBalances(int userId) {
        Map<Integer, Double> userBalances = getUserBalance(userId);
        if (userBalances.isEmpty()) {
            System.out.println("No balances for " + userService.getUser(userId).getName());
            return;
        }
        System.out.println("Balances for " + userService.getUser(userId).getName() + ":");
        for (Map.Entry<Integer, Double> entry : userBalances.entrySet()) {
            int otherUserId = entry.getKey();
            double balance = entry.getValue();
            if (balance > 0) {
                System.out.println(userService.getUser(userId).getName() + " owes " + userService.getUser(otherUserId).getName() + ": " + balance);
            } else {
                System.out.println(userService.getUser(otherUserId).getName() + " owes " + userService.getUser(userId).getName() + ": " + Math.abs(balance));
            }
        }
    }

    public void showBalances() {
        Map<Integer, Map<Integer, Double>> allBalances = getAllUserBalances();
        boolean hasBalances = false;
        for (Map.Entry<Integer, Map<Integer, Double>> userBalancesEntry : allBalances.entrySet()) {
            int userId = userBalancesEntry.getKey();
            Map<Integer, Double> userBalances = userBalancesEntry.getValue();
            for (Map.Entry<Integer, Double> balanceEntry : userBalances.entrySet()) {
                int otherUserId = balanceEntry.getKey();
                double balance = balanceEntry.getValue();
                if (balance > 0) {
                    hasBalances = true;
                    System.out.println(userService.getUser(userId).getName() + " owes " + userService.getUser(otherUserId).getName() + ": " + balance);
                }
            }
        }
        if (!hasBalances) {
            System.out.println("No balances");
        }
    }
}
