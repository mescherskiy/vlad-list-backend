package com.example.tasklistbackend.repositories;

import com.example.tasklistbackend.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Optional<Task> findById(Long id);
    List<Task> findAll();

    List<Task> findAllByOrderByOrderIndexAsc();

}
