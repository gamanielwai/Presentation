package com.todolist.presentation.service;

// Importera nödvändiga klasser och interfaces
import com.todolist.presentation.domain.Todo;
import com.todolist.presentation.exception.TodoNotFoundException;
import com.todolist.presentation.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// @Service-annotationen används för att indikera att klassen är en "Service",
// vilket innebär att den innehåller affärslogik.
@Service
public class TodoService {

    // @Autowired-annotationen används för att automatiskt injecta beroendet TodoRepository
    @Autowired
    private TodoRepository todoRepository;

    // Metod för att hämta alla Todo-objekt från databasen
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    // Metod för att hämta en specifik Todo baserat på id
    public Optional<Todo> getTodoById(Long id) {
        return todoRepository.findById(id);
    }

    // Metod för att skapa ett nytt Todo-objekt
    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    // Metod för att uppdatera ett befintligt Todo-objekt.
    // Om Todo-objektet inte finns kastas ett undantag.
    public Todo updateTodo(Long id, Todo todoDetails) {
        Optional<Todo> optionalTodo = todoRepository.findById(id);

        if (!optionalTodo.isPresent()) {
            throw new TodoNotFoundException(id);
        }

        Todo todo = optionalTodo.get();
        todo.setTitle(todoDetails.getTitle());
        todo.setDescription(todoDetails.getDescription());
        todo.setCompleted(todoDetails.getCompleted());

        return todoRepository.save(todo);
    }

    // Getter och Setter för todoRepository
    public TodoRepository getTodoRepository() {
        return todoRepository;
    }

    public void setTodoRepository(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    // Metod för att radera ett specifikt Todo-objekt baserat på id.
    // Om Todo-objektet inte finns kastas ett undantag.
    public void deleteTodo(Long id) {
        if (!todoRepository.existsById(id)) {
            throw new TodoNotFoundException(id);
        }

        todoRepository.deleteById(id);
    }
}