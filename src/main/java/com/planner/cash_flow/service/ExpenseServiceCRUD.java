package com.planner.cash_flow.service;

import com.planner.cash_flow.dto.ExpenseDto;
import com.planner.cash_flow.model.Expense;
import com.planner.cash_flow.repository.ExpenseRepository;
import com.planner.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.planner.cash_flow.functions.ExpenseFunctions.expenseToExpenseDto;

@Service
@RequiredArgsConstructor
public class ExpenseServiceCRUD {

    private final ExpenseRepository expenseRepository;

    @Transactional
    public String saveExpense(ExpenseDto expenseDto) {
        Expense expense = new Expense(expenseDto.getName(), expenseDto.getCategoryName(), expenseDto.getValue(), expenseDto.getDate(), expenseDto.getUser());
        expenseRepository.save(expense);
        return "Expense added successfully";
    }

    @Transactional
    public ExpenseDto findById(UUID id) {
        return expenseRepository.findById(id).map(expenseToExpenseDto).orElseThrow();
    }

    @Transactional
    public List<ExpenseDto> findAll() {
        return expenseRepository.findAll().stream().map(expenseToExpenseDto).collect(Collectors.toList());
    }

    @Transactional
    public List<ExpenseDto> findAllByUser(User user) {
        return expenseRepository.findAllByUser(user).stream().map(expenseToExpenseDto).collect(Collectors.toList());
    }

    @Transactional
    public List<ExpenseDto> findAllByUser(User user, int year) {
        return expenseRepository.findAllByUser(user).stream()
                .map(expenseToExpenseDto)
                .filter(expenseDto -> expenseDto.getDate().getYear() == year)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<ExpenseDto> findAllByUser(User user, int year, int month) {
        return expenseRepository.findAllByUser(user).stream()
                .map(expenseToExpenseDto)
                .filter(expenseDto -> expenseDto.getDate().getYear() == year
                    && expenseDto.getDate().getMonthValue() == month)
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteExpense(UUID expenseId) {
        Expense expense = expenseRepository.findById(expenseId).orElseThrow();
        expenseRepository.delete(expense);
    }
}
