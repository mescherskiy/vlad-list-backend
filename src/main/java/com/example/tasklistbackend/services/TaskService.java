package com.example.tasklistbackend.services;

import com.example.tasklistbackend.models.Task;
import com.example.tasklistbackend.repositories.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTask(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public void createTask(Task task) {
        task.setDone(false);
        taskRepository.save(task);
    }

    public void updateTask(Long id, Task task) {
        Task updatedTask = taskRepository.findById(id).orElse(null);
        if (updatedTask != null) {
            updatedTask.setLabel(task.getLabel());
            updatedTask.setDescription(task.getDescription());
            updatedTask.setTimestamp(task.getTimestamp());
            if (task.getDone() != null) {
                updatedTask.setDone(task.getDone());
            }
            taskRepository.save(updatedTask);
        }
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
