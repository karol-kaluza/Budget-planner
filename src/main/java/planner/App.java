package planner;

import planner.Exchange.Converter;
import planner.database.LocalDB;

import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {

        Expense expense = new Expense();
        Income income = new Income("salary December", 10_000);
        new Converter().getRate(Converter.Currency.PLN);

        LocalDB exampleDB = new LocalDB();

        exampleDB.getAllExpenses();

//        System.out.println("wszystkie wydatki Grudzień: ");
//        List<Expense>expensesDecember = exampleDB.stream()
//                .filter(x -> x.getDate().getMonth() == Month.DECEMBER)
//                .collect(Collectors.toList());
//        expensesDecember.forEach(System.out::println);
//        int totalValueDecember = Expense.getTotalValue(expensesDecember);
//        System.out.println("Total value expenses in december: " + totalValueDecember);
//        System.out.println("------------------------------------------");
//        System.out.println("wydatki Listopad, tylko kategoria \"food\":" );
//        List<Expense> expensesFoodNovember = exampleDB.stream()
//                .filter(x -> x.getDate().getMonth() == Month.NOVEMBER)
//                .filter(x -> x.getCategoryName().equals("food"))
//                .collect(Collectors.toList());
//        expensesFoodNovember.forEach(System.out::println);
//        int valueFoodNovember = Expense.getTotalValue(expensesFoodNovember);
//        System.out.println("Value food in November: " + valueFoodNovember);
//        System.out.println("-----------------------------------------");
//        System.out.println("Istniejące kategorie: ");
//        List<String> categories = exampleDB.stream()
//                .map(Expense::getCategoryName)
//                .distinct()
//                .collect(Collectors.toList());
//        categories.forEach(System.out::println);
//        System.out.println("-----------------------------------------");
//        Map<String,Integer> categoriesGoals = expense.getCategoriesGoals();
//        categoriesGoals.put("transport",100);
//        int transportMonthlyGoal = categoriesGoals.get("transport");
//        System.out.println("Category \"transport\" - expected expenses: " + transportMonthlyGoal);


    }
}