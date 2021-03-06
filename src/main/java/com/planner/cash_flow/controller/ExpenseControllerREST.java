package com.planner.cash_flow.controller;

import com.planner.cash_flow.dto.ExpenseDto;
import com.planner.cash_flow.service.ExpenseServiceCRUD;
import com.planner.cash_flow.service.ExpenseServiceUtils;
import com.planner.user.model.User;
import com.planner.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.planner.cash_flow.functions.ExpenseFunctions.expenseToExpenseDto;

@RestController
@RequestMapping("/expense")
@RequiredArgsConstructor
public class ExpenseControllerREST {

    private final ExpenseServiceCRUD expenseServiceCRUD;
    private final ExpenseServiceUtils expenseServiceUtils;
    private final UserRepository userRepository;

    @PostMapping
    public String saveExpense(@RequestParam Map<String, String> requestParams, @AuthenticationPrincipal OAuth2User principal) {
        return expenseServiceCRUD.saveExpense(new ExpenseDto(
                requestParams.get("name"),
                requestParams.get("categoryName"),
                requestParams.get("value"),
                requestParams.get("date"),
                userRepository.findByUsername(principal.getAttribute("login"))));
    }

    @GetMapping
    public List<ExpenseDto> findAll() {
        return expenseServiceCRUD.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        expenseServiceCRUD.deleteExpense(id);
    }

    @GetMapping("/{categoryName}")
    public List<ExpenseDto> getAllFromCategory(@PathVariable String categoryName, @AuthenticationPrincipal OAuth2User principal) {
        User user = userRepository.findByUsername(principal.getAttribute("login"));
        return expenseServiceUtils.getExpensesFromCategory(user, categoryName).stream()
                .map(expenseToExpenseDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{categoryName}/{year}")
    public List<ExpenseDto> getAllFromCategory(@PathVariable String categoryName, @PathVariable int year, @AuthenticationPrincipal OAuth2User principal) {
        User user = userRepository.findByUsername(principal.getAttribute("login"));
        return expenseServiceUtils.getExpensesFromCategory(user, categoryName).stream()
                .filter(expense -> expense.getDate().getYear() == year)
                .map(expenseToExpenseDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{categoryName}/{year}/{month}")
    public List<ExpenseDto> getAllFromCategory(@PathVariable String categoryName, @PathVariable int year, @PathVariable int month, @AuthenticationPrincipal OAuth2User principal) {
        User user = userRepository.findByUsername(principal.getAttribute("login"));
        return expenseServiceUtils.getExpensesFromCategory(user, categoryName).stream()
                .filter(expense -> expense.getDate().getYear() == year
                    && expense.getDate().getMonthValue() == month)
                .map(expenseToExpenseDto)
                .collect(Collectors.toList());
    }
}
