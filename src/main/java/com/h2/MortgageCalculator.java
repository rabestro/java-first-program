package com.h2;

import java.text.DecimalFormat;

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

    public static void main(String[] args) {
        final var loanAmount = Utilities.getLongValue(args[0]);
        final var termInYears = Utilities.getIntValue(args[1]);
        final var annualRate = Utilities.getFloatValue(args[2]);
        final var calculator = new MortgageCalculator(loanAmount, termInYears, annualRate);
        calculator.calculateMonthlyPayment();
        System.out.println(calculator);
    }

    private int getNumberOfPayments() {
        return termInYears * 12;
    }

    private float getMonthlyInterestRate() {
        final var interestRate = annualRate / 100;
        return interestRate / 12;
    }

    public void calculateMonthlyPayment() {
        final var P = loanAmount;
        final var r = getMonthlyInterestRate();
        final var n = getNumberOfPayments();
        final var M = P * (r * pow(1 + r, n)) / (pow(1 + r, n) - 1);
        this.monthlyPayment = M;
    }

    @Override
    public String toString() {
        final var df = new DecimalFormat("####0.00");

        return "monthlyPayment: " + df.format(monthlyPayment);
    }

}
