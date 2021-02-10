package com.planner.service;

import com.planner.cash_flow.dto.ExpenseDto;
import com.planner.cash_flow.model.Expense;
import com.planner.repositories.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.planner.functions.ExpenseFunctions.expenseToExpenseDto;

@Service
@RequiredArgsConstructor
public class ServiceExp {

    private final ExpenseRepository expenseRepository;

    @Transactional
    public ExpenseDto saveExpense(ExpenseDto expenseDto) {
        Expense expense = new Expense(expenseDto.getName(), expenseDto.getCategoryName(), expenseDto.getValue(), expenseDto.getDate());
        Expense savedExpense = expenseRepository.save(expense);
        return new ExpenseDto(savedExpense.getName(), savedExpense.getCategoryName(), savedExpense.getValue(), savedExpense.getDate());
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
    public void deleteExpense(UUID expenseId) {
        Expense expense = expenseRepository.findById(expenseId).orElseThrow();
        expenseRepository.delete(expense);
    }
}
