package com.fajlay.todo.dto;

public class TodoDTO {
    private Long todoId;
    private String Todo;
    private Long personId;
    private String category;

    public TodoDTO() {
        super();
    }

    public TodoDTO(Long todoId, String todo) {
        this.todoId = todoId;
        Todo = todo;
    }

    public Long getTodoId() {
        return todoId;
    }

    public void setTodoId(Long todoId) {
        this.todoId = todoId;
    }

    public String getTodo() {
        return Todo;
    }

    public void setTodo(String todo) {
        Todo = todo;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "TodoDTO{" +
                "todoId=" + todoId +
                ", Todo='" + Todo + '\'' +
                '}';
    }
}
