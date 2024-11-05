package org.myonlinestore.todoapplication.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.myonlinestore.todoapplication.enums.PriorityType;
import org.myonlinestore.todoapplication.enums.StatusType;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@Table(name = "items")
@AllArgsConstructor
@NoArgsConstructor
public class ToDoItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String description;

    @Enumerated
    private PriorityType priority;

    @Enumerated
    private StatusType status;

    private Date dueDate;
    private Timestamp createdDate;
}
