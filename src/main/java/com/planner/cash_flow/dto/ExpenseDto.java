package com.planner.cash_flow.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.planner.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseDto {

    @JsonIgnore
    private UUID uuid;
    private String name;
    private String categoryName;
    private BigDecimal value;
    private BigDecimal valueCurrency;
    private LocalDate date;
    @JsonIgnore
    private User user;

    public ExpenseDto(String name, String categoryName, String value, String date, User user) {
        this.name = name;
        this.categoryName = categoryName;
        this.value = BigDecimal.valueOf(Double.parseDouble(value));
        this.date = LocalDate.parse(date);
        this.user = user;
    }
}
