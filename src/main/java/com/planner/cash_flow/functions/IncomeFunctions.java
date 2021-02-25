package com.planner.cash_flow.functions;

import com.planner.cash_flow.dto.IncomeDto;
import com.planner.cash_flow.model.Income;

import java.util.function.Function;

public class IncomeFunctions {

    public static final Function<Income, IncomeDto> incomeToIncomeDto = income -> new IncomeDto(
            income.getId(),
            income.getName(),
            income.getValue(),
            income.getDate(),
            income.getUser()
    );
}
