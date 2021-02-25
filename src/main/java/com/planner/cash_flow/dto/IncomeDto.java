package com.planner.cash_flow.dto;

import com.planner.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import static java.lang.Double.parseDouble;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IncomeDto {

    private UUID uuid;
    private String name;
    private BigDecimal value;
    private LocalDate date;
    private User user;

    public IncomeDto(String name, String value, String date, User user) {
        this.name = name;
        this.value = BigDecimal.valueOf(parseDouble(value));
        this.date = LocalDate.parse(date);
        this.user = user;
    }

}
