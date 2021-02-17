package com.planner.controller;

import com.planner.cash_flow.ExpenseService;
import com.planner.cash_flow.dto.ExpenseDto;
import com.planner.cash_flow.dto.IncomeDto;
import com.planner.cash_flow.model.Expense;
import com.planner.currency.CurrencyRateProvider;
import com.planner.database.LocalDB;
import com.planner.repositories.ExpenseRepository;
import com.planner.service.ServiceExp;
import com.planner.service.ServiceInc;
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
    private ServiceExp expenseService;
    private ServiceInc incomeServiece;

    @GetMapping("/main")
    public String index(Model model) {
        model.addAttribute("categories", expenseService.getCategories());
        model.addAttribute("expenses", expenseService.findAll());
        model.addAttribute("expenseDto", new ExpenseDto());
        model.addAttribute("currency", currencyRateProvider.getPrettyRate(CurrencyRateProvider.Currency.EUR));
        model.addAttribute("incomes", incomeServiece.findAll());
        model.addAttribute("incomeDto", new IncomeDto());
        return "main";
    }


    @GetMapping("/goodbye")
    public String goodbye() {
        return "goodbye";
    }
}
