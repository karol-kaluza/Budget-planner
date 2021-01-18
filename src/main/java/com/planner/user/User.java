package com.planner.user;

import com.planner.cashFlow.model.Expense;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class User {

    private String username;
    private List<Expense> expenses;

    public User(String username) {
        this.username = username;
    }
}
