package com.planner.cash_flow;

import com.planner.cash_flow.model.Expense;
import com.planner.cash_flow.model.Income;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ExpenseService {

    private Map<String, Integer> categoriesGoals = new HashMap<>();

    public List<Expense> getMonthlyList(List<Expense> list, int monthNumber, int year) {
        List<Expense> monthlyExpenses = list.stream()
                .filter(x -> x.getDate().getMonth().getValue() == monthNumber)
                .filter(x -> x.getDate().getYear() == year)
                .collect(Collectors.toList());
        return monthlyExpenses;
    }

    public int getAmountMonthlyTotal(List<Expense> list, int monthNumber, int year) {
        int sum = list.stream()
                .filter(x -> x.getDate().getMonth().getValue() == monthNumber)
                .filter(x -> x.getDate().getYear() == year)
                .mapToInt(Expense::getValue)
                .sum();
        return sum;
    }

    public int getAmountCategory(String category, int monthNumber, int year, List<Expense> list) {
        int sum = list.stream()
                .filter(x -> x.getCategoryName().equals(category))
                .filter(x -> x.getDate().getMonth().getValue() == monthNumber)
                .filter(x -> x.getDate().getYear() == year)
                .mapToInt(Expense::getValue)
                .sum();
        return sum;
    }

    public List<String> getCategories(List<Expense> list) {
        return list.stream()
                .map(Expense::getCategoryName)
                .distinct()
                .collect(Collectors.toList());
    }

    public int getSaveMoneyInMonth(List<Expense> list, Income income, int monthNumber, int year) {
        int savings = income.getValue() - getAmountMonthlyTotal(list, monthNumber, year);
        return savings;
    }

    public Map<String, Integer> getCategoriesGoals() {
        return categoriesGoals;
    }

    public void setCategoriesGoals(String category, int value) {
        categoriesGoals.put(category, value);
    }

    public int getCategoryGoal(String category) {
        int categoryGoal = categoriesGoals.get(category);
        return categoryGoal;
    }

    public boolean isGoalReached(String category, int monthNumber, int year, List<Expense> list) {
        return getCategoryGoal(category) >= getAmountCategory(category, monthNumber, year, list);
    }
}
