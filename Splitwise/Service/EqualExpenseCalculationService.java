package Splitwise.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Splitwise.Entity.Expense;

public class EqualExpenseCalculationService implements ExpenseCalculationService {
    @Override
    public void calculateExpense(Expense expense, Map<Integer, Map<Integer, Double>> balances) {
        int paidByUser = expense.getPaidByUser();
        double amount = expense.getAmount();
        List<Integer> involvedUsers = expense.getInvolvedUsers();

        double equalShare = amount / involvedUsers.size();
        equalShare = Math.round(equalShare * 100.0) / 100.0;
        double remaining = amount - equalShare * involvedUsers.size();
        for (int i = 0; i < involvedUsers.size(); i++) {
            int user = involvedUsers.get(i);
            double actualShare = equalShare;
            if (i == 0) {
                actualShare = Math.round((equalShare + remaining) * 100.0) / 100.0;
            }
            if (user != paidByUser) {
                updateBalance(balances, paidByUser, user, actualShare);
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
 