package com.lifepath.controller;

import com.lifepath.dto.request.ProgressRequestDTO;
import com.lifepath.models.ProgressModel;
import com.lifepath.models.UserModel;
import com.lifepath.service.ProgressService;
import com.lifepath.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/progress")
public class ProgressController {

    @Autowired
    private ProgressService progressModelService;

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<ProgressModel> createProgress(@RequestBody ProgressRequestDTO progress) {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserModel user = userService.findByUsername(username);
        return ResponseEntity.ok(progressModelService.saveProgress(progress,user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProgressModel> getProgressById(@PathVariable Long id) {
        return progressModelService.getProgressById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<ProgressModel>> getAllProgress() {
        return ResponseEntity.ok(progressModelService.getAllProgress());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProgress(@PathVariable Long id) {
        progressModelService.deleteProgress(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProgressModel> updateProgress(@PathVariable Long id, @RequestBody ProgressModel progress) {
        return ResponseEntity.ok(progressModelService.updateProgress(id, progress));
    }


    // Additional endpoints can be added here
}