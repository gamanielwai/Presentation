package com.todolist.presentation.repository;

// Importera de nödvändiga klasserna och interfacen
import com.todolist.presentation.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

// TodoRepository är ett interface som sträcker sig från JpaRepository.
// Det ger CRUD-operationer för Todo-objekt.
// Det andra argumentet till JpaRepository är typen för id.
public interface TodoRepository extends JpaRepository<Todo, Long> {
}