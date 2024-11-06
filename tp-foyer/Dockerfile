FROM openjdk:17-jdk-alpine

# Arguments to pass at build time
ARG NEXUS_USERNAME
ARG NEXUS_PASSWORD
ARG JAR_URL

# Set the working directory
WORKDIR /app

# Install curl to download the JAR
RUN apk add --no-cache curl

# Download the JAR file from Nexus repository
RUN curl -u "$NEXUS_USERNAME:$NEXUS_PASSWORD" -o tp-foyer.jar "$JAR_URL"

# Make sure the JAR file is executable
RUN chmod +x tp-foyer.jar

# Expose the port your Spring Boot app runs on
EXPOSE 8089

# Run the JAR file when the container starts
ENTRYPOINT ["java", "-jar", "tp-foyer.jar"]
