package planner;

import java.util.List;
import java.util.stream.Collectors;

public class ExpenseService {

    public void printList (List<Expense> list){
        list.forEach(System.out::println);
    }

    public List<Expense> getMonthlyList(List<Expense>list, int monthNumber){
        List<Expense> monthlyExpenses = list.stream()
                .filter(x -> x.getDate().getMonth().getValue() == monthNumber)
                .collect(Collectors.toList());
        return monthlyExpenses;
    }

    public int getAmountMonthlyTotal (List<Expense>list, int monthNumber){
        int sum = list.stream()
                .filter(x -> x.getDate().getMonth().getValue() == monthNumber)
                .mapToInt(Expense::getValue)
                .sum();
        return sum;
    }
    public int getAmountCategory (String category, int monthNumber, List<Expense>list){
        int sum = list.stream()
                .filter(x -> x.getCategoryName().equals(category))
                .filter(x -> x.getDate().getMonth().getValue() == monthNumber)
                .mapToInt(Expense::getValue)
                .sum();
        return sum;
    }
    public void printCategory (List<Expense>list){
        List<String> categories = list.stream()
                .map(Expense::getCategoryName)
                .distinct()
                .collect(Collectors.toList());
        categories.forEach(System.out::println);
    }
    //        Map<String,Integer> categoriesGoals = expense.getCategoriesGoals();
//        categoriesGoals.put("transport",100);
//        int transportMonthlyGoal = categoriesGoals.get("transport");
//        System.out.println("Category \"transport\" - expected expenses: " + transportMonthlyGoal);
}
