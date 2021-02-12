package com.planner.user.model;

import com.planner.cash_flow.model.Expense;
import com.planner.currency.CurrencyRateProvider;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;

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
public class User {

    @Id
    @GeneratedValue
    @Type(type="uuid-char")
    private UUID id;

    @Column(name = "username", nullable = false)
    @NotBlank
    private String username;

    @Column(name = "password", nullable = false)
    @Length(min = 5)
    private String password;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Expense> expenses;

    // TODO: 10/02/2021 connect to future income table
//    private List<Income> incomes;

    @Enumerated(EnumType.STRING)
    private CurrencyRateProvider.Currency defaultCurrency;

    public User(@NotBlank String username, @Length(min = 5) String password) {
        this.username = username;
        this.password = password;
    }
}
