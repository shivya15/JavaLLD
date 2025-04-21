package Splitwise.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Splitwise.Entity.Expense;

public class PercentExpenseCalculationService implements ExpenseCalculationService {
    @Override
    public void calculateExpense(Expense expense, Map<Integer, Map<Integer, Double>> balances) {
        int paidByUser = expense.getPaidByUser();
        double amount = expense.getAmount();
        List<Integer> involvedUsers = expense.getInvolvedUsers();
        List<Double> shares = expense.getShares();

        for (int i = 0; i < involvedUsers.size(); i++) {
            int user = involvedUsers.get(i);
            double share = Math.round(amount * (shares.get(i) / 100.0) * 100.0) / 100.0;
            if (user != paidByUser) {
                updateBalance(balances, paidByUser, user, share);
            }
        }
    }
    private void updateBalance(Map<Integer, Map<Integer, Double>> balances, int fromUser, int toUser, double amount) {
         if (!balances.containsKey(fromUser)) {
            balances.put(fromUser, new HashMap<>());
        }
        if (!balances.containsKey(toUser)) {
            balances.put(toUser, new HashMap<>());
        }

        balances.get(fromUser).put(toUser, balances.get(fromUser).getOrDefault(toUser, 0.0) + amount);
        balances.get(toUser).put(fromUser, balances.get(toUser).getOrDefault(fromUser, 0.0) - amount);
    }
}
