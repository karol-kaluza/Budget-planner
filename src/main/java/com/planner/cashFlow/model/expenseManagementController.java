package com.planner.cashFlow.model;

import com.planner.database.DataBase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class expenseManagementController implements expenseManagement {

    private DataBase dataBase;

    public expenseManagementController(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @PutMapping("/add")
    @Override
    public void add(@RequestBody Expense expense) {
        dataBase.addExpense(expense);
    }


    @Override
    public void remove(int id) {

    }

    @GetMapping("/getExpenses")
    @Override
    public List<Expense> getAllExpense() {
        return dataBase.getAllExpenses();
    }
}
