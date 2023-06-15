package com.todolist.presentation.config;

// Importera paketen som behövs för att konfigurera CORS
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// Deklarera att denna klass är en konfigurationsklass
@Configuration
public class CorsConfig {

    // Skapa en Bean som konfigurerar CORS
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        // Skapa en anonym klass som implementerar WebMvcConfigurer
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // Lägg till en CORS-mapping
                // Från följande ursprung (http://localhost:3000 och http://192.168.99.100:8080)
                // Med följande metoder (GET, POST, PUT, DELETE, HEAD, OPTIONS)
                // Alla headers tillåts (*)
                // Cookies (credentials) tillåts
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:3000", "http://192.168.99.100:8080")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }
}