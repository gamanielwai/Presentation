package com.todolist.presentation.domain;

// Importera nödvändiga paket
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// Definiera att denna klass är en tabell i databasen
@Entity
public class Todo {
    // Deklarera id som primärnyckel och att dess värde ska genereras automatiskt
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // Resten av fälten i Todo-klassen representerar kolumner i tabellen
    private String title;
    private String description;
    private Boolean completed;

    // Getter och setter-metoder för alla fält
    // Dessa metoder används för att hämta och ändra fältens värde
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}