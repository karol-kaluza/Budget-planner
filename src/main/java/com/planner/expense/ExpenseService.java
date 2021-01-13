package com.planner.expense;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ExpenseService {

    private Map<String, Integer> categoriesGoals = new HashMap<>();

    public void printList(List<Expense> list) {
        list.forEach(System.out::println);
    }

    public List<Expense> getMonthlyList(List<Expense> list, int monthNumber) {
        List<Expense> monthlyExpenses = list.stream()
                .filter(x -> x.getDate().getMonth().getValue() == monthNumber)
                .collect(Collectors.toList());
        return monthlyExpenses;
    }

    public int getAmountMonthlyTotal(List<Expense> list, int monthNumber) {
        int sum = list.stream()
                .filter(x -> x.getDate().getMonth().getValue() == monthNumber)
                .mapToInt(Expense::getValue)
                .sum();
        return sum;
    }

    public int getAmountCategory(String category, int monthNumber, List<Expense> list) {
        int sum = list.stream()
                .filter(x -> x.getCategoryName().equals(category))
                .filter(x -> x.getDate().getMonth().getValue() == monthNumber)
                .mapToInt(Expense::getValue)
                .sum();
        return sum;
    }

    public void printCategory(List<Expense> list) {
        List<String> categories = list.stream()
                .map(Expense::getCategoryName)
                .distinct()
                .collect(Collectors.toList());
        categories.forEach(System.out::println);
    }

    public int getSaveMoneyInMonth(List<Expense> list, Income income, int monthNumber) {
        int savings = income.getValue() - getAmountMonthlyTotal(list, monthNumber);
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

    public void isGoalReached(String category, int monthNumber, List<Expense>list) {
        if (getCategoryGoal(category) >= getAmountCategory(category, monthNumber,list)){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}
