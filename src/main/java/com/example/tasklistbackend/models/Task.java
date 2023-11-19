package com.example.tasklistbackend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;

import java.sql.Timestamp;
import java.util.Date;

@Data
@Builder
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String label;

    private String timestamp;

    private Boolean done;

    private Boolean important;

    private int orderIndex;


}
