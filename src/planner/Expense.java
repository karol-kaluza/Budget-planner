package planner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Expense {

    private String name;
    //    private Category category;
    private String categoryName;
    //    private BigDecimal value;
    private int value;
    private LocalDate date;

    private List<Expense> expensesMainList = new ArrayList<>();

    Map<String, Integer> categoriesGoals = new HashMap<>();
    // key - category name(String), value - expected level (Integer)


    public Expense() {
    }

    public Expense(String name, String categoryName, int value, LocalDate date) {
        this.name = name;
        this.categoryName = categoryName;
//        this.category = new Category("food");
        this.value = value;
        this.date = date;
    }

    public List<Expense> addExpense(String name, String categoryName, int value, LocalDate date) {
        expensesMainList.add(new Expense(name, categoryName, value, date));
        return expensesMainList;
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

    public List<Expense> getExpensesMainList() {
        return expensesMainList;
    }

    @Override
    public String toString() {
        return date + ": " + value + " zł," + name + ", category: " + categoryName;
    }
}
