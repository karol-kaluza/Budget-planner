package planner;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Expenses {

    private final List<Expense> expensesDB = new ArrayList<>();

    public List<Expense> getExpensesDB() {
        expensesDB.add(new Expense("fuel", "transport", 100, LocalDate.now()));
        expensesDB.add(new Expense("cinema", "entertainment", 20, LocalDate.of(2020, Month.DECEMBER, 4)));
        expensesDB.add(new Expense("lidl 05.12", "food", 350, LocalDate.of(2020, Month.DECEMBER, 5)));
        expensesDB.add(new Expense("rent", "accommodation", 1000, LocalDate.of(2020, Month.DECEMBER, 7)));
        expensesDB.add(new Expense("McDonald's", "food", 30, LocalDate.of(2020, Month.DECEMBER, 8)));
        expensesDB.add(new Expense("lidl 09.12", "food", 70, LocalDate.of(2020, Month.DECEMBER, 9)));
        expensesDB.add(new Expense("new TV", "other", 2000, LocalDate.of(2020, Month.DECEMBER, 9)));

        expensesDB.add(new Expense("fuel", "transport", 100, LocalDate.now()));
        expensesDB.add(new Expense("cinema", "entertainment", 20, LocalDate.of(2020, Month.NOVEMBER, 4)));
        expensesDB.add(new Expense("lidl 05.11", "food", 350, LocalDate.of(2020, Month.NOVEMBER, 5)));
        expensesDB.add(new Expense("rent", "accommodation", 1000, LocalDate.of(2020, Month.NOVEMBER, 7)));
        expensesDB.add(new Expense("McDonald's", "food", 30, LocalDate.of(2020, Month.NOVEMBER, 8)));
        expensesDB.add(new Expense("lidl 09.11", "food", 70, LocalDate.of(2020, Month.NOVEMBER, 9)));
        expensesDB.add(new Expense("new TV", "other", 2000, LocalDate.of(2020, Month.NOVEMBER, 9)));
        return expensesDB;
    }
}
