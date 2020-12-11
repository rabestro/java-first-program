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
