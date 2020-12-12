package com.h2;

import java.time.LocalDate;
import java.time.YearMonth;

public class SavingsCalculator {
    private final float[] credits;
    private final float[] debits;

    public SavingsCalculator(float[] credits, float[] debits) {
        this.credits = credits;
        this.debits = debits;
    }

    public static void main(String[] args) {
        final var creditsAsString = args[0].split(",");
        final var debitsAsString = args[1].split(",");
        final var credits = new float[creditsAsString.length];
        final var debits = new float[debitsAsString.length];

        for (int i = 0; i < credits.length; ++i) {
            credits[i] = Utilities.getFloatValue(creditsAsString[i]);
        }
        for (int i = 0; i < debits.length; ++i) {
            debits[i] = Utilities.getFloatValue(debitsAsString[i]);
        }
        final var calculator = new SavingsCalculator(credits, debits);
        final var netSavings = calculator.calculate();
        System.out.println("Net Savings = " + netSavings + ", remaining days in month = "
                + remainingDaysInMonth(LocalDate.now()));
    }

    private float sumOfCredits() {
        float sum = .0f;
        for (final var credit : credits) {
            sum += credit;
        }
        return sum;
    }

    private float sumOfDebits() {
        float sum = .0f;
        for (final var debit : debits) {
            sum += debit;
        }
        return sum;
    }

    private static int remainingDaysInMonth(LocalDate date) {
        final var yearMonth = YearMonth.of(date.getYear(), date.getMonth());
        final var totalDaysInMonth = yearMonth.lengthOfMonth();
        final var remainingDays = totalDaysInMonth - date.getDayOfMonth();
        return remainingDays;
    }

    public float calculate() {
        return sumOfCredits() - sumOfDebits();
    }
}
