FROM amazoncorretto:17

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/tp-foyer*.jar /app/foyer-devops.jar

# Expose the port that the application will run on
EXPOSE 8079

# Set default environment variables (can be overridden at runtime)
ENV SERVER_PORT=8079 \
    DB_HOST=mysql \
    DB_PORT=3306 \
    DB_NAME=foyer-devops-db \
    DB_USERNAME=root \
    DB_PASSWORD= \
    LOG_PATH=/logs/foyer-devops.log

# Create the log directory if it does not exist
RUN mkdir -p /logs

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "foyer-devops.jar"]