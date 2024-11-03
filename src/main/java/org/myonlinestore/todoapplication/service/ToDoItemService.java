package org.myonlinestore.todoapplication.service;

import org.myonlinestore.todoapplication.model.ToDoItems;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ToDoItemService {

    public ToDoItems saveTodoItem(ToDoItems toDoItems);
    public Optional<ToDoItems> getTodoItemById(int id);
    public List<ToDoItems> getAllTodoItems(ToDoItems toDoItems);
    public ToDoItems updateTodoItem(int id, ToDoItems toDoItems);
    public String deleteTodoItem(int id);
}
