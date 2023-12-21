package com.lifepath.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lifepath.models.ProgressModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProgressRequestDTO {
    @JsonProperty("date")
    private Date date;
    @JsonProperty("habits")
    private List<Long> habitIds;
    @JsonProperty("reflections")
    private List<String> reflectionIds;
    @JsonProperty("events")
    private List<Long> eventIds; //Need to reunderstand the use of this has-a relationship

    @JsonProperty("skillsProgress")
    private List<ProgressModel.SkillProgress> skillProgresses;
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
}
