package com.planner.controller;

import com.planner.cash_flow.ExpenseService;
import com.planner.cash_flow.model.Expense;
import com.planner.currency.CurrencyRateProvider;
import com.planner.database.LocalDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.DecimalFormat;

@Controller
public class MainController {

    private CurrencyRateProvider currencyRateProvider;

    //TODO lombok annotation
    @Autowired
    public MainController(CurrencyRateProvider currencyRateProvider) {
        this.currencyRateProvider = currencyRateProvider;
    }

    @GetMapping("/main")
    public String index(Model model) {
        //Only for preview - JJDRLW-8-front-base
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
}
