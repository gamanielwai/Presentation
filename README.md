# Presentation

# Todo-app projekt

Detta projekt är en enkel Todo-applikation som består av en frontend byggd med React och en backend byggd med Spring Boot.

Projektet är uppdelat i två huvudkataloger:

- frontend/todo-app: Innehåller källkoden för frontend-applikationen.
- backend/presentation: Innehåller källkoden för backend-applikationen.

Varje katalog har en egen Dockerfile som används för att bygga en Docker-behållare för den delen av applikationen.

## Bygga och köra hela applikationen

För att bygga och köra hela applikationen, följ följande steg:

1. Öppna en terminal.
2. Klona detta Git-repository till din lokala maskin.
3. Navigera till `backend/presentation` mappen.
4. Kör `mvn clean package` för att bygga `.jar` filen för backend.
5. Kör `docker build -t presentation .` för att bygga Docker-behållaren för backend.
6. Navigera till `frontend/todo-app` mappen.
7. Kör `docker build -t todo-app .` för att bygga Docker-behållaren för frontend.
8. Kör `docker run -p 8080:8080 presentation` för att starta backend-behållaren.
9. Kör `docker run -p 3000:3000 todo-app` för att starta frontend-behållaren.

När båda behållarna körs kan du öppna en webbläsare och navigera till http://localhost:3000 för att se applikationen. Observera att om du kör Docker i vissa miljöer, som Docker Quickstart Terminal i Windows, kanske du behöver använda en annan IP-adress. I dessa fall, försök navigera till http://192.168.99.100:3000 istället.
