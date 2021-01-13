package com.planner.expense;

import java.util.ArrayList;
import java.util.List;

public class Expenses {

    private final List<Expense> expensesDB = new ArrayList<>();

    public List<Expense> getExpensesDB() {
        return expensesDB;
    }
}
