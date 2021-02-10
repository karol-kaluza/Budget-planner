package com.planner.cash_flow.controller;

import com.planner.cash_flow.model.Expense;
import com.planner.user.model.PlainResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ExpenseInterface {

    ResponseEntity<PlainResponse> add(Expense expense);

    void remove(int id);

    List<Expense> getAllExpenses();

}
