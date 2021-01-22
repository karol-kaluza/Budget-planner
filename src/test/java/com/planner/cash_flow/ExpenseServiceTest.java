package com.planner.cash_flow;

import com.planner.cash_flow.model.Expense;
import com.planner.cash_flow.model.Income;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExpenseServiceTest {

    private List<Expense> expenseList = Fixtures.INPUT_LIST;
    private ExpenseService expenseService = new ExpenseService();


    @Test
    void getMonthlyList_ReturnsExtractedList() {
        //given
        List<Expense> expected = Fixtures.ONLY_DECEMBER_LIST;
        //when
        List<Expense> actual = expenseService.getMonthlyList(expenseList, Fixtures.DECEMBER_NUMBER);
        //then
        assertEquals(expected, actual);
    }

    @Test
    void getAmountMonthlyTotal_returnsCorrectAmount() {
        //given
        int expected = Fixtures.TOTAL_DECEMBER;
        //when
        int actual = expenseService.getAmountMonthlyTotal(expenseList, Fixtures.DECEMBER_NUMBER);
        //then
        assertEquals(expected,actual);
    }

    @Test
    void getAmountCategory_returnsMonthlyAmountInSpecificCategory() {
        //given
        String categoryName = "food";
        int expected = Fixtures.FOOD_DECEMBER;
        //when
        int actual = expenseService.getAmountCategory(categoryName,Fixtures.DECEMBER_NUMBER,expenseList);
        //then
        assertEquals(expected,actual);
    }

    @Test
    void getSaveMoneyInMonth_returnsAmountOfMoneySavedInMonth() {
        //given
        Income income = new Income("salary December", 10_000);
        int expected = income.getValue() - Fixtures.TOTAL_DECEMBER;
        //when
        int actual = expenseService.getSaveMoneyInMonth(expenseList,income,Fixtures.DECEMBER_NUMBER);
        //then
        assertEquals(expected, actual);
    }

    private final static class Fixtures {

        public static final List<Expense> INPUT_LIST = List.of(
                new Expense("cinema", "entertainment", 20, LocalDate.of(2020, Month.DECEMBER, 4)),
                new Expense("rent", "accommodation", 1000, LocalDate.of(2020, Month.DECEMBER, 7)),
                new Expense("lidl 09.12", "food", 70, LocalDate.of(2020, Month.DECEMBER, 9)),
                new Expense("lidl 30.11", "food", 70, LocalDate.of(2020, Month.NOVEMBER, 30)));

        public static final List<Expense> ONLY_DECEMBER_LIST = List.of(
                new Expense("cinema", "entertainment", 20, LocalDate.of(2020, Month.DECEMBER, 4)),
                new Expense("rent", "accommodation", 1000, LocalDate.of(2020, Month.DECEMBER, 7)),
                new Expense("lidl 09.12", "food", 70, LocalDate.of(2020, Month.DECEMBER, 9)));

        public static final int DECEMBER_NUMBER = 12;
        public static final int TOTAL_DECEMBER = 1090;
        public static final int FOOD_DECEMBER = 70;
    }
}