# Starta från en bas Java-bild
FROM openjdk:17-jdk-alpine

# Variabel för applikationens jar-fil
ARG JAR_FILE=target/presentation-0.0.1-SNAPSHOT.jar

# Kopiera jar-filen till behållaren
COPY ${JAR_FILE} app.jar

# Exponera porten som applikationen lyssnar på
EXPOSE 8080

# Startkommando
ENTRYPOINT ["java","-jar","/app.jar"]
