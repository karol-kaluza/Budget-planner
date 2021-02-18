package com.planner.cash_flow.functions;

import com.planner.cash_flow.dto.ExpenseDto;
import com.planner.cash_flow.model.Expense;

import java.util.function.Function;

public class ExpenseFunctions {

    public static final Function<Expense, ExpenseDto> expenseToExpenseDto = expense -> new ExpenseDto(
            expense.getName(),
            expense.getCategoryName(),
            expense.getValue(),
            expense.getDate()
    );
}
