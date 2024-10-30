# Use a base image with OpenJDK 17 based on Debian
FROM openjdk:17-jdk-slim

# Define build arguments for Nexus credentials and JAR URL
ARG NEXUS_USERNAME
ARG NEXUS_PASSWORD
ARG JAR_URL

# Set working directory
WORKDIR /app

# Install curl to download the JAR from Nexus
RUN apt-get update && apt-get install -y curl && rm -rf /var/lib/apt/lists/*

# Download the JAR from Nexus
RUN curl -u "$NEXUS_USERNAME:$NEXUS_PASSWORD" -o app.jar "$JAR_URL"

# Expose the application port
EXPOSE 8089

# Run the application
CMD ["java", "-jar", "app.jar"]
