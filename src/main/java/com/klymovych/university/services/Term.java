package com.klymovych.university.services;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public enum Term {
    TODAY(ChronoUnit.DAYS),
    WEEK(ChronoUnit.WEEKS),
    MONTH(ChronoUnit.MONTHS);

    private final ChronoUnit unit;

    Term(ChronoUnit unit) {
        this.unit = unit;
    }

    public LocalDate addToDate(LocalDate date) {
        return date.plus(1, unit);
    }
}