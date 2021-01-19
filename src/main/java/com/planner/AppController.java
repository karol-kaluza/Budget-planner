package com.planner;

import com.planner.database.DataBase;
import com.planner.database.LocalDB;
import com.planner.expense.ExpenseService;
import com.planner.user.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class AppController {

    @GetMapping("/index")
    public String index(Model model) {
        User user = new User("jacko12");
        LocalDB data = new LocalDB();
        ExpenseService expensUtils = new ExpenseService();
        model.addAttribute("username", user.getUsername());
        model.addAttribute("categories", expensUtils.getCategories(data.getList()));
        return "index";
    }

    @GetMapping("/expense")
    public String carShow() {
        return "Expense";
    }
}
