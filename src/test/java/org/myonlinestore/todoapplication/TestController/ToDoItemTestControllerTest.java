//package org.myonlinestore.todoapplication.TestController;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.myonlinestore.todoapplication.Constant.ToDoItemAPIConstant;
//import org.myonlinestore.todoapplication.controller.ToDoItemController;
//import org.myonlinestore.todoapplication.enums.PriorityType;
//import org.myonlinestore.todoapplication.enums.StatusType;
//import org.myonlinestore.todoapplication.model.ToDoItems;
//import org.myonlinestore.todoapplication.service.ToDoItemService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultMatcher;
//
//import java.sql.Timestamp;
//import java.util.Collections;
//import java.util.Date;
//import java.util.Optional;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.eq;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@WebMvcTest(ToDoItemController.class)
//@AutoConfigureMockMvc
//class ToDoItemTestControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private ToDoItemService toDoItemService;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void testSaveToDoItem() throws Exception {
//        ToDoItems newItem = new ToDoItems();
//        newItem.setId(1);
//        newItem.setTitle("Test Title");
//        newItem.setDescription("Test Description");
//        newItem.setPriority(PriorityType.HIGH);
//        newItem.setStatus(StatusType.TODO);
//        newItem.setDueDate(new Date());
//        newItem.setCreatedDate(new Timestamp(System.currentTimeMillis()));
//
//        when(toDoItemService.saveTodoItem(any(ToDoItems.class))).thenReturn(newItem);
//
//        mockMvc.perform(post(ToDoItemAPIConstant.SAVE_ITEM)
//                .contentType(MediaType.APPLICATION_JSON)
//                .content("{\"title\":\"Test Title\", \"description\":\"Test Description\", \"priority\":\"HIGH\", \"status\":\"TODO\"}"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.title").value("Test Title"))
//                .andExpect(jsonPath("$.description").value("Test Description"))
//                .andExpect(jsonPath("$.priority").value("HIGH"))
//                .andExpect(jsonPath("$.status").value("TODO"))
//                .andExpect(jsonPath("$.dueDate").value(newItem.getDueDate().getTime()))
//                .andExpect(jsonPath("$.createdDate").value(newItem.getCreatedDate().getTime()));
//    }
//
//
//    @Test
//    void testGetItem() throws Exception {
//        ToDoItems item = new ToDoItems();
//        item.setId(1);
//        item.setTitle("Test Title");
//
//        when(toDoItemService.getTodoItemById(1)).thenReturn(Optional.of(item));
//
//        mockMvc.perform(get(ToDoItemAPIConstant.GET_ITEM, 1))
//                .andExpect(status().isOk())
//                .andExpect((ResultMatcher) jsonPath("$.title").value("Test Title"));
//    }
//
//    @Test
//    void testGetAllItems() throws Exception {
//        ToDoItems item = new ToDoItems();
//        item.setId(1);
//        item.setTitle("Test Title");
//
//        when(toDoItemService.getAllTodoItems(any())).thenReturn(Collections.singletonList(item));
//
//        mockMvc.perform(get(ToDoItemAPIConstant.GET_ALL_ITEMS))
//                .andExpect(status().isOk())
//                .andExpect((ResultMatcher) jsonPath("$[0].title").value("Test Title"));
//    }
//
//    @Test
//    void testUpdateToDoItems() throws Exception {
//        ToDoItems updatedItem = new ToDoItems();
//        updatedItem.setId(1);
//        updatedItem.setTitle("Updated Title");
//
//        when(toDoItemService.updateTodoItem(eq(1), any(ToDoItems.class))).thenReturn(updatedItem);
//
//        mockMvc.perform(put(ToDoItemAPIConstant.UPDATE_ITEM, 1)
//                .contentType(MediaType.APPLICATION_JSON)
//                .content("{\"title\":\"Updated Title\"}"))
//                .andExpect(status().isOk())
//                .andExpect((ResultMatcher) jsonPath("$.title").value("Updated Title"));
//    }
//
//    @Test
//    void testDeleteToDoItem() throws Exception {
//        when(toDoItemService.deleteTodoItem(1)).thenReturn("Item deleted");
//
//        mockMvc.perform(delete(ToDoItemAPIConstant.DELETE_ITEM, 1))
//                .andExpect(status().isOk())
//                .andExpect(content().string("Item deleted"));
//    }
//
//    @Test
//    void testGetByTitle() throws Exception {
//        ToDoItems item = new ToDoItems();
//        item.setId(1);
//        item.setTitle("Test Title");
//
//        when(toDoItemService.getByTitle("Test Title")).thenReturn(Collections.singletonList(item));
//
//        mockMvc.perform(get(ToDoItemAPIConstant.GET_BY_TITLE, "Test Title"))
//                .andExpect(status().isOk())
//                .andExpect((ResultMatcher) jsonPath("$[0].title").value("Test Title"));
//    }
//
//    @Test
//    void testSearchByTitle() throws Exception {
//        ToDoItems item = new ToDoItems();
//        item.setId(1);
//        item.setTitle("Test Title");
//
//        when(toDoItemService.getByTitle("Test Title")).thenReturn(Collections.singletonList(item));
//
//        mockMvc.perform(get(ToDoItemAPIConstant.SEARCH_BY_TITLE).param("title", "Test Title"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].title").value("Test Title"));
//    }
//
//    @Test
//    void testGetByPriority() throws Exception {
//        ToDoItems item = new ToDoItems();
//        item.setId(1);
//        item.setTitle("Test Title");
//        item.setPriority(PriorityType.HIGH);
//
//        when(toDoItemService.getByPriority(PriorityType.HIGH)).thenReturn(Collections.singletonList(item));
//
//        mockMvc.perform(get(ToDoItemAPIConstant.GET_BY_PRIORITY, "HIGH"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].priority").value("HIGH"));
//    }
//
//    @Test
//    void testSearchByPriority() throws Exception {
//        ToDoItems item = new ToDoItems();
//        item.setId(1);
//        item.setTitle("Test Title");
//        item.setPriority(PriorityType.MEDIUM);
//
//        when(toDoItemService.getByPriority(PriorityType.MEDIUM)).thenReturn(Collections.singletonList(item));
//
//        mockMvc.perform(get(ToDoItemAPIConstant.SEARCH_BY_PRIORITY).param("priority", "MEDIUM"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].priority").value("MEDIUM"));
//    }
//
//    @Test
//    void testGetByStatus() throws Exception {
//        ToDoItems item = new ToDoItems();
//        item.setId(1);
//        item.setTitle("Test Title");
//        item.setStatus(StatusType.TODO);
//
//        when(toDoItemService.getByStatus(StatusType.TODO)).thenReturn(Collections.singletonList(item));
//
//        mockMvc.perform(get(ToDoItemAPIConstant.GET_BY_STATUS, "TODO"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].status").value("TODO"));
//    }
//
//    @Test
//    void testSearchByStatus() throws Exception {
//        ToDoItems item = new ToDoItems();
//        item.setId(1);
//        item.setTitle("Test Title");
//        item.setStatus(StatusType.COMPLETED);
//
//        when(toDoItemService.getByStatus(StatusType.COMPLETED)).thenReturn(Collections.singletonList(item));
//
//        mockMvc.perform(get(ToDoItemAPIConstant.SEARCH_BY_STATUS).param("status", "COMPLETED"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].status").value("COMPLETED"));
//    }
//
//    @Test
//    void testGetByDueDate() throws Exception {
//        ToDoItems item = new ToDoItems();
//        item.setId(1);
//        item.setDueDate(new Date());
//
//        when(toDoItemService.getByDueDate(any(Date.class))).thenReturn(Collections.singletonList(item));
//
//        mockMvc.perform(get(ToDoItemAPIConstant.GET_BY_DUE_DATE, "2024-12-31"))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    void testSearchByDueDate() throws Exception {
//        ToDoItems item = new ToDoItems();
//        item.setId(1);
//        item.setDueDate(new Date());
//
//        when(toDoItemService.getByDueDate(any(Date.class))).thenReturn(Collections.singletonList(item));
//
//        mockMvc.perform(get(ToDoItemAPIConstant.SEARCH_BY_DUE_DATE).param("dueDate", "2024-12-31"))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    void testGetByCreatedDate() throws Exception {
//        ToDoItems item = new ToDoItems();
//        item.setId(1);
//        item.setCreatedDate(new Timestamp(System.currentTimeMillis()));
//
//        when(toDoItemService.getByCreatedDate(any(Timestamp.class))).thenReturn(Collections.singletonList(item));
//
//        mockMvc.perform(get(ToDoItemAPIConstant.GET_BY_CREATED_DATE).param("createdDate", "2024-11-03T10:30:00"))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    void testSearchByCreatedDate() throws Exception {
//        ToDoItems item = new ToDoItems();
//        item.setId(1);
//        item.setCreatedDate(new Timestamp(System.currentTimeMillis()));
//
//        when(toDoItemService.getByCreatedDate(any(Timestamp.class))).thenReturn(Collections.singletonList(item));
//
//        mockMvc.perform(get(ToDoItemAPIConstant.SEARCH_BY_CREATED_DATE).param("createdDate", "2024-11-03T10:30:00"))
//                .andExpect(status().isOk());
//    }
//
//}
