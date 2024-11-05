package org.myonlinestore.todoapplication.service.Impl;

import org.myonlinestore.todoapplication.enums.PriorityType;
import org.myonlinestore.todoapplication.enums.StatusType;
import org.myonlinestore.todoapplication.model.ToDoItems;
import org.myonlinestore.todoapplication.repository.ToDoItemRepository;
import org.myonlinestore.todoapplication.service.ToDoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;
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

    @Override
    public List<ToDoItems> getByTitle(String title) {
        return toDoItemRepository.findByTitleContaining(title);
    }

    @Override
    public List<ToDoItems> getByPriority(PriorityType priority) {
        return toDoItemRepository.findByPriority(priority);
    }

    @Override
    public List<ToDoItems> getByStatus(StatusType status) {
         return toDoItemRepository.findByStatus(status);
    }

    @Override
    public List<ToDoItems> getByDueDate(Date dueDate) {
       return toDoItemRepository.findByDueDate(dueDate);
    }

    @Override
    public List<ToDoItems> getByCreatedDate(Timestamp createdDate) {
        return toDoItemRepository.findByCreatedDate(createdDate);
    }

    @Override
    public Page<ToDoItems> getAllItems(Pageable pageable) {
        return toDoItemRepository.findAll(pageable);
    }

}
