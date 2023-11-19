package com.example.tasklistbackend.controllers;

import com.example.tasklistbackend.models.Task;
import com.example.tasklistbackend.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
@CrossOrigin(origins = "https://vlad-list-frontend-7f96262457c5.herokuapp.com/")
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> getTask(@PathVariable Long id) {
        Task task = taskService.getTask(id);
        return task != null ? ResponseEntity.ok(task) : ResponseEntity.badRequest().body("Task not found");
    }

    @PostMapping("/create")
    public ResponseEntity<?> createTask(@RequestBody Task task) {
        taskService.createTask(task);
        return ResponseEntity.ok("Task created successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateTask(@PathVariable Long id, @RequestBody Task task) {
        taskService.updateTask(id, task);
        return ResponseEntity.ok("Task updated successfully");
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateAllTasks(@RequestBody List<Task> tasks) {
        try {
            taskService.updateTaskOrder(tasks);
            return ResponseEntity.ok("Tasks updated successfully");
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating tasks order: " + e.getMessage());
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok("Task deleted");
    }
}
