package planner;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {

        Expense expense = new Expense();
        Income income = new Income("salary December", 10_000, LocalDate.of(2020, Month.DECEMBER, 10));

        List<Expense>expensesMainList = new ArrayList<>();
        expensesMainList.add(new Expense("fuel", "transport", 100, LocalDate.now()));
        expensesMainList.add(new Expense("cinema", "entertainment", 20, LocalDate.of(2020, Month.DECEMBER, 4)));
        expensesMainList.add(new Expense("lidl 05.12", "food", 350, LocalDate.of(2020, Month.DECEMBER, 5)));
        expensesMainList.add(new Expense("rent", "accommodation", 1000, LocalDate.of(2020, Month.DECEMBER, 7)));
        expensesMainList.add(new Expense("McDonald's", "food", 30, LocalDate.of(2020, Month.DECEMBER, 8)));
        expensesMainList.add(new Expense("lidl 09.12", "food", 70, LocalDate.of(2020, Month.DECEMBER, 9)));
        expensesMainList.add(new Expense("new TV", "other", 2000, LocalDate.of(2020, Month.DECEMBER, 9)));

        expensesMainList.add(new Expense("fuel", "transport", 100, LocalDate.now()));
        expensesMainList.add(new Expense("cinema", "entertainment", 20, LocalDate.of(2020, Month.NOVEMBER, 4)));
        expensesMainList.add(new Expense("lidl 05.11", "food", 350, LocalDate.of(2020, Month.NOVEMBER, 5)));
        expensesMainList.add(new Expense("rent", "accommodation", 1000, LocalDate.of(2020, Month.NOVEMBER, 7)));
        expensesMainList.add(new Expense("McDonald's", "food", 30, LocalDate.of(2020, Month.NOVEMBER, 8)));
        expensesMainList.add(new Expense("lidl 09.11", "food", 70, LocalDate.of(2020, Month.NOVEMBER, 9)));
        expensesMainList.add(new Expense("new TV", "other", 2000, LocalDate.of(2020, Month.NOVEMBER, 9)));

        System.out.println("wszystkie wydatki Grudzień: ");
        List<Expense>expensesDecember = expensesMainList.stream()
                .filter(x -> x.getDate().getMonth() == Month.DECEMBER)
                .collect(Collectors.toList());
        expensesDecember.forEach(System.out::println);
        int totalValueDecember = Expense.getTotalValue(expensesDecember);
        System.out.println("Total value expenses in december: " + totalValueDecember);
        System.out.println("------------------------------------------");
        System.out.println("wydatki Listopad, tylko kategoria \"food\":" );
        List<Expense> expensesFoodNovember = expensesMainList.stream()
                .filter(x -> x.getDate().getMonth() == Month.NOVEMBER)
                .filter(x -> x.getCategoryName().equals("food"))
                .collect(Collectors.toList());
        expensesFoodNovember.forEach(System.out::println);
        int valueFoodNovember = Expense.getTotalValue(expensesFoodNovember);
        System.out.println("Value food in November: " + valueFoodNovember);
        System.out.println("-----------------------------------------");
        System.out.println("Istniejące kategorie: ");
        List<String> categories = expensesMainList.stream()
                .map(Expense::getCategoryName)
                .distinct()
                .collect(Collectors.toList());
        categories.forEach(System.out::println);
        System.out.println("-----------------------------------------");
        Map<String,Integer> categoriesGoals = expense.getCategoriesGoals();
        categoriesGoals.put("transport",100);
        int transportMonthlyGoal = categoriesGoals.get("transport");
        System.out.println("Category \"transport\" - expected expenses: " + transportMonthlyGoal);


    }
}
//        expense.addExpense("fuel", "transport", 100, LocalDate.now());
//        expense.addExpense("cinema", "entertainment", 20, LocalDate.of(2020, Month.DECEMBER, 4));
//        expense.addExpense("lidl 05.12", "food", 350, LocalDate.of(2020, Month.DECEMBER, 5));
//        expense.addExpense("rent", "accommodation", 1000, LocalDate.of(2020, Month.DECEMBER, 7));
//        expense.addExpense("McDonald's", "food", 30, LocalDate.of(2020, Month.DECEMBER, 8));
//        expense.addExpense("lidl 09.12", "food", 70, LocalDate.of(2020, Month.DECEMBER, 9));
//        expense.addExpense("new TV", "other", 2000, LocalDate.of(2020, Month.DECEMBER, 9));
//        expense.addExpense("fuel", "transport", 100, LocalDate.now());
//        expense.addExpense("cinema", "entertainment", 20, LocalDate.of(2020, Month.NOVEMBER, 4));
//        expense.addExpense("rent", "accommodation", 1000, LocalDate.of(2020, Month.NOVEMBER, 7));
//        expense.addExpense("McDonald's", "food", 30, LocalDate.of(2020, Month.NOVEMBER, 8));
//        expense.addExpense("lidl 09.12", "food", 70, LocalDate.of(2020, Month.NOVEMBER, 9));
//        expense.addExpense("new TV", "other", 2000, LocalDate.of(2020, Month.NOVEMBER, 9));
