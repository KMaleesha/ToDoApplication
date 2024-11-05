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
}
