package com.lifepath.service;

import com.lifepath.models.HabitModel;
import com.lifepath.repository.HabitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitService {

    @Autowired
    private HabitRepository habitRepository;

    public HabitModel createHabit(HabitModel habit) {
        return habitRepository.save(habit);
    }

    public HabitModel getHabitById(Long id) {
        return habitRepository.findById(id).orElse(null);
    }

    public List<HabitModel> getAllHabits() {
        return habitRepository.findAll();
    }

    public HabitModel updateHabit(Long id, HabitModel updatedHabit) {
        return habitRepository.findById(id)
                .map(habit -> {
                    habit.setName(updatedHabit.getName());
                    habit.setFrequency(updatedHabit.getFrequency());
                    // Set other fields as necessary
                    return habitRepository.save(habit);
                }).orElse(null);
    }

    public boolean deleteHabit(Long id) {
        if (habitRepository.existsById(id)) {
            habitRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
