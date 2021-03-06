package com.planner.cash_flow.model;

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
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Income {

    @Id
    @GeneratedValue
    @Type(type = "org.hibernate.type.UUIDCharType")
    @Column(name = "income_id")
    private UUID id;

    private String name;

    private BigDecimal value;

    private BigDecimal valueCurrency;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Income(String name, BigDecimal value, LocalDate date, User user) {
        this.name = name;
        this.value = value;
        this.date = date;
        this.user = user;
    }

    public Income(String name, BigDecimal value, LocalDate date) {
        this.name = name;
        this.value = value;
        this.date = date;
    }

    public Income(String name, BigDecimal value) {
        this(name, value, LocalDate.now());
    }
}
