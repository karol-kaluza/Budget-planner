package com.planner.user.model;

import com.planner.cash_flow.model.Expense;
import com.planner.cash_flow.model.Income;
import com.planner.currency.CurrencyRateProvider;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class User {

    @Id
    @GeneratedValue
    @Type(type="uuid-char")
    private UUID id;

    @Column(name = "username", nullable = false)
    @NotBlank
    private String username;

    private String avatarUrl;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Expense> expenses;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Income> incomes;

    @Enumerated(EnumType.STRING)
    private CurrencyRateProvider.Currency defaultCurrency;

    public User(String username, String avatarUrl, List<Expense> expenses, List<Income> incomes, CurrencyRateProvider.Currency defaultCurrency) {
        this.username = username;
        this.avatarUrl = avatarUrl;
        this.expenses = expenses;
        this.incomes = incomes;
        this.defaultCurrency = defaultCurrency;
    }
}
