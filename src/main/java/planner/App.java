package planner;

import planner.Exchange.Converter;
import planner.database.LocalDB;

public class App {
    public static void main(String[] args) {

        new Converter().getRate(Converter.Currency.EUR);
        LocalDB localDB = new LocalDB();
        Income income = new Income("salary December", 10_000);
        ExpenseService service = new ExpenseService();
        service.printList(service.getMonthlyList(LocalDB.list,12));
        System.out.println("Total money spent december: " + service.getAmountMonthlyTotal(LocalDB.list, 12));
        System.out.println("total money spent december, category food:" +
                service.getAmountCategory("food",12,LocalDB.list));
        service.printCategory(LocalDB.list);

    }
}