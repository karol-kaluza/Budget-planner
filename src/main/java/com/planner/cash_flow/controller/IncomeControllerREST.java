package com.planner.cash_flow.controller;

import com.planner.cash_flow.dto.IncomeDto;
import com.planner.cash_flow.service.IncomeServiceCRUD;
import com.planner.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
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
    private final UserRepository userRepository;

    @PostMapping
    public String saveIncome(@RequestParam Map<String, String> requestParams, @AuthenticationPrincipal OAuth2User principal) {
        return incomeServiceCRUD.saveIncome(new IncomeDto(
                requestParams.get("name"),
                requestParams.get("value"),
                requestParams.get("date"),
                userRepository.findByUsername(principal.getAttribute("login"))));
    }

    //todo not return incomedto
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
