package com.planner.cash_flow.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IncomeDto {

    private String name;
    private int value;
    private LocalDate date;

    public IncomeDto(String name, String value, String date) {
        this.name = name;
        this.value = Integer.parseInt(value);
        this.date = LocalDate.parse(date);
    }

}
