package org.myonlinestore.todoapplication.controller;

import jakarta.validation.Valid;
import org.myonlinestore.todoapplication.model.ToDoItems;
import org.myonlinestore.todoapplication.service.ToDoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/todo/")
public class ToDoItemController {

    @Autowired
    private ToDoItemService toDoItemService;

    @PostMapping(value = "/save")
    public ToDoItems save(@RequestBody ToDoItems items){
        return toDoItemService.saveTodoItem(items);
    }

    @GetMapping(value= "/get-item/{id}")
    public Optional<ToDoItems> getItem(@PathVariable int id){
        return toDoItemService.getTodoItemById(id);
    }

    @GetMapping(value="/all/items")
    public List<ToDoItems> getAllItems(ToDoItems items){
        return toDoItemService.getAllTodoItems(items);
    }

    @PutMapping(value = "/update/{id}")
    public ToDoItems updateToDoItems(@PathVariable int id, @RequestBody ToDoItems toDoItems){
        return toDoItemService.updateTodoItem(id,toDoItems);
    }

    @DeleteMapping(value="/delete/{id}")
    public String deleteToDoItem(@PathVariable int id){
        return toDoItemService.deleteTodoItem(id);
    }

}
