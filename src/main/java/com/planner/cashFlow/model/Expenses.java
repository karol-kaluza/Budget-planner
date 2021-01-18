package com.planner.cashFlow.model;

import java.util.ArrayList;
import java.util.List;

public class Expenses {

    private final List<Expense> expensesDB = new ArrayList<>();

    public List<Expense> getExpensesDB() {
        return expensesDB;
    }
}
