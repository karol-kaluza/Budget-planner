package com.planner.service;

import com.planner.cash_flow.dto.ExpenseDto;
import com.planner.cash_flow.model.Expense;
import com.planner.repositories.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ServiceExp {

    private final ExpenseRepository expenseRepository;

    @Transactional
    public ExpenseDto saveExpense(ExpenseDto expenseDto) {
        Expense expense = new Expense(expenseDto.getName(), expenseDto.getCategoryName(), expenseDto.getValue(),expenseDto.getDate());
        Expense savedExpense = expenseRepository.save(expense);
        return new ExpenseDto(savedExpense.getName(), savedExpense.getCategoryName(), savedExpense.getValue(), savedExpense.getDate());
    }
}
