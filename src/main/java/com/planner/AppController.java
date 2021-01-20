package com.planner;

import com.planner.database.LocalDB;
import com.planner.expense.Expense;
import com.planner.expense.ExpenseService;
import com.planner.user.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;

@Controller
public class AppController {

    @GetMapping("/index")
    public String index(Model model) {
        User user = new User("jacko12");
        user.setUserType("admin");
        LocalDB data = new LocalDB();
        ExpenseService expensUtils = new ExpenseService();
        model.addAttribute("user", user);
        model.addAttribute("categories", expensUtils.getCategories(data.getList()));
        model.addAttribute("expenses", data.getList());
        return "index";
    }

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
        System.out.println(expense.toString());
        return "empty";
    }
}
