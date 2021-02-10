package com.planner.cash_flow.controller;

import com.planner.cash_flow.dto.ExpenseDto;
import com.planner.cash_flow.model.Expense;
import com.planner.database.DataBase;
import com.planner.service.ServiceExp;
import com.planner.user.model.PlainResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RESTExpenseController implements ExpenseInterface {

    private final DataBase dataBase;
    private final ServiceExp serviceExp;

    @PutMapping("/save")
    public ExpenseDto saveExpense(@RequestBody ExpenseDto expenseDto) {
        return serviceExp.saveExpense(expenseDto);
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
