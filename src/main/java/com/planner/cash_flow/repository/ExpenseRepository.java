package com.planner.cash_flow.repository;

import com.planner.cash_flow.model.Expense;
import com.planner.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ExpenseRepository extends JpaRepository<Expense, UUID> {

    List<Expense> findAllByUser(User user);
}
