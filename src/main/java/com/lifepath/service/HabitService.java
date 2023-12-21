package com.lifepath.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lifepath.dto.HabitResponseDTO;
import com.lifepath.models.HabitModel;
import com.lifepath.models.UserModel;
import com.lifepath.repository.HabitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HabitService {

    @Autowired
    private HabitRepository habitRepository;

    ObjectMapper objectMapper;

    public HabitService(HabitRepository habitRepository) {
        this.habitRepository = habitRepository;
        this.objectMapper = new ObjectMapper();
    }

    public HabitResponseDTO createHabit(HabitModel habit) {
        habitRepository.save(habit);
        HabitResponseDTO habitResponseDTO = objectMapper.convertValue(habit, HabitResponseDTO.class);
        return habitResponseDTO;
    }

    public HabitResponseDTO getHabitById(Long id) {
        HabitModel habitModel = habitRepository.findById(id).orElse(null);
        HabitResponseDTO habitResponseDTO = objectMapper.convertValue(habitModel, HabitResponseDTO.class);
        return habitResponseDTO;
    }

    public List<HabitResponseDTO> getAllHabitsByUser(UserModel userModel) {
        List<HabitModel> habits = habitRepository.findByUserModelId(userModel.getId());
        List<HabitResponseDTO> habitResponseDTOS = habits.stream()
                .map(habit -> objectMapper.convertValue(habit, HabitResponseDTO.class))
                .collect(Collectors.toList());
        return habitResponseDTOS;
    }

    public HabitResponseDTO updateHabit(Long id, HabitModel updatedHabit) {
        HabitModel habitModel = habitRepository.findById(id)
                .map(habit -> {
                    habit.setName(updatedHabit.getName());
                    habit.setFrequency(updatedHabit.getFrequency());
                    // Set other fields as necessary
                    return habitRepository.save(habit);
                }).orElse(null);
        HabitResponseDTO habitResponseDTO = objectMapper.convertValue(habitModel, HabitResponseDTO.class);
        return habitResponseDTO;
    }

    public boolean deleteHabit(Long id) {
        if (habitRepository.existsById(id)) {
            habitRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
