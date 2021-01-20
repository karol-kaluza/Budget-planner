package com.planner.cashFlow.controller;

import com.planner.cashFlow.model.Expense;
import com.planner.user.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.time.LocalDate;
//TODO
public class ExpenseMVC {

    @GetMapping("/expense")
    public String expenseShow(Model model) {
        User user = new User("jacko12");
        user.setUserType("admin");
        model.addAttribute("user", user);
        model.addAttribute("expense", new Expense());
        return "expense";
    }

    @PostMapping("addExpense")
    public String add(@Valid Expense expense) {
        expense.setDate(LocalDate.now());
        return "empty";
    }
}
