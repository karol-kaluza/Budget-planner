package com.planner;

import com.planner.CurrencyConverter.Converter;
import com.planner.database.LocalDB;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShowContent {

    @GetMapping("index")
    public String run() {


        LocalDB localDB = new LocalDB();

        Income income = new Income("salary December", 10_000);
        ExpenseService service = new ExpenseService();
        service.printList(service.getMonthlyList(localDB.list, 12));
        System.out.println("Total money spent december: " + service.getAmountMonthlyTotal(localDB.list, 12));
        System.out.println("total money spent december, category food:" +
                service.getAmountCategory("food", 12, localDB.list));
        service.printCategory(localDB.list);
        System.out.println("Money saved in december: " + service.getSaveMoneyInMonth(localDB.list, income, 12));
        service.setCategoriesGoals("savings", 5000);
        System.out.println("savings expected in december: " + service.getCategoryGoal("savings"));
        System.out.println("is goal reached in category \"savings\":");
        service.isGoalReached("savings", 12, localDB.list);
        Double curRate = new Converter().getRate(Converter.Currency.EUR);
        return curRate.toString();
    }
}