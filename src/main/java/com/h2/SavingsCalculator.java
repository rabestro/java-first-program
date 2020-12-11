package com.h2;

import java.time.LocalDate;

public class SavingsCalculator {
    private final float[] credits;
    private final float[] debits;

    public SavingsCalculator(float[] credits, float[] debits) {
        this.credits = credits;
        this.debits = debits;
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
        return -1;
    }
}
