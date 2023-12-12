package com.lifepath.service;

import com.lifepath.models.ReflectionModel;
import com.lifepath.repository.ReflectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReflectionService {

    @Autowired
    private ReflectionRepository reflectionRepository;

    public ReflectionModel createReflection(ReflectionModel reflection) {
        // Additional logic can be added here if needed to handle Markdown content
        return reflectionRepository.save(reflection);
    }

    public ReflectionModel getReflectionById(String id) {
        return reflectionRepository.findById(id).orElse(null);
    }

    public List<ReflectionModel> getAllReflections() {
        return reflectionRepository.findAll();
    }

    public ReflectionModel updateReflection(String id, ReflectionModel updatedReflection) {
        return reflectionRepository.findById(id)
                .map(reflection -> {
                    reflection.setContent(updatedReflection.getContent());
                    reflection.setReferencedReflectionIds(updatedReflection.getReferencedReflectionIds());
                    // Set other fields as necessary
                    return reflectionRepository.save(reflection);
                }).orElse(null);
    }

    public boolean deleteReflection(String id) {
        if (reflectionRepository.existsById(id)) {
            reflectionRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

