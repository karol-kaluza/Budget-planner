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

    private ExpenseService expenseService;
    private List<Expense> expenseList;

    @BeforeEach
    void setExpenseList() {
        expenseList = new LocalDB().getList();
        expenseService = new ExpenseService();
    }

    @Test
    void getMonthlyList_ReturnExtractedList_GivenListAndMont() {
        //given
        int monthNumber = Fixtures.DECEMBER_NUMBER;
        List<Expense> expenseList = Fixtures.INPUT_LIST;
        List<Expense> expected = Fixtures.ONLY_DECEMBER_LIST;

        //when
        List<Expense> actual = expenseService.getMonthlyList(expenseList,monthNumber);

        //then
        assertEquals(expected, actual);

    }

    private final static class Fixtures {

        public static final List<Expense> INPUT_LIST = List.of(
                new Expense("lidl 09.12", "food", 70, LocalDate.of(2020, Month.DECEMBER, 9)),
                new Expense("lidl 09.12", "food", 70, LocalDate.of(2020, Month.DECEMBER, 9)),
                new Expense("lidl 09.12", "food", 70, LocalDate.of(2020, Month.DECEMBER, 9)),
                new Expense("lidl 09.12", "food", 70, LocalDate.of(2020, Month.NOVEMBER, 9)));

        public static final List<Expense> ONLY_DECEMBER_LIST = List.of(
                new Expense("lidl 09.12", "food", 70, LocalDate.of(2020, Month.DECEMBER, 9)),
                new Expense("lidl 09.12", "food", 70, LocalDate.of(2020, Month.DECEMBER, 9)),
                new Expense("lidl 09.12", "food", 70, LocalDate.of(2020, Month.DECEMBER, 9)));

        public static final int DECEMBER_NUMBER = 12;

    }
}