package com.lifepath.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lifepath.constants.HabitFrequency;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class HabitResponseDTO {
    @JsonProperty("name")
    private String name;
    @JsonProperty("frequency")
    private HabitFrequency frequency;
    @JsonProperty("totalTimesDone")
    private long totalTimesDone;
}
