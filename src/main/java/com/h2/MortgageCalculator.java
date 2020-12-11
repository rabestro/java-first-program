package com.h2;

import static java.lang.Math.pow;

public class MortgageCalculator {
    private final long loanAmount;
    private final int termInYears;
    private final float annualRate;
    private double monthlyPayment;

    public MortgageCalculator(long loanAmount, int termInYears, float annualRate) {
        this.loanAmount = loanAmount;
        this.termInYears = termInYears;
        this.annualRate = annualRate;
    }

    private int getNumberOfPayments() {
        return termInYears * 12;
    }

    private float getMonthlyInterestRate() {
        final var interestRate = annualRate / 100;
        return interestRate / 12;
    }

    private void calculateMonthlyPayment() {
        final var P = loanAmount;
        final var r = getMonthlyInterestRate();
        final var n = getNumberOfPayments();
        final var M = P * (((r * pow(1 + r, n))) / ((pow((1 + r), n)) - 1));
        this.monthlyPayment = M;
    }
}
