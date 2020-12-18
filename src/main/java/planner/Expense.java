package planner;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Expense {

    private String name;
    private String categoryName;
    private int value;
    private LocalDate date;
    private Map<String, Integer> categoriesGoals = new HashMap<>();

    public Expense() {
    }

    public Expense(String name, String categoryName, int value, LocalDate date) {
        this.name = name;
        this.categoryName = categoryName;
        this.value = value;
        this.date = date;
    }

    public static int getTotalValue(List<Expense> expensesList) {
        int totalValue = 0;
        for (Expense expense : expensesList) {
            totalValue += expense.getValue();
        }
        return totalValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Map<String, Integer> getCategoriesGoals() {
        return categoriesGoals;
    }

    public void setCategoriesGoals(Map<String, Integer> categoriesGoals) {
        this.categoriesGoals = categoriesGoals;
    }

    @Override
    public String toString() {
        return date + ": " + value + " zł," + name + ", category: " + categoryName;
    }
}
