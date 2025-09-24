# Use Maven to build, then switch to OpenJDK for runtime
FROM maven:3.9.4-eclipse-temurin-21 AS builder

WORKDIR /app

# Copy source code and build
COPY . .
RUN mvn clean package -DskipTests

# Runtime image
FROM openjdk:21-jdk-slim

WORKDIR /app

# Copy the JAR from the builder stage
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]