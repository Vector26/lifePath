package com.lifepath.constants;

public enum HabitFrequency {
    DAILY("DAILY"),
    WEEKLY("WEEKLY"),
    BI_WEEKLY("BI_WEEKLY"),

    MONTHLY("MONTHLY");

    private final String description;

    HabitFrequency(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
