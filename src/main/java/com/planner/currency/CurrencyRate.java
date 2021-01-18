package com.planner.currency;

import org.assertj.core.util.VisibleForTesting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CurrencyRate {

    private Rates rates;

    @Autowired
    public CurrencyRate(Rates rates) {
        this.rates = rates;
    }

    public double getRate(Currency currency) {
        return rates.getRate(currency);
    }

    public CurrencyRate() {
        this.rates = new Rates();
    }

    @VisibleForTesting
    Rates getRates() {
        return rates;
    }
}
