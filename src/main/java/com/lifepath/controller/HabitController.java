package com.lifepath.controller;

import com.lifepath.models.HabitModel;
import com.lifepath.service.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habits")
public class HabitController {

    @Autowired
    private HabitService habitService;

    @PostMapping
    public ResponseEntity<HabitModel> createHabit(@RequestBody HabitModel habit) {
        HabitModel newHabit = habitService.createHabit(habit);
        return ResponseEntity.ok(newHabit);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HabitModel> getHabitById(@PathVariable Long id) {
        HabitModel habit = habitService.getHabitById(id);
        return habit != null ? ResponseEntity.ok(habit) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<HabitModel>> getAllHabits() {
        List<HabitModel> habits = habitService.getAllHabits();
        return ResponseEntity.ok(habits);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HabitModel> updateHabit(@PathVariable Long id, @RequestBody HabitModel updatedHabit) {
        HabitModel habit = habitService.updateHabit(id, updatedHabit);
        return habit != null ? ResponseEntity.ok(habit) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHabit(@PathVariable Long id) {
        boolean isDeleted = habitService.deleteHabit(id);
        return isDeleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}

