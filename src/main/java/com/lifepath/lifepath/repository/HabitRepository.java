package com.lifepath.lifepath.repository;


import com.lifepath.lifepath.models.HabitModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HabitRepository extends JpaRepository<HabitModel, Long> {
    List<HabitModel> findByUserId(Long userId);
}

