package com.planner.controller;

import com.planner.cash_flow.ExpenseService;
import com.planner.cash_flow.model.Expense;
import com.planner.currency.CurrencyRateProvider;
import com.planner.database.LocalDB;
import com.planner.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    private CurrencyRateProvider currencyRateProvider;

    @Autowired
    public MainController(CurrencyRateProvider currencyRateProvider) {
        this.currencyRateProvider = currencyRateProvider;
    }

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
        model.addAttribute("currency", currencyRateProvider.getRate(CurrencyRateProvider.Currency.EUR));

        return "index";
    }
}
