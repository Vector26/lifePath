package com.lifepath.models;

import com.lifepath.constants.SkillCategory;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;

@Document(collection = "skills")
@Getter
@Setter
public class SkillModel {

    @Id
    private String id;

    private String name;
    private SkillCategory category; // Using enum for category

    private float hoursSpent;

    @Transient
    private int level;

    public int getLevel() {
        // Exponential growth function for skill level
        return (int) Math.ceil(10 * (Math.log(hoursSpent + 1) / Math.log(10000)));
    }

    // Other getters and setters if needed
}