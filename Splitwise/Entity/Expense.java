package Splitwise.Entity;

import java.util.List;

public class Expense {
    private int expenseId;
    private int paidByUser;
    private double amount;
    private ExpenseType splitType;
    private List<Double> shares;
    private List<Integer> involvedUsers;

    public Expense(int expenseId, int paidByUser, double amount, ExpenseType splitType, List<Double> shares, List<Integer> involvedUsers) {
        this.expenseId = expenseId;
        this.paidByUser = paidByUser;
        this.amount = amount;
        this.splitType = splitType;
        this.shares = shares;
        this.involvedUsers = involvedUsers;
    }

    public int getExpenseId() {
        return expenseId;
    }

    public int getPaidByUser() {
        return paidByUser;
    }

    public double getAmount() {
        return amount;
    }

    public ExpenseType getSplitType() {
        return splitType;
    }

    public List<Double> getShares() {
        return shares;
    }

    public List<Integer> getInvolvedUsers() {
        return involvedUsers;
    }
}
