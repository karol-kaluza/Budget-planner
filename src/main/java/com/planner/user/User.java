package com.planner.user;

import com.planner.cash_flow.model.Expense;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class User {

    private String username;
    private List<Expense> expenses;
    private String userType;

    public User(String username) {
        this.username = username;
    }
}
