package com.planner.database;

import com.planner.Expense;

import java.util.ArrayList;
import java.util.List;

public class DataBaseFromServer implements DataBase {

    List<Expense> list = new ArrayList<>();

    public DataBaseFromServer() {
        getDataFromServer();
    }

    private void getDataFromServer() {
        //elementy pobrane z serwera dodaj do list
    }

    @Override
    public List<Expense> getAllExpenses() {
        //Zapytanie i pobranie danych z MYSQL
        return null;
    }

    @Override
    public List<Expense> addExpense(Expense expense) {
        //Insert do bazy danych
        return null;
    }

    @Override
    public void removeExpense() {
        //Usuniecie rekordu
    }

    @Override
    public List<Expense> getExpenseByCategory(Expense expense, String category) {
        return null;
    }
}
