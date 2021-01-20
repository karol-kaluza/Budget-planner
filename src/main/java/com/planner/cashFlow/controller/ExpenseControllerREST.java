package com.planner.cashFlow.controller;

import com.planner.cashFlow.model.Expense;
import com.planner.cashFlow.model.ExpenseService;
import com.planner.database.DataBase;
import com.planner.user.model.PlainResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExpenseControllerREST implements ExpenseInterface {

    private final DataBase dataBase;
    private final ExpenseService expenseService;

    public ExpenseControllerREST(DataBase dataBase, ExpenseService expenseService) {
        this.dataBase = dataBase;
        this.expenseService = expenseService;
    }

    @PutMapping("/addExpense")
    @Override
    public ResponseEntity<PlainResponse> add(@RequestBody Expense expense) {
        dataBase.addExpense(expense);
        return ResponseEntity.ok(new PlainResponse("expense " + expense.getName() + " added successfully"));
    }

    @DeleteMapping("/removeExpense")
    @Override
    public void remove(@RequestBody int id) {
        dataBase.removeExpense();
    }

    @GetMapping("/getExpenses")
    @Override
    public List<Expense> getAllExpenses() {
        return dataBase.getAllExpenses();
    }
}
