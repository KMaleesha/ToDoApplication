package org.myonlinestore.todoapplication.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "items")
public class ToDoItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String description;
    private int priority;
    private String status;
    private LocalDateTime dueDate;
    private LocalDateTime createdDate;
}
