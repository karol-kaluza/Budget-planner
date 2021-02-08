package com.planner.cash_flow.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
public class Expense {

    private String name;
    private String categoryName;
    private int value;
    private LocalDate date;
    private int id = generateId();

    private int generateId() {
        return (int) Math.floor((Math.random()*1_000_000_000));
    }

    public Expense() {
    }

    public Expense(String name, String categoryName, int value, LocalDate date) {
        this.name = name;
        this.categoryName = categoryName;
        this.value = value;
        this.date = date;
        this.id = generateId();
    }
    public Expense(String name, String categoryName, int value) {
        this(name, categoryName, value, LocalDate.now());
    }

    @Override
    public String toString() {
        return date + ": " + value + " zł," + name + ", category: " + categoryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expense expense = (Expense) o;
        return value == expense.value &&
                Objects.equals(name, expense.name) &&
                Objects.equals(categoryName, expense.categoryName) &&
                Objects.equals(date, expense.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, categoryName, value, date);
    }
}
