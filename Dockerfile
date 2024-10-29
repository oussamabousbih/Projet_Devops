# Use a lightweight Java runtime image
FROM openjdk:17-jdk-slim

# Set a working directory in the container
WORKDIR /app

# Copy the Spring Boot JAR file into the container
COPY target/*.jar app.jar

# Expose the port your app runs on (default for Spring Boot is 8080)
EXPOSE 8089

# Run the JAR file as an executable
ENTRYPOINT ["java", "-jar", "app.jar"]