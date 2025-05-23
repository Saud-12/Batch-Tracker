FROM openjdk:21-jdk-slim

WORKDIR /app

COPY build/libs/batchtracker-0.0.1-SNAPSHOT.jar batchtracker.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "batchtracker.jar"]