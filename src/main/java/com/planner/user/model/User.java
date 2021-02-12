package com.planner.user.model;

import com.planner.currency.CurrencyRateProvider;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class User {

    @Id
    private String id;

    @Column(name = "username", nullable = false)
    @NotBlank
    private String username;

    private String avatarUrl;

//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
//    private List<Expense> expenses;

    // TODO: 10/02/2021 connect to future income table
//    private List<Income> incomes;

    @Enumerated(EnumType.STRING)
    private CurrencyRateProvider.Currency defaultCurrency;

    public User(@NotBlank String username, @Length(min = 5) String password) {
        this.username = username;
    }
}
