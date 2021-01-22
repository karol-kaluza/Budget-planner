package com.planner.cash_flow.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class Income {

    private String name;
    private int value;
    private LocalDateTime date;

    //TODO telescopic constructor

    public Income(String name, int value, LocalDateTime date) {
        this.name = name;
        this.value = value;
        this.date = date;
    }

    public Income(String name, int value) {
        this(name, value, LocalDateTime.now());
    }
}
