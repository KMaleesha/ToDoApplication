package org.myonlinestore.todoapplication.repository;

import org.myonlinestore.todoapplication.model.toDoItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface toDoItemRepository extends JpaRepository<toDoItems, Integer> {
}
