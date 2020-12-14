package planner;

import java.time.LocalDate;

public class Income {
    private String name;
    private int value;
    private LocalDate date;

    public Income(String name, int value, LocalDate date) {
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
