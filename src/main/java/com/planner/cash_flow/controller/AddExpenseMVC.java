package com.planner.cash_flow.controller;

import com.planner.cash_flow.model.Expense;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.time.LocalDate;

@Controller
public class AddExpenseMVC {

    @GetMapping("/add-expense")
    public String expenseShow(Model model) {
        model.addAttribute("expense", new Expense());
        return "add-expense";
    }

    @PostMapping("addExpense")
    public String add(@Valid Expense expense) {
        expense.setDate(LocalDate.now());
        return "empty";
    }
}
