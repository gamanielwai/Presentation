# Presentation

Detta projekt är en enkel Todo-applikation som består av en frontend byggd med React och en backend byggd med Spring Boot.

Projektet är uppdelat i två huvudkataloger:

frontend/todo-app: Innehåller källkoden för frontend-applikationen. backend/presentation: Innehåller källkoden för backend-applikationen. Varje katalog har en egen Dockerfile som används för att bygga en Docker-behållare för den delen av applikationen.

För att bygga och köra hela applikationen, följ följande steg:

Navigera till frontend/todo-app-katalogen. 

Kör docker build -t todo-app-frontend . för att bygga Docker-behållaren.

Kör docker build -t todo-app-backend . för att bygga Docker-behållaren. 

Kör applikationen

Kör docker run -p 3000:3000 todo-app-frontend för att starta frontend-behållaren. Kör docker run -p 8080:8080 todo-app-backend för att starta backend-behållaren. När båda behållarna körs kan du öppna en webbläsare och navigera till http://localhost:3000 för att se applikationen.
