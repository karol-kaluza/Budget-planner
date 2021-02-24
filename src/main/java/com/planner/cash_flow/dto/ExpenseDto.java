package com.planner.cash_flow.dto;

import com.planner.user.model.User;
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
    private int valueCurrency;
    private LocalDate date;
    private User user;

    public ExpenseDto(String name, String categoryName, String value, String date, User user) {
        this.name = name;
        this.categoryName = categoryName;
        this.value = Integer.parseInt(value);
        this.date = LocalDate.parse(date);
        this.user = user;
    }
}
