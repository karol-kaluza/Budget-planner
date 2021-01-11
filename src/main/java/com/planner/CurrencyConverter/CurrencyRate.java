package com.planner.CurrencyConverter;

public class CurrencyRate {

    private final Rates rates;

    public double getRate(Currency currency) {
        return rates.getRate(currency);
    }

    public CurrencyRate() {
        this.rates = new Rates();
    }
}
