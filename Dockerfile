# Stage 1: Build
FROM gradle:7.3.1-jdk17 AS build
WORKDIR /app

# Kopiere alle Dateien für den Build
COPY . .

# Führe den Gradle-Build aus
RUN ./gradlew clean build --no-daemon --info --stacktrace

# Stage 2: Run
FROM openjdk:17-jdk-slim
WORKDIR /app

# Kopiere nur die erzeugte JAR-Datei aus der Build-Stage
COPY --from=build /app/build/libs/carcosttracker-0.0.1-SNAPSHOT.jar carcosttracker.jar

# Exponiere den Port
EXPOSE 8080

# Starte die Anwendung
ENTRYPOINT ["java", "-jar", "build/libs/carcosttracker.jar"]
