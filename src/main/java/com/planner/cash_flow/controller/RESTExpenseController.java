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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/expense")
@RequiredArgsConstructor
public class RESTExpenseController implements ExpenseInterface {

    private final DataBase dataBase;
    private final ServiceExp serviceExp;

    @PostMapping("/save")
    public ExpenseDto saveExpense(@RequestBody ExpenseDto expenseDto) {
        return serviceExp.saveExpense(expenseDto);
    }

    @GetMapping("/{id}")
    public ExpenseDto findById(@PathVariable UUID id) {
        return serviceExp.findById(id);
    }

    @GetMapping("/all")
    public List<ExpenseDto> findAll() {
        return serviceExp.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable UUID id) {
        serviceExp.deleteExpense(id);
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
