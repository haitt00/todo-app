package com.example.todomongoapp;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;

public class Todo {

    @Id
    public String id;

    public LocalDate created;

    public String content;

    public Todo(String id, LocalDate created, String content) {
        this.id = id;
        this.created = created;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id='" + id + '\'' +
                ", created=" + created +
                ", content='" + content + '\'' +
                '}';
    }
}
