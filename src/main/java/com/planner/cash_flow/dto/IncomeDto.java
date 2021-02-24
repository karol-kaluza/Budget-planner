package com.planner.cash_flow.dto;

import com.planner.user.model.User;
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
    private int valueCurrency;
    private LocalDate date;
    private User user;

    public IncomeDto(String name, String value, String date, User user) {
        this.name = name;
        this.value = Integer.parseInt(value);
        this.date = LocalDate.parse(date);
        this.user = user;
    }

}
