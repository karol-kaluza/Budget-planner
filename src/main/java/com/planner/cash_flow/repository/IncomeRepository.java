package com.planner.cash_flow.repository;

import com.planner.cash_flow.model.Income;
import com.planner.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface IncomeRepository extends JpaRepository<Income, UUID> {

    List<Income> findAllByUser(User user);
}
