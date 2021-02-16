package com.planner.repositories;

import com.planner.cash_flow.model.Income;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IncomeRepository extends JpaRepository<Income, UUID> {
}
