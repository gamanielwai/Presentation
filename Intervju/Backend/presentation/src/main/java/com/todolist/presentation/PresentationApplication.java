package com.todolist.presentation;

// Importera Spring Boot klasser
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PresentationApplication {

	// main metoden kör Spring Application
	public static void main(String[] args) {
		// SpringApplication.run metoden startar hela Spring Boot applikationen. Det startar den inbyggda Tomcat servern,
		// skapar ApplicationContext, och alla beans, etc.
		SpringApplication.run(PresentationApplication.class, args);
	}
}