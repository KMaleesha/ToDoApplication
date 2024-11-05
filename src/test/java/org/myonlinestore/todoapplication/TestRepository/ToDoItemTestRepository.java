package org.myonlinestore.todoapplication.TestRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.myonlinestore.todoapplication.enums.PriorityType;
import org.myonlinestore.todoapplication.enums.StatusType;
import org.myonlinestore.todoapplication.model.ToDoItems;
import org.myonlinestore.todoapplication.repository.ToDoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.NONE, replace = AutoConfigureTestDatabase.Replace.NONE)
public class ToDoItemTestRepository {

    @Autowired
    ToDoItemRepository toDoItemRepository;

    @Test
    public void TodoItemsRepository_saveAll_ReturnSavedTodoItems() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        ToDoItems toDoItems = ToDoItems.builder()
                .title("Todo item title")
                .description("Todo description")
                .priority(PriorityType.HIGH)
                .status(StatusType.TODO)
                .dueDate(dateFormat.parse("2024-10-11"))
                .createdDate(Timestamp.valueOf("2024-10-10 00:00:00")).build();

        ToDoItems savedItems = toDoItemRepository.save(toDoItems);

        Assertions.assertNotNull(savedItems);
        Assertions.assertTrue(savedItems.getId() > 0);
        Assertions.assertEquals(toDoItems.getTitle(), savedItems.getTitle());
        Assertions.assertEquals(toDoItems.getDescription(), savedItems.getDescription());
        Assertions.assertEquals(toDoItems.getPriority(), savedItems.getPriority());
        Assertions.assertEquals(toDoItems.getStatus(), savedItems.getStatus());
        Assertions.assertEquals(toDoItems.getDueDate(), savedItems.getDueDate());
        Assertions.assertEquals(toDoItems.getCreatedDate(), savedItems.getCreatedDate());
    }

    @Test
    public void TodoItemsRepository_findAll_ReturnAllTodoItems() {

        ToDoItems toDoItems = ToDoItems.builder()
                .title("Todo item title")
                .description("Todo description")
                .priority(PriorityType.HIGH)
                .status(StatusType.TODO)
                .dueDate(new Date(2024 - 1900, 9, 11))
                .createdDate(Timestamp.valueOf("2024-10-10 00:00:00")).build();

        ToDoItems toDoItems2 = ToDoItems.builder()
                .title("Todo item title")
                .description("Todo description")
                .priority(PriorityType.HIGH)
                .status(StatusType.TODO)
                .dueDate(new Date(2024 - 1900, 9, 11))
                .createdDate(Timestamp.valueOf("2024-10-10 00:00:00")).build();

        toDoItemRepository.save(toDoItems);
        toDoItemRepository.save(toDoItems2);

        List<ToDoItems> allTodoItems = toDoItemRepository.findAll();

        Assertions.assertNotNull(allTodoItems);
        Assertions.assertEquals(allTodoItems.size(), 5);
        Assertions.assertNotEquals(allTodoItems.size(), 0);
    }

    @Test
    public void TodoItemsRepository_findById_ReturnTodoItems() {

         ToDoItems toDoItems = ToDoItems.builder()
                .title("Todo item title")
                .description("Todo description")
                .priority(PriorityType.HIGH)
                .status(StatusType.TODO)
                .dueDate(new Date(2024 - 1900, 9, 11))
                .createdDate(Timestamp.valueOf("2024-10-10 00:00:00")).build();

         toDoItemRepository.save(toDoItems);

         ToDoItems toDoItem = toDoItemRepository.findById(toDoItems.getId()).orElse(null);
         Assertions.assertNotNull(toDoItem);
    }

    @Test
    public void TodoItemsRepository_findByTitleContaining_ReturnTodoItems() {

         ToDoItems toDoItems = ToDoItems.builder()
                .title("Todo item title")
                .description("Todo description")
                .priority(PriorityType.HIGH)
                .status(StatusType.TODO)
                .dueDate(new Date(2024 - 1900, 9, 11))
                .createdDate(Timestamp.valueOf("2024-10-10 00:00:00")).build();

         toDoItemRepository.save(toDoItems);

         List<ToDoItems> TodoItems = toDoItemRepository.findByTitleContaining(toDoItems.getTitle());
         Assertions.assertNotNull(TodoItems);
    }

    @Test
    public void TodoItemsRepository_findByPriority_ReturnTodoItems() {

         ToDoItems toDoItems = ToDoItems.builder()
                .title("Todo item title")
                .description("Todo description")
                .priority(PriorityType.HIGH)
                .status(StatusType.TODO)
                .dueDate(new Date(2024 - 1900, 9, 11))
                .createdDate(Timestamp.valueOf("2024-10-10 00:00:00")).build();

         toDoItemRepository.save(toDoItems);

         List<ToDoItems> TodoItems = toDoItemRepository.findByPriority(toDoItems.getPriority());
         Assertions.assertNotNull(TodoItems);
    }

    @Test
    public void TodoItemsRepository_findByStatus_ReturnTodoItems() {

         ToDoItems toDoItems = ToDoItems.builder()
                .title("Todo item title")
                .description("Todo description")
                .priority(PriorityType.HIGH)
                .status(StatusType.TODO)
                .dueDate(new Date(2024 - 1900, 9, 11))
                .createdDate(Timestamp.valueOf("2024-10-10 00:00:00")).build();

         toDoItemRepository.save(toDoItems);
         List<ToDoItems> foundItems = toDoItemRepository.findByStatus(toDoItems.getStatus());
         Assertions.assertNotNull(foundItems);
    }

    @Test
    public void TodoItemsRepository_findByDueDate_ReturnTodoItems() {

         ToDoItems toDoItems = ToDoItems.builder()
                .title("Todo item title")
                .description("Todo description")
                .priority(PriorityType.HIGH)
                .status(StatusType.TODO)
                .dueDate(new Date(2024 - 1900, 9, 11))
                .createdDate(Timestamp.valueOf("2024-10-10 00:00:00")).build();

         toDoItemRepository.save(toDoItems);
         List<ToDoItems> foundItems = toDoItemRepository.findByDueDate(toDoItems.getDueDate());
         Assertions.assertNotNull(foundItems);
    }

    @Test
    public void TodoItemsRepository_findByCreatedDate_ReturnTodoItems() {

         ToDoItems toDoItems = ToDoItems.builder()
                .title("Todo item title")
                .description("Todo description")
                .priority(PriorityType.HIGH)
                .status(StatusType.TODO)
                .dueDate(new Date(2024 - 1900, 9, 11))
                .createdDate(Timestamp.valueOf("2024-10-10 00:00:00")).build();

         toDoItemRepository.save(toDoItems);
         List<ToDoItems> foundItems = toDoItemRepository.findByCreatedDate(toDoItems.getCreatedDate());
         Assertions.assertNotNull(foundItems);
    }

    @Test
    public void TodoItemsRepository_UpdateTodoItem_ReturnTodoItems(){

        ToDoItems toDoItems = ToDoItems.builder()
                .title("Todo item title")
                .description("Todo description")
                .priority(PriorityType.HIGH)
                .status(StatusType.TODO)
                .dueDate(new Date(2024 - 1900, 9, 11))
                .createdDate(Timestamp.valueOf("2024-10-10 00:00:00")).build();

        toDoItemRepository.save(toDoItems);
        ToDoItems updateTodoItems = toDoItemRepository.findById(toDoItems.getId()).orElse(null);
        assert updateTodoItems != null;
        updateTodoItems.setTitle("Todo item title updated");
        updateTodoItems.setDescription("Todo description updated");
        updateTodoItems.setPriority(PriorityType.HIGH);
        updateTodoItems.setStatus(StatusType.TODO);
        updateTodoItems.setDueDate(new Date(2024 - 1900, 9, 11));
        updateTodoItems.setCreatedDate(Timestamp.valueOf("2024-10-10 00:00:00"));

        ToDoItems updatedTodoItem = toDoItemRepository.save(updateTodoItems);
        Assertions.assertNotNull(updatedTodoItem.getTitle());
        Assertions.assertNotNull(updatedTodoItem.getDescription());
        Assertions.assertNotNull(updatedTodoItem.getPriority());
        Assertions.assertNotNull(updatedTodoItem.getStatus());
        Assertions.assertNotNull(updatedTodoItem.getDueDate());
        Assertions.assertNotNull(updatedTodoItem.getCreatedDate());
    }

    @Test
    public void TodoItemRepository_deleteTodoItem_ReturnDeleteResult(){

        ToDoItems toDoItems = ToDoItems.builder()
                .title("Todo item title")
                .description("Todo description")
                .priority(PriorityType.HIGH)
                .status(StatusType.TODO)
                .dueDate(new Date(2024 - 1900, 9, 11))
                .createdDate(Timestamp.valueOf("2024-10-10 00:00:00")).build();

        toDoItemRepository.save(toDoItems);
        toDoItemRepository.deleteById(toDoItems.getId());
        Optional<ToDoItems> todoItemsReturn = toDoItemRepository.findById(toDoItems.getId());

        Assertions.assertFalse(todoItemsReturn.isPresent());
    }
}
