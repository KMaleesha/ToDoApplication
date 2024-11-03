package org.myonlinestore.todoapplication.controller;

import jakarta.validation.Valid;
import org.myonlinestore.todoapplication.enums.PriorityType;
import org.myonlinestore.todoapplication.enums.StatusType;
import org.myonlinestore.todoapplication.model.ToDoItems;
import org.myonlinestore.todoapplication.service.ToDoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
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

    @GetMapping(value = "/get/title/{title}")
    public List<ToDoItems> getByTitle(@PathVariable String title) {
        return toDoItemService.getByTitle(title);
    }

    @GetMapping(value = "/search/title")
    public List<ToDoItems> searchByTitle(@RequestParam String title) {
        return toDoItemService.getByTitle(title);
    }

    @GetMapping(value = "/get/priority/{priority}")
    public List<ToDoItems> getByPriority(@PathVariable PriorityType priority) {
        return toDoItemService.getByPriority(priority);
    }

    @GetMapping(value = "/search/priority")
    public List<ToDoItems> searchByPriority(@RequestParam PriorityType priority) {
        return toDoItemService.getByPriority(priority);
    }

    @GetMapping(value = "/get/status/{status}")
    public List<ToDoItems> getByStatus(@PathVariable StatusType status) {
        return toDoItemService.getByStatus(status);
    }

    @GetMapping(value = "/search/status")
    public List<ToDoItems> searchByStatus(@RequestParam StatusType status) {
        return toDoItemService.getByStatus(status);
    }

    @GetMapping(value = "/get/due-date/{dueDate}")
    public List<ToDoItems> getByDueDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dueDate) {
        return toDoItemService.getByDueDate(dueDate);
    }

    @GetMapping(value = "/search/due-date")
    public List<ToDoItems> searchByDueDate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dueDate) {
        return toDoItemService.getByDueDate(dueDate);
    }

    @GetMapping(value = "/get/created-date{createdDate}")
    public List<ToDoItems> getByCreatedDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Timestamp createdDate) {
        return toDoItemService.getByCreatedDate(createdDate);
    }

    @GetMapping(value = "/search/created-date")
    public List<ToDoItems> searchByCreatedDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Timestamp createdDate) {
        return toDoItemService.getByCreatedDate(createdDate);
    }

}
