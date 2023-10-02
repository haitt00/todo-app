package com.example.todomongoapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


@RestController
@RequestMapping("/api")
public class TodoResource {

    private final Logger log = LoggerFactory.getLogger(TodoResource.class);

    private final TodoRepository todoRepository;

    public TodoResource(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @PostMapping("/todos")
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) throws URISyntaxException {
        Todo result = todoRepository.save(todo);
        return ResponseEntity.created(new URI("/api/todos/" + result.getId())).body(result);
    }

    @GetMapping("/todos/{id}")
    public ResponseEntity<Todo> getTodo(@PathVariable String id){
        return ResponseEntity.ok(todoRepository.findById(id).orElseThrow());
    }

    @GetMapping("/todos")
    public List<Todo> getTodos(){
        return todoRepository.findAll();
    }

    @PutMapping("/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String id, @RequestBody Todo todo){
        return ResponseEntity.ok(todoRepository.save(todo));
    }

    @DeleteMapping("/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String id) {
        todoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

