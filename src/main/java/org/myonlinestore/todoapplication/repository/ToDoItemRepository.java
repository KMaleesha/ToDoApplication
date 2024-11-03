package org.myonlinestore.todoapplication.repository;

import org.myonlinestore.todoapplication.enums.PriorityType;
import org.myonlinestore.todoapplication.enums.StatusType;
import org.myonlinestore.todoapplication.model.ToDoItems;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public interface ToDoItemRepository extends JpaRepository<ToDoItems, Integer> {
    public List<ToDoItems> findByTitleContaining(String title);
    public List<ToDoItems> findByPriority(PriorityType priority);
    public List<ToDoItems> findByStatus(StatusType status);
    public List<ToDoItems> findByDueDate(Date dueDate);
    public List<ToDoItems> findByCreatedDate(Timestamp createdDate);
}
