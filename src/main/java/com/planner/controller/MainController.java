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

@Controller
@AllArgsConstructor
public class MainController {

    private CurrencyRateProvider currencyRateProvider;

    private UserRepository userRepository;

    private ExpenseServiceCRUD expenseServiceCRUD;
    private ExpenseServiceUtils expenseServiceUtils;
    private IncomeServiceCRUD incomeService;

    @GetMapping("/main")
    public String main(Model model, @AuthenticationPrincipal OAuth2User principal) {
        User user = userRepository.findByUsername(principal.getAttribute("login"));
        String goal = "50%";
        model.addAttribute("user", user);
        model.addAttribute("goal", goal);
        model.addAttribute("expenses", expenseServiceCRUD.findAllByUser(user));
        model.addAttribute("categories", expenseServiceUtils.getUserCategories(user));
        model.addAttribute("incomes", incomeService.findAllByUser(user));
        model.addAttribute("currency", currencyRateProvider.getPrettyRate(CurrencyRateProvider.Currency.EUR));
        return "main";
    }
    @GetMapping("/main/{currency}")
    public String mainWithCurrency(Model model,
                                   @AuthenticationPrincipal OAuth2User principal,
                                   @PathVariable("currency")CurrencyRateProvider.Currency myCurrency) {
        User user = userRepository.findByUsername(principal.getAttribute("login"));
        String goal = "50%";
        model.addAttribute("user", user);
        model.addAttribute("goal", goal);
        model.addAttribute("expenses", expenseServiceCRUD.findAllByUser(user));
        model.addAttribute("categories", expenseServiceUtils.getUserCategories(user));
        model.addAttribute("incomes", incomeService.findAllByUser(user));
        model.addAttribute("currency", currencyRateProvider.getPrettyRate(myCurrency));
        model.addAttribute("stringCurrency", myCurrency.toString());
        model.addAttribute("EUR", CurrencyRateProvider.Currency.EUR);
        model.addAttribute("USD", CurrencyRateProvider.Currency.USD);
        model.addAttribute("CHF", CurrencyRateProvider.Currency.CHF);
        model.addAttribute("GBP", CurrencyRateProvider.Currency.GBP);
        return "main";
    }
//    @GetMapping("/main/{year}")
//    public String main(@PathVariable int year, Model model, @AuthenticationPrincipal OAuth2User principal) {
//        User user = userRepository.findByUsername(principal.getAttribute("login"));
//        List<Integer> years = expenseServiceUtils.getYears(user).stream()
//                .filter(integer -> integer != year)
//                .collect(Collectors.toList());
//        List<IncomeDto> incomes = incomeService.findAllByUser(user, year);
//        List<ExpenseDto> expenses = expenseServiceCRUD.findAllByUser(user, year);
//        String goal = "50%";
//        model.addAttribute("user", user);
//        model.addAttribute("goal", goal);
//        model.addAttribute("selectedYear", year);
//        model.addAttribute("selectedMonth", "All");
//        model.addAttribute("years",years);
//        model.addAttribute("months", expenseServiceUtils.getMonths(user, year));
//        model.addAttribute("expenses", expenses);
//        model.addAttribute("expensesSum", expenses.stream().map(ExpenseDto::getValue).reduce(BigDecimal.ZERO, BigDecimal::add));
//        model.addAttribute("categories", expenseServiceUtils.getUserCategories(user, year));
//        model.addAttribute("incomes", incomes);
//        model.addAttribute("incomesSum", incomes.stream().map(IncomeDto::getValue).reduce(BigDecimal.ZERO, BigDecimal::add));
//        model.addAttribute("currency", currencyRateProvider.getPrettyRate(CurrencyRateProvider.Currency.EUR));
//        return "main";
//    }


    @GetMapping("/goodbye")
    public String goodbye() {
        return "goodbye";
    }
}
