package com.lifepath.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lifepath.dto.request.ProgressRequestDTO;
import com.lifepath.exceptions.ProgressException;
import com.lifepath.models.ProgressModel;
import com.lifepath.models.UserModel;
import com.lifepath.repository.ProgressRepository;
import com.lifepath.utils.ConsistencyValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgressService {

    @Autowired
    private ProgressRepository progressModelRepository;

    @Autowired
    ConsistencyValidator consistencyValidator;
    ObjectMapper objectMapper;

    public ProgressService(ProgressRepository progressModelRepository) {
        this.progressModelRepository = progressModelRepository;
        this.objectMapper = new ObjectMapper();
    }

    public ProgressModel saveProgress(ProgressRequestDTO progress, UserModel user) {
        ProgressModel progressModel = objectMapper.convertValue(progress, ProgressModel.class);
        progressModel.setUserId(user.getId());
        if(consistencyValidator.progressValidate(progressModel))
            progressModel = progressModelRepository.save(progressModel);
        else
            throw new ProgressException("Error in Progress Object");
        return progressModel;
    }


    public Optional<ProgressModel> getProgressById(Long id) {
        return progressModelRepository.findById(String.valueOf(id));
    }

    public List<ProgressModel> getAllProgress() {
        return progressModelRepository.findAll();
    }

    public void deleteProgress(Long id) {
        progressModelRepository.deleteById(String.valueOf(id));
    }

    public ProgressModel updateProgress(Long id, ProgressModel updatedProgress) {
        return progressModelRepository.findById(String.valueOf(id))
                .map(progress -> {
                    // Update fields of progress with updatedProgress fields
                    // Example: progress.setDate(updatedProgress.getDate());
                    // Repeat for other fields as needed
                    return progressModelRepository.save(progress);
                })
                .orElseGet(() -> {
                    updatedProgress.setId(id);
                    return progressModelRepository.save(updatedProgress);
                });
    }


    // Additional business logic methods can be added here
}

