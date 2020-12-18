package planner.database;

import planner.Expense;

import java.util.List;

public interface DataBase {
    public List<Expense> getAllExpenses();
    public List<Expense> addExpense(Expense expense);
    public void removeExpense();
    public List<Expense> getExpenseByCategory(Expense expense, String category);
}
