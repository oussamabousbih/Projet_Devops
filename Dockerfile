# Use a base image with Java
FROM openjdk:17-jdk-alpine3.18

# Define build arguments for Nexus credentials and JAR URL
ARG NEXUS_USERNAME
ARG NEXUS_PASSWORD
ARG JAR_URL

# Set working directory
WORKDIR /app

# Update repository and install curl to download the JAR from Nexus
RUN echo "https://dl-cdn.alpinelinux.org/alpine/v3.18/main" > /etc/apk/repositories && \
    echo "https://dl-cdn.alpinelinux.org/alpine/v3.18/community" >> /etc/apk/repositories && \
    apk --no-cache add curl

# Download the JAR from Nexus
RUN curl -u "$NEXUS_USERNAME:$NEXUS_PASSWORD" -o app.jar "$JAR_URL"

# Expose the application port
EXPOSE 8089

# Run the application
CMD ["java", "-jar", "app.jar"]
