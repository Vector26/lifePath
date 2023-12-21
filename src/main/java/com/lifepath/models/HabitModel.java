package com.lifepath.models;

import javax.persistence.*;

import com.lifepath.constants.HabitFrequency;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "habits")
@Data
@NoArgsConstructor
public class HabitModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel userModel;

    private String name;
    private HabitFrequency frequency;
    private long totalTimesDone;
    // Getters and setters
}
