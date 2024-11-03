package org.myonlinestore.todoapplication.service.Impl;

import org.myonlinestore.todoapplication.model.ToDoItems;
import org.myonlinestore.todoapplication.repository.ToDoItemRepository;
import org.myonlinestore.todoapplication.service.ToDoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ToDoItemServiceImpl implements ToDoItemService {

    @Autowired
    private ToDoItemRepository toDoItemRepository;

    @Override
    public ToDoItems saveTodoItem(ToDoItems toDoItems) {
        return toDoItemRepository.save(toDoItems);
    }

    @Override
    public Optional<ToDoItems> getTodoItemById(int id) {
        return toDoItemRepository.findById(id);
    }

    @Override
    public List<ToDoItems> getAllTodoItems(ToDoItems toDoItems) {
        return toDoItemRepository.findAll();
    }

    @Override
    public ToDoItems updateTodoItem(int id, ToDoItems toDoItems) {
       Optional<ToDoItems> items = toDoItemRepository.findById(id);

       if(items.isPresent()){
           ToDoItems newTodoItems = items.get();

           newTodoItems.setTitle(toDoItems.getTitle());
           newTodoItems.setDescription(toDoItems.getDescription());
           newTodoItems.setPriority(toDoItems.getPriority());
           newTodoItems.setStatus(toDoItems.getStatus());
           newTodoItems.setCreatedDate(toDoItems.getCreatedDate());
           newTodoItems.setDueDate(toDoItems.getDueDate());
           return  toDoItemRepository.save(newTodoItems);
       }else {
           throw new RuntimeException("User not found with id: " + id);
       }
    }

    @Override
    public String deleteTodoItem(int id) {
        Optional<ToDoItems> toDoItem = toDoItemRepository.findById(id);
        if(toDoItem.isPresent()){
            toDoItemRepository.deleteById(id);
            return "User Deleted";
        }else{
            return "User not Found";
        }
    }
}
