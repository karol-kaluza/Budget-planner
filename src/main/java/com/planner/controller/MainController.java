package com.planner.controller;

import com.planner.cash_flow.service.ExpenseServiceCRUD;
import com.planner.cash_flow.service.ExpenseServiceUtils;
import com.planner.cash_flow.service.IncomeServiceCRUD;
import com.planner.currency.CurrencyRateProvider;
import com.planner.user.model.User;
import com.planner.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class MainController {

    private final CurrencyRateProvider currencyRateProvider;
    private final UserRepository userRepository;
    private final ExpenseServiceCRUD expenseServiceCRUD;
    private final ExpenseServiceUtils expenseServiceUtils;
    private final IncomeServiceCRUD incomeService;

    @GetMapping("/main")
    public String main(Model model, @AuthenticationPrincipal OAuth2User principal) {
        User user = userRepository.findByUsername(principal.getAttribute("login"));
        String goal = "50%";
        model.addAttribute("user", user);
        model.addAttribute("goal", goal);
        model.addAttribute("selectedYear", "All");
        model.addAttribute("selectedMonth", "All");
        model.addAttribute("years", expenseServiceUtils.getYears(user));
        model.addAttribute("months", expenseServiceUtils.getYears(user));
        model.addAttribute("expenses", expenseServiceCRUD.findAllByUser(user));
        model.addAttribute("categories", expenseServiceUtils.getUserCategories(user));
        model.addAttribute("incomes", incomeService.findAllByUser(user));
        model.addAttribute("currency", currencyRateProvider.getPrettyRate(CurrencyRateProvider.Currency.EUR));
        return "main";
    }

    @GetMapping("/main/{year}")
    public String main(@PathVariable int year, Model model, @AuthenticationPrincipal OAuth2User principal) {
        User user = userRepository.findByUsername(principal.getAttribute("login"));
        List<Integer> years = expenseServiceUtils.getYears(user).stream()
                .filter(integer -> integer != year)
                .collect(Collectors.toList());
        String goal = "50%";
        model.addAttribute("user", user);
        model.addAttribute("goal", goal);
        model.addAttribute("selectedYear", year);
        model.addAttribute("selectedMonth", "All");
        model.addAttribute("years",years);
        model.addAttribute("months", expenseServiceUtils.getMonths(user, year));
        model.addAttribute("expenses", expenseServiceCRUD.findAllByUser(user, year));
        model.addAttribute("categories", expenseServiceUtils.getUserCategories(user, year));
        model.addAttribute("incomes", incomeService.findAllByUser(user, year));
        model.addAttribute("currency", currencyRateProvider.getPrettyRate(CurrencyRateProvider.Currency.EUR));
        return "main";
    }

    @GetMapping("/main/{year}/{month}")
    public String main(@PathVariable int year, @PathVariable int month, Model model, @AuthenticationPrincipal OAuth2User principal) {
        User user = userRepository.findByUsername(principal.getAttribute("login"));
        String selectedMonth = Month.of(month).toString().toLowerCase();
        List<Integer> years = expenseServiceUtils.getYears(user).stream()
                .filter(integer -> integer != year)
                .collect(Collectors.toList());
        List<String> months = expenseServiceUtils.getMonths(user, year).stream()
                .filter(s -> !s.equals(selectedMonth))
                .collect(Collectors.toList());
        String goal = "50%";
        model.addAttribute("user", user);
        model.addAttribute("goal", goal);
        model.addAttribute("selectedYear", year);
        model.addAttribute("selectedMonth", Month.of(month).toString().toLowerCase());
        model.addAttribute("years", years);
        model.addAttribute("months", months);
        model.addAttribute("expenses", expenseServiceCRUD.findAllByUser(user, year, month));
        model.addAttribute("categories", expenseServiceUtils.getUserCategories(user, year, month));
        model.addAttribute("incomes", incomeService.findAllByUser(user, year, month));
        model.addAttribute("currency", currencyRateProvider.getPrettyRate(CurrencyRateProvider.Currency.EUR));
        return "main";
    }

    @GetMapping("/goodbye")
    public String goodbye() {
        return "goodbye";
    }
}
