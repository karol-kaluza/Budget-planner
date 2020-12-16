package planner;

import planner.Exchange.Converter;
import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {

        Expense expense = new Expense();
        Income income = new Income("salary December", 10_000);
        Expenses expenses = new Expenses();
        new Converter().convert(Converter.Currency.EUR);

        System.out.println("wszystkie wydatki Grudzień: ");
        List<Expense> expensesDecember = expenses.getExpensesDB().stream()
                .filter(x -> x.getDate().getMonth() == Month.DECEMBER)
                .collect(Collectors.toList());
        expensesDecember.forEach(System.out::println);
        int totalValueDecember = Expense.getTotalValue(expensesDecember);
        System.out.println("Total value expenses in december: " + totalValueDecember);
        System.out.println("------------------------------------------");

        System.out.println("wydatki Listopad, tylko kategoria \"food\":");
        List<Expense> expensesFoodNovember = expenses.getExpensesDB().stream()
                .filter(x -> x.getDate().getMonth() == Month.NOVEMBER)
                .filter(x -> x.getCategoryName().equals("food"))
                .collect(Collectors.toList());
        expensesFoodNovember.forEach(System.out::println);
        int valueFoodNovember = Expense.getTotalValue(expensesFoodNovember);
        System.out.println("Value food in November: " + valueFoodNovember);
        System.out.println("-----------------------------------------");

        System.out.println("Istniejące kategorie: ");
        List<String> categories = expenses.getExpensesDB().stream()
                .map(Expense::getCategoryName)
                .distinct()
                .collect(Collectors.toList());
        categories.forEach(System.out::println);
        System.out.println("-----------------------------------------");

        Map<String, Integer> categoriesGoals = expense.getCategoriesGoals();
        categoriesGoals.put("transport", 100);
        int transportMonthlyGoal = categoriesGoals.get("transport");
        System.out.println("Category \"transport\" - expected expenses: " + transportMonthlyGoal);
    }
}