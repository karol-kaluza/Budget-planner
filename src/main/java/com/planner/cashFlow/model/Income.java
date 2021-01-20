package com.planner.cashFlow.model;

import java.time.LocalDateTime;

public class Income {

    private String name;
    private int value;
    private LocalDateTime date;

    public Income(String name, int value) {
        this.name = name;
        this.value = value;
        this.date = LocalDateTime.now();
    }

    public Income(String name, int value, LocalDateTime date) {
        this.name = name;
        this.value = value;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
