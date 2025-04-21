package Splitwise.Service;

import java.util.Map;

import Splitwise.Entity.Expense;

public interface ExpenseCalculationService {
    void calculateExpense(Expense expense, Map<Integer, Map<Integer, Double>> balances);
}
