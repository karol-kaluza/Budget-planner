package com.planner.cash_flow.controller;

import com.planner.cash_flow.dto.ExpenseDto;
import com.planner.cash_flow.model.Expense;
import com.planner.database.DataBase;
import com.planner.service.ServiceExp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/expense")
@RequiredArgsConstructor
public class ExpenseControllerREST {

    private final ServiceExp serviceExp;

    @PostMapping
    public ExpenseDto saveExpense(@RequestParam Map<String, String> requestParams) {
        return serviceExp.saveExpense(new ExpenseDto(
                requestParams.get("name"),
                requestParams.get("categoryName"),
                requestParams.get("value"),
                requestParams.get("date")));
    }

    @GetMapping("/{id}")
    public ExpenseDto findById(@PathVariable UUID id) {
        return serviceExp.findById(id);
    }

    @GetMapping
    public List<ExpenseDto> findAll() {
        return serviceExp.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        serviceExp.deleteExpense(id);
    }
}
