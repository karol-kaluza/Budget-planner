package com.planner.currency;

import org.assertj.core.util.VisibleForTesting;

public class CurrencyRate {

    private final Rates rates;

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
