FROM openjdk:17-jdk-alpine
ARG NEXUS_USERNAME
ARG NEXUS_PASSWORD
ARG JAR_URL
WORKDIR /app
RUN apk add --no-cache curl
RUN curl -u "$NEXUS_USERNAME:$NEXUS_PASSWORD" -o tp-foyer.jar "$JAR_URL"
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "tp-foyer.jar"]
