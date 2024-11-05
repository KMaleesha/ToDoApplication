package org.myonlinestore.todoapplication.service;

import org.myonlinestore.todoapplication.enums.PriorityType;
import org.myonlinestore.todoapplication.enums.StatusType;
import org.myonlinestore.todoapplication.model.ToDoItems;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public interface ToDoItemService {

    public ToDoItems saveTodoItem(ToDoItems toDoItems);
    public Optional<ToDoItems> getTodoItemById(int id);
    public List<ToDoItems> getAllTodoItems(ToDoItems toDoItems);
    public ToDoItems updateTodoItem(int id, ToDoItems toDoItems);
    public String deleteTodoItem(int id);
    public List<ToDoItems> getByTitle(String title);
    public List<ToDoItems> getByPriority(PriorityType priority);
    public List<ToDoItems> getByStatus(StatusType status);
    public List<ToDoItems> getByDueDate(Date dueDate);
    public List<ToDoItems> getByCreatedDate(Timestamp createdDate);
    public Page<ToDoItems> getAllItems(Pageable pageable);
}
