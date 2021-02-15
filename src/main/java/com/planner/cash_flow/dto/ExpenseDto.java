package com.planner.cash_flow.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ExpenseDto {

    private String name;
    private String categoryName;
    private int value;
    private LocalDate date;

    public ExpenseDto(String name, String categoryName, int value, LocalDate date) {
        this.name = name;
        this.categoryName = categoryName;
        this.value = value;
        this.date = date;
    }

    public ExpenseDto() {
    }
}
