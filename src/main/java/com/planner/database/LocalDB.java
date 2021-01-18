package com.planner.database;

import com.planner.expense.Expense;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LocalDB implements DataBase {

    public List<Expense> list = new ArrayList<>();

    public LocalDB() {
        addSomeExampleData();
    }

    public void addSomeExampleData() {
        Collections.addAll(list,
                new Expense("fuel", "transport", 100, LocalDate.now()),
                new Expense("cinema", "entertainment", 20, LocalDate.of(2020, Month.DECEMBER, 4)),
                new Expense("lidl 05.12", "food", 350, LocalDate.of(2020, Month.DECEMBER, 5)),
                new Expense("rent", "accommodation", 1000, LocalDate.of(2020, Month.DECEMBER, 7)),
                new Expense("McDonald's", "food", 30, LocalDate.of(2020, Month.DECEMBER, 8)),
                new Expense("lidl 09.12", "food", 70, LocalDate.of(2020, Month.DECEMBER, 9)),
                new Expense("new TV", "other", 2000, LocalDate.of(2020, Month.DECEMBER, 9)),
                new Expense("fuel", "transport", 100, LocalDate.now()),
                new Expense("cinema", "entertainment", 20, LocalDate.of(2020, Month.NOVEMBER, 4)),
                new Expense("lidl 05.11", "food", 350, LocalDate.of(2020, Month.NOVEMBER, 5)),
                new Expense("rent", "accommodation", 1000, LocalDate.of(2020, Month.NOVEMBER, 7)),
                new Expense("McDonald's", "food", 30, LocalDate.of(2020, Month.NOVEMBER, 8)),
                new Expense("lidl 09.11", "food", 70, LocalDate.of(2020, Month.NOVEMBER, 9)),
                new Expense("new TV", "other", 2000, LocalDate.of(2020, Month.NOVEMBER, 9)));
    }

    @Override
    public List<Expense> getAllExpenses() {
        for (Expense expense: list) {
            System.out.println(expense);
        }
        return null;
    }

    @Override
    public List<Expense> addExpense(Expense expense) {
        list.add(expense);
        return null;
    }

    @Override
    public void removeExpense() {
        list.remove(1);
    }

    @Override
    public List<Expense> getExpenseByCategory(Expense expense, String category) {
        List<Expense>expensesByCategory = list.stream()
                .filter(x -> x.getCategoryName().equals(category))
                .collect(Collectors.toList());
        expensesByCategory.forEach(System.out::println);
        return null;
    }
    public List<Expense> getList() {
        return list;
    }
}
