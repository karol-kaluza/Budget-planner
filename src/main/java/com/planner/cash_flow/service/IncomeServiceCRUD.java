package com.planner.cash_flow.service;

import com.planner.cash_flow.dto.IncomeDto;
import com.planner.cash_flow.model.Income;
import com.planner.cash_flow.repository.IncomeRepository;
import com.planner.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.planner.cash_flow.functions.IncomeFunctions.incomeToIncomeDto;

@Service
@RequiredArgsConstructor
public class IncomeServiceCRUD {

    private final IncomeRepository incomeRepository;

    private final Comparator<IncomeDto> dateComparator = Comparator.comparing(IncomeDto::getDate);

    @Transactional
    public String saveIncome(IncomeDto incomeDto) {
        Income income = new Income(incomeDto.getName(), incomeDto.getValue(), incomeDto.getDate(), incomeDto.getUser());
        incomeRepository.save(income);
        return "Income added successfully";
    }

    @Transactional
    public IncomeDto findById(UUID id) {
        return incomeRepository.findById(id).map(incomeToIncomeDto).orElseThrow();
    }

    @Transactional
    public List<IncomeDto> findAll() {
        return incomeRepository.findAll().stream().map(incomeToIncomeDto).collect(Collectors.toList());
    }

    @Transactional
    public void deleteIncome(UUID incomeId) {
        Income income = incomeRepository.findById(incomeId).orElseThrow();
        incomeRepository.delete(income);
    }

    @Transactional
    public List<IncomeDto> findAllByUser(User user) {
        return incomeRepository.findAllByUser(user).stream()
                .map(incomeToIncomeDto)
                .sorted(dateComparator.reversed())
                .collect(Collectors.toList());
    }

    @Transactional
    public List<IncomeDto> findAllByUser(User user, int year) {
        return incomeRepository.findAllByUser(user).stream()
                .filter(income -> income.getDate().getYear() == year)
                .map(incomeToIncomeDto)
                .sorted(dateComparator.reversed())
                .collect(Collectors.toList());
    }

    @Transactional
    public List<IncomeDto> findAllByUser(User user, int year, int month) {
        return incomeRepository.findAllByUser(user).stream()
                .filter(income -> income.getDate().getYear() == year
                        && income.getDate().getMonthValue() == month)
                .map(incomeToIncomeDto)
                .sorted(dateComparator.reversed())
                .collect(Collectors.toList());
    }
}