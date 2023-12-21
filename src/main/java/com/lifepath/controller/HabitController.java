package com.lifepath.controller;

import com.lifepath.dto.HabitResponseDTO;
import com.lifepath.models.HabitModel;
import com.lifepath.models.UserModel;
import com.lifepath.service.HabitService;
import com.lifepath.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/habits")
public class HabitController {

    @Autowired
    private HabitService habitService;

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<HabitResponseDTO> createHabit(@RequestBody HabitModel habit) {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserModel user = userService.findByUsername(username);
        habit.setUserModel(user);
        HabitResponseDTO newHabit = habitService.createHabit(habit);
        return ResponseEntity.ok(newHabit);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HabitResponseDTO> getHabitById(@PathVariable Long id) {
        HabitResponseDTO habit = habitService.getHabitById(id);
        return habit != null ? ResponseEntity.ok(habit) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<HabitResponseDTO>> getAllHabitsByUser() {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserModel user = userService.findByUsername(username);
        List<HabitResponseDTO> habits = habitService.getAllHabitsByUser(user);
        return ResponseEntity.ok(habits);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HabitResponseDTO> updateHabit(@PathVariable Long id, @RequestBody HabitModel updatedHabit) {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserModel user = userService.findByUsername(username);
        updatedHabit.setUserModel(user);
        HabitResponseDTO habit = habitService.updateHabit(id, updatedHabit);
        return habit != null ? ResponseEntity.ok(habit) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHabit(@PathVariable Long id) {
        boolean isDeleted = habitService.deleteHabit(id);
        return isDeleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}

