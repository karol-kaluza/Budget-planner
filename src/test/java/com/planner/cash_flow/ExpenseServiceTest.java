package com.planner.cash_flow;

import com.planner.cash_flow.model.Expense;
import com.planner.cash_flow.model.Income;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExpenseServiceTest {


    private List<Expense> expenseList = Fixtures.INPUT_LIST;
    private ExpenseService expenseService = new ExpenseService();


    @Test
    void getMonthlyList_ReturnsExtractedList() {
        //given
        List<Expense> expected = Fixtures.ONLY_DECEMBER_LIST;
        //when
        List<Expense> actual = expenseService.getMonthlyList(expenseList, Fixtures.DECEMBER_NUMBER, Fixtures.YEAR_2020);
        //then
        assertEquals(expected, actual);
    }

    @Test
    void getMonthlyList_givenEmptyList() {
        //given
        List<Expense> expected = Fixtures.EMPTY_LIST;
        //when
        List<Expense> actual = expenseService.getMonthlyList(Fixtures.EMPTY_LIST, Fixtures.DECEMBER_NUMBER, Fixtures.YEAR_2020);
        //then
        assertEquals(expected, actual);
    }

    @Test
    void getAmountMonthlyTotal_returnsCorrectAmount() {
        //given
        int expected = Fixtures.TOTAL_DECEMBER;
        //when
        int actual = expenseService.getAmountMonthlyTotal(expenseList, Fixtures.DECEMBER_NUMBER, Fixtures.YEAR_2020);
        //then
        assertEquals(expected, actual);
    }

    @Test
    void getAmountMonthlyTotal_givenWrongMonthValue() {
        //given
        int expected = 0;
        //when
        int actual = expenseService.getAmountMonthlyTotal(expenseList, 13, Fixtures.YEAR_2020);
        //then
        assertEquals(expected, actual);
    }

    @Test
    void getAmountCategory_returnsMonthlyAmountInSpecificCategory() {
        //given
        String categoryName = "food";
        int expected = Fixtures.FOOD_DECEMBER;
        //when
        int actual = expenseService.getAmountCategory(categoryName, Fixtures.DECEMBER_NUMBER, Fixtures.YEAR_2020, expenseList);
        //then
        assertEquals(expected, actual);
    }

    @Test
    void getSaveMoneyInMonth_returnsAmountOfMoneySavedInMonth() {
        //given
        Income income = new Income("salary December", 10_000);
        int expected = income.getValue() - Fixtures.TOTAL_DECEMBER;
        //when
        int actual = expenseService.getSaveMoneyInMonth(expenseList, income, Fixtures.DECEMBER_NUMBER, Fixtures.YEAR_2020);
        //then
        assertEquals(expected, actual);
    }

    @Test
    void getCategoryGoal_givenCorrectValues() {
        //given
        ExpenseService expenseService = new ExpenseService();
        expenseService.setCategoriesGoals("food", 1500);
        String food = "food";
        int expected = 1500;
        //when
        int actual = expenseService.getCategoryGoal(food);
        //then
        assertEquals(expected, actual);
    }

    @Test
    void setCategoriesGoals_givenCorrectValues() {
        //given
        ExpenseService expenseService = new ExpenseService();
        expenseService.setCategoriesGoals("food", 1500);
        Map<String, Integer> expected = Map.of("food", 1500);
        //when
        Map<String, Integer> actual = expenseService.getCategoriesGoals();
        //then
        assertEquals(expected, actual);
    }

    @Test
    void isGoalReached_givenTrue() {
        //given
        String food = "food";
        expenseService.setCategoriesGoals("food", 1500);
        boolean expected = true;
        //when
        boolean actual = expenseService.isGoalReached(food, Fixtures.DECEMBER_NUMBER, Fixtures.YEAR_2020, Fixtures.INPUT_LIST);
        //then
        assertEquals(expected, actual);
    }

    @Test
    void isGoalReached_givenFalse() {
        //given
        ExpenseService expenseService = new ExpenseService();
        String food = "food";
        expenseService.setCategoriesGoals("food", 60);
        boolean expected = false;
        //when
        boolean actual = expenseService.isGoalReached(food, Fixtures.DECEMBER_NUMBER, Fixtures.YEAR_2020, Fixtures.INPUT_LIST);
        //then
        assertEquals(expected, actual);
    }

    @Test
    void getCategories_test() {
        //given
        List<String> expected = List.of("entertainment", "accommodation", "food");
        //when
        List<String> actual = expenseService.getCategories(Fixtures.ONLY_DECEMBER_LIST);
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

        public static final List<Expense> EMPTY_LIST = new ArrayList<>();
        public static final int DECEMBER_NUMBER = 12;
        public static final int TOTAL_DECEMBER = 1090;
        public static final int FOOD_DECEMBER = 70;
        public static final int YEAR_2020 = 2020;
    }
}