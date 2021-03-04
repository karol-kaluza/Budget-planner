package com.planner.controller;

import com.planner.cash_flow.dto.ExpenseDto;
import com.planner.cash_flow.dto.IncomeDto;
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

import java.math.BigDecimal;
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

    @GetMapping("/main/{foreignCurrency}")
    public String main(Model model,
                       @AuthenticationPrincipal OAuth2User principal,
                       @PathVariable("foreignCurrency") CurrencyRateProvider.Currency foreignCurrency){
        User user = userRepository.findByUsername(principal.getAttribute("login"));
        List<IncomeDto> incomes = incomeService.findAllByUser(user);
        List<ExpenseDto> expenses = expenseServiceCRUD.findAllByUser(user);
        String goal = "50%";
        model.addAttribute("user", user);
        model.addAttribute("goal", goal);
        model.addAttribute("selectedYear", "All");
        model.addAttribute("selectedMonth", "All");
        model.addAttribute("years", expenseServiceUtils.getYears(user));
        model.addAttribute("months", expenseServiceUtils.getYears(user));
        model.addAttribute("expenses", expenses);
        model.addAttribute("expensesSum", expenses.stream().map(ExpenseDto::getValue).reduce(BigDecimal.ZERO, BigDecimal::add));
        model.addAttribute("categories", expenseServiceUtils.getUserCategories(user));
        model.addAttribute("incomes", incomes);
        model.addAttribute("incomesSum", incomes.stream().map(IncomeDto::getValue).reduce(BigDecimal.ZERO, BigDecimal::add));
        model.addAttribute("currencyRate", currencyRateProvider.getRate(foreignCurrency, CurrencyRateProvider.Currency.PLN));
        model.addAttribute("foreignCurrencyName", foreignCurrency.toString());
        return "main";
    }

    @GetMapping("/main/{foreignCurrency}/{year}")
    public String main(@PathVariable int year,
                       @PathVariable("foreignCurrency") CurrencyRateProvider.Currency foreignCurrency,
                       Model model,
                       @AuthenticationPrincipal OAuth2User principal) {
        User user = userRepository.findByUsername(principal.getAttribute("login"));
        List<Integer> years = expenseServiceUtils.getYears(user).stream()
                .filter(integer -> integer != year)
                .collect(Collectors.toList());
        List<IncomeDto> incomes = incomeService.findAllByUser(user, year);
        List<ExpenseDto> expenses = expenseServiceCRUD.findAllByUser(user, year);
        String goal = "50%";
        model.addAttribute("user", user);
        model.addAttribute("goal", goal);
        model.addAttribute("selectedYear", year);
        model.addAttribute("selectedMonth", "All");
        model.addAttribute("years", years);
        model.addAttribute("months", expenseServiceUtils.getMonths(user, year));
        model.addAttribute("expenses", expenses);
        model.addAttribute("expensesSum", expenses.stream().map(ExpenseDto::getValue).reduce(BigDecimal.ZERO, BigDecimal::add));
        model.addAttribute("categories", expenseServiceUtils.getUserCategories(user, year));
        model.addAttribute("incomes", incomes);
        model.addAttribute("incomesSum", incomes.stream().map(IncomeDto::getValue).reduce(BigDecimal.ZERO, BigDecimal::add));
        model.addAttribute("currencyRate", currencyRateProvider.getRate(foreignCurrency, CurrencyRateProvider.Currency.PLN));
        model.addAttribute("foreignCurrencyName", foreignCurrency.toString());
        return "main";
    }

    @GetMapping("/main/{foreignCurrency}/{year}/{month}")
    public String main(@PathVariable int year,
                       @PathVariable int month,
                       @PathVariable("foreignCurrency") CurrencyRateProvider.Currency foreignCurrency,
                       Model model,
                       @AuthenticationPrincipal OAuth2User principal) {
        User user = userRepository.findByUsername(principal.getAttribute("login"));
        String selectedMonth = Month.of(month).toString().toLowerCase();
        List<Integer> years = expenseServiceUtils.getYears(user).stream()
                .filter(integer -> integer != year)
                .collect(Collectors.toList());
        List<String> months = expenseServiceUtils.getMonths(user, year).stream()
                .filter(s -> !s.equals(selectedMonth))
                .collect(Collectors.toList());
        List<IncomeDto> incomes = incomeService.findAllByUser(user, year, month);
        List<ExpenseDto> expenses = expenseServiceCRUD.findAllByUser(user, year, month);
        String goal = "50%";
        model.addAttribute("user", user);
        model.addAttribute("goal", goal);
        model.addAttribute("selectedYear", year);
        model.addAttribute("selectedMonth", Month.of(month).toString().toLowerCase());
        model.addAttribute("years", years);
        model.addAttribute("months", months);
        model.addAttribute("expenses", expenses);
        model.addAttribute("expensesSum", expenses.stream().map(ExpenseDto::getValue).reduce(BigDecimal.ZERO, BigDecimal::add));
        model.addAttribute("categories", expenseServiceUtils.getUserCategories(user, year, month));
        model.addAttribute("incomes", incomes);
        model.addAttribute("incomesSum", incomes.stream().map(IncomeDto::getValue).reduce(BigDecimal.ZERO, BigDecimal::add));
        model.addAttribute("currencyRate", currencyRateProvider.getRate(foreignCurrency, CurrencyRateProvider.Currency.PLN));
        model.addAttribute("foreignCurrencyName", foreignCurrency.toString());
        return "main";
    }

    @GetMapping("/goodbye")
    public String goodbye() {
        return "goodbye";
    }
}
