package com.todolist.presentation.controller;

// Importera nödvändiga paket
import com.todolist.presentation.domain.Todo;
import com.todolist.presentation.exception.TodoNotFoundException;
import com.todolist.presentation.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Deklarera att denna klass är en REST Controller
@RestController
// Alla vägar i denna kontroller börjar med "/api/v1/todos"
@RequestMapping("/api/v1/todos")
public class TodoController {

    // Injicera TodoService automatiskt
    @Autowired
    private TodoService todoService;

    // Definiera en GET-metod för att hämta alla todos
    @GetMapping
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }

    // Definiera en POST-metod för att skapa en todo
    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        return todoService.createTodo(todo);
    }

    // Definiera en GET-metod för att hämta en specifik todo med id
    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Long id) {
        return todoService.getTodoById(id)
                .map(todo -> ResponseEntity.ok().body(todo))
                .orElse(ResponseEntity.notFound().build());
    }

    // Definiera en PUT-metod för att uppdatera en specifik todo med id
    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable Long id,
                                           @RequestBody Todo todoDetails) {
        try {
            Todo updatedTodo = todoService.updateTodo(id, todoDetails);
            return ResponseEntity.ok(updatedTodo);
        } catch (TodoNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Definiera en DELETE-metod för att ta bort en specifik todo med id
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable Long id) {
        try {
            todoService.deleteTodo(id);
            return ResponseEntity.ok().build();
        } catch (TodoNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}