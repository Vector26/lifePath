package com.lifepath.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Document(collection = "progresses")
@Data
@NoArgsConstructor
public class ProgressModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Date date;

    // Existing relationships
    private List<Long> habitIds;
    private List<String> reflectionIds;
    private List<Long> eventIds; //Need to reunderstand the use of this has-a relationship

    // New field for skill progress
    private List<SkillProgress> skillProgresses;
    @Data
    @NoArgsConstructor
    public class SkillProgress {
        private String skillId; // References the ID of a SkillModel
        private float hoursSpent; // Hours spent on that skill for the day
        //Need to add a back-update for Skill in context, to culminate the hours
        // Getters and setters
    }

    @Data
    @NoArgsConstructor
    public class HabitProgress {
        private Long habitId; // References the ID of a SkillModel
        private float habitStat; // Amount of habit completed
        // Getters and setters
    }
    // Getters and setters
}

