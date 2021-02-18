package com.planner.cash_flow.controller;

import com.planner.cash_flow.dto.IncomeDto;
import com.planner.cash_flow.service.IncomeServiceCRUD;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/income")
@RequiredArgsConstructor
public class IncomeControllerREST {

    private final IncomeServiceCRUD incomeServiceCRUD;

    //    @PostMapping
//    public IncomeDto saveIncome(@RequestBody IncomeDto incomeDto) {
//        return serviceInc.saveIncome(incomeDto);
//    }
    @PostMapping
    public IncomeDto saveIncome(@RequestParam Map<String, String> requestParams) {
        return incomeServiceCRUD.saveIncome(new IncomeDto(
                requestParams.get("name"),
                requestParams.get("value"),
                requestParams.get("date")));
    }

    @GetMapping("/{id}")
    public IncomeDto findById(@PathVariable UUID id) {
        return incomeServiceCRUD.findById(id);
    }

    @GetMapping
    public List<IncomeDto> findAll() {
        return incomeServiceCRUD.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        incomeServiceCRUD.deleteIncome(id);
    }
}
