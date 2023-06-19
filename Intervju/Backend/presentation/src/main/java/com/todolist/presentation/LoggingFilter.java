package com.todolist.presentation;

// Importera nödvändiga klasser och interfaces
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

// @Component-annotationen gör att Spring kan hitta och konfigurera denna klass som en Bean.
@Component
public class LoggingFilter implements Filter {

    // Initialisera en Logger för att logga information
    private static final Logger logger = LoggerFactory.getLogger(LoggingFilter.class);

    // Skriver över doFilter metoden i Filter-interface. Denna metod körs för varje request och response i applikationen.
    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        // Casta ServletRequest till HttpServletRequest för att få tillgång till metoder specifika för HTTP-requests.
        HttpServletRequest req = (HttpServletRequest) request;

        // Logga information om HTTP-metoden, URI:n, och query string från requestet.
        logger.info("Request Info: {} {} : {}", req.getMethod(), req.getRequestURI(), req.getQueryString());

        // Fortsätt till nästa filter i filterkedjan. Om detta är det sista filtret i kedjan kommer requesten att
        // behandlas av den relevanta controller-metoden.
        chain.doFilter(request, response);
    }
}