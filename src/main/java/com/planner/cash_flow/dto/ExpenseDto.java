package com.planner.cash_flow.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseDto {

    private String name;
    private String categoryName;
    private int value;
    private LocalDate date;

}