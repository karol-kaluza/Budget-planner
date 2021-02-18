package com.planner.controller;

import com.planner.cash_flow.service.ExpenseServiceCRUD;
import com.planner.cash_flow.service.IncomeServiceCRUD;
import com.planner.currency.CurrencyRateProvider;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class MainController {

    private CurrencyRateProvider currencyRateProvider;

    private ExpenseServiceCRUD expenseService;
    private IncomeServiceCRUD incomeService;

    @GetMapping("/main")
    public String index(Model model) {
        model.addAttribute("categories", expenseService.getCategories());
        model.addAttribute("expenses", expenseService.findAll());
        model.addAttribute("currency", currencyRateProvider.getPrettyRate(CurrencyRateProvider.Currency.EUR));
        model.addAttribute("incomes", incomeService.findAll());
        return "main";
    }


    @GetMapping("/goodbye")
    public String goodbye() {
        return "goodbye";
    }
}
