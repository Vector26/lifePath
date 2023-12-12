package com.lifepath.constants;

public enum SkillCategory {
    PHYSICAL("Physical"),
    MENTAL("Mental"),
    PHILOSOPHICAL("Philosophical");
    // Add other categories as needed

    private final String description;

    SkillCategory(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
