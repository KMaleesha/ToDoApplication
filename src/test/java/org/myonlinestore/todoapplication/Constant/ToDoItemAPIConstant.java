package org.myonlinestore.todoapplication.Constant;

public class ToDoItemAPIConstant {
    public static final String BASE_URL = "/api/todo";

    public static final String SAVE_ITEM = BASE_URL + "/save";
    public static final String GET_ITEM = BASE_URL + "/get-item/{id}";
    public static final String GET_ALL_ITEMS = BASE_URL + "/all/items";
    public static final String UPDATE_ITEM = BASE_URL + "/update/{id}";
    public static final String DELETE_ITEM = BASE_URL + "/delete/{id}";
    public static final String GET_BY_TITLE = BASE_URL + "/get/title/{title}";
    public static final String SEARCH_BY_TITLE = BASE_URL + "/search/title";
    public static final String GET_BY_PRIORITY = BASE_URL + "/get/priority/{priority}";
    public static final String SEARCH_BY_PRIORITY = BASE_URL + "/search/priority";
    public static final String GET_BY_STATUS = BASE_URL + "/get/status/{status}";
    public static final String SEARCH_BY_STATUS = BASE_URL + "/search/status";
    public static final String GET_BY_DUE_DATE = BASE_URL + "/get/due-date/{dueDate}";
    public static final String SEARCH_BY_DUE_DATE = BASE_URL + "/search/due-date";
    public static final String GET_BY_CREATED_DATE = BASE_URL + "/get/created-date";
    public static final String SEARCH_BY_CREATED_DATE = BASE_URL + "/search/created-date";
}
