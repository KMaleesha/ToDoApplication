package org.myonlinestore.todoapplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class toDoItems {

    @Id
    private int id;

    private String title;
    private String description;
    private int priority;
    private String status;
    private LocalDateTime dueDate;
    private LocalDateTime createdDate;
}
