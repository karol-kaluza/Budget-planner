package planner.database;

import planner.Expense;

import java.util.List;

public interface DataBase {
    List<Expense> getAllExpenses();
    List<Expense> addExpense(Expense expense);
    void removeExpense();
    List<Expense> getExpenseByCategory(Expense expense, String category);
}
