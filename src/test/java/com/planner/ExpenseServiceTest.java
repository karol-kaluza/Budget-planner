package com.planner;

import com.planner.database.LocalDB;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class ExpenseServiceTest {

    private List<Expense> expenseList;
    private ExpenseService expenseService;

    @BeforeEach
    void setExpenseList() {
        expenseList = Fixtures.INPUT_LIST;
        expenseService = new ExpenseService();
    }

    @Test
    void getMonthlyList_ReturnExtractedList_GivenListAndMonth() {
        //given
        int monthNumber = Fixtures.DECEMBER_NUMBER;
        List<Expense> expected = Fixtures.ONLY_DECEMBER_LIST;
        //when
        List<Expense> actual = expenseService.getMonthlyList(expenseList,monthNumber);
        //then
        assertEquals(expected, actual);
    }

    @Test
    void getAmountMonthlyTotal_returnCorrectAmount() {
        //given
        int monthNumber = Fixtures.DECEMBER_NUMBER;
        int expected = 1090;
        //when
        int actual = expenseService.getAmountMonthlyTotal(expenseList, monthNumber);
        //then
        assertEquals(expected,actual);
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

    }
}