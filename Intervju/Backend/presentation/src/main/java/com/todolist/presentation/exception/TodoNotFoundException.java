package com.todolist.presentation.exception;

// TodoNotFoundException är en RuntimeException
public class TodoNotFoundException extends RuntimeException {

    // Konstruktor för TodoNotFoundException. Det tar in ett id (det id för vilket en Todo inte kunde hittas)
    // och kallar på RuntimeExceptions konstruktor med ett anpassat felmeddelande
    public TodoNotFoundException(Long id) {
        super("Todo not found with id " + id);
    }
}