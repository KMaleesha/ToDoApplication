package org.myonlinestore.todoapplication.repository;

import org.myonlinestore.todoapplication.model.ToDoItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoItemRepository extends JpaRepository<ToDoItems, Integer> {
}
