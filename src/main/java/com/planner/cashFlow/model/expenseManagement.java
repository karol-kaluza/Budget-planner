package com.planner.cashFlow.model;

import java.util.List;

public interface expenseManagement {
    void add (Expense expense);
    void remove (int id);
    List<Expense> getAllExpense ();

}
