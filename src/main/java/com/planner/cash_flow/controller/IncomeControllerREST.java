package com.planner.cash_flow.controller;

import com.planner.cash_flow.dto.IncomeDto;
import com.planner.service.ServiceInc;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/income")
@RequiredArgsConstructor
public class IncomeControllerREST {

    private final ServiceInc serviceInc;

    @PostMapping
    public IncomeDto saveIncome(@RequestBody IncomeDto incomeDto) {
        return serviceInc.saveIncome(incomeDto);
    }

    @GetMapping("/{id}")
    public IncomeDto findById(@PathVariable UUID id) {
        return serviceInc.findById(id);
    }

    @GetMapping
    public List<IncomeDto> findAll() {
        return serviceInc.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        serviceInc.deleteIncome(id);
    }
}
