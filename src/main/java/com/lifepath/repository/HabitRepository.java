package com.lifepath.repository;


import com.lifepath.models.HabitModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HabitRepository extends JpaRepository<HabitModel, Long> {
    List<HabitModel> findByUserModelId(Long userId);

}

