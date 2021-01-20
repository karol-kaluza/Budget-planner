package com.planner;

import com.planner.cashFlow.model.Expense;
import com.planner.cashFlow.model.ExpenseService;
import com.planner.database.LocalDB;
import com.planner.user.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppMVC {

    @GetMapping("/index")
    public String index(Model model) {
        User user = new User("jacko12");
        user.setUserType("admin");
        LocalDB data = new LocalDB();
        ExpenseService expensUtils = new ExpenseService();
        model.addAttribute("user", user);
        model.addAttribute("categories", expensUtils.getCategories(data.getList()));
        model.addAttribute("expenses", data.getList());
        model.addAttribute("expense", new Expense());
        return "index";
    }
}
