package com.planner.cash_flow.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.planner.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Expense {

    @Id
    @GeneratedValue
    @Type(type = "org.hibernate.type.UUIDCharType")
    @Column(name = "expense_id")
    private UUID id;

    private String name;

    private String categoryName;

    private int value;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    public Expense(String name, String categoryName, int value, LocalDate date, User user) {
        this.name = name;
        this.categoryName = categoryName;
        this.value = value;
        this.date = date;
        this.user = user;
    }

    @Override
    public String toString() {
        return date + ": " + value + " zł," + name + ", category: " + categoryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expense expense = (Expense) o;
        return value == expense.value &&
                Objects.equals(name, expense.name) &&
                Objects.equals(categoryName, expense.categoryName) &&
                Objects.equals(date, expense.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, categoryName, value, date);
    }
}
