package com.lifepath.models;

import javax.persistence.*;
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
    private String frequency; // e.g., Daily, Weekly

    // Getters and setters
}
