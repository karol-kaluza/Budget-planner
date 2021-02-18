package com.planner.controller;

import com.planner.cash_flow.dto.ExpenseDto;
import com.planner.cash_flow.dto.IncomeDto;
import com.planner.currency.CurrencyRateProvider;
import com.planner.service.ServiceExp;
import com.planner.service.ServiceInc;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class MainController {

    private CurrencyRateProvider currencyRateProvider;
    private ServiceExp expenseService;
    private ServiceInc incomeServiece;

    @GetMapping("/main")
    public String index(Model model) {
        model.addAttribute("categories", expenseService.getCategories());
        model.addAttribute("expenses", expenseService.findAll());
        model.addAttribute("currency", currencyRateProvider.getPrettyRate(CurrencyRateProvider.Currency.EUR));
        model.addAttribute("incomes", incomeServiece.findAll());
        return "main";
    }


    @GetMapping("/goodbye")
    public String goodbye() {
        return "goodbye";
    }
}
