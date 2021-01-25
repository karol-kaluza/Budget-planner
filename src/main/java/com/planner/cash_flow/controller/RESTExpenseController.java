package com.planner.cash_flow.controller;

import com.planner.cash_flow.ExpenseService;
import com.planner.cash_flow.model.Expense;
import com.planner.database.DataBase;
import com.planner.user.model.PlainResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RESTExpenseController implements ExpenseInterface {

    private final DataBase dataBase;
    private final ExpenseService expenseService;

    public RESTExpenseController(DataBase dataBase, ExpenseService expenseService) {
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
