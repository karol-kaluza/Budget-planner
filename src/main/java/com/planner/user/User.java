package com.planner.user;

import com.planner.cash_flow.model.Expense;
import com.planner.cash_flow.model.Income;
import com.planner.currency.CurrencyRateProvider;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class User {

    private UUID id;
    private String username;
    private String password;
    private List<Expense> expenses;
    private List<Income> incomes;
    private CurrencyRateProvider.Currency defaultCurrency;

    // TODO: 10/02/2021 change user repository and user tests to meet bl
    public User(String username) {
        this.username = username;
    }
}
