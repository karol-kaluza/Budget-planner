package com.planner.controller;

import com.planner.cash_flow.ExpenseService;
import com.planner.cash_flow.model.Expense;
import com.planner.currency.CurrencyRateProvider;
import com.planner.database.LocalDB;
import com.planner.user.model.User;
import com.planner.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.DecimalFormat;

@Controller
@AllArgsConstructor
public class MainController {

    private CurrencyRateProvider currencyRateProvider;
    private UserRepository userRepository;

    @GetMapping("/main")
    public String index(Model model) {
        //Only for preview - JJDRLW-8-front-base
        User user = new User("adrian", "pass");
        DecimalFormat df = new DecimalFormat("#.####");
        double rate = Double.parseDouble(df.format(currencyRateProvider.getRate(CurrencyRateProvider.Currency.EUR)));
        LocalDB data = new LocalDB();
        ExpenseService expensUtils = new ExpenseService();
        model.addAttribute("categories", expensUtils.getCategories(data.getList()));
        model.addAttribute("expenses", data.getList());
        model.addAttribute("expense", new Expense());
        model.addAttribute("currency", rate);
        return "main";
    }

    @GetMapping("/goodbye")
    public String goodbye() {
        return "goodbye";
    }
}
