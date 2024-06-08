FROM mcr.microsoft.com/openjdk/jdk:17-ubuntu AS builder

WORKDIR /workspace

# Copy all files from the current directory to the workspace
COPY . .

# Build the project
RUN mvn clean package

# Stage 2: Create final image
FROM mcr.microsoft.com/java/jre:17-zulu-alpine

WORKDIR /app

# Copy the built JAR file from the previous stage

COPY target/SpringBoot-0.0.1-SNAPSHOT.jar /app/kexie-chat-service-2024.jar

# Expose port 80
EXPOSE 80

# Set the default command to run when the container starts
CMD [ "java", "-jar", "/app/kexie-chat-service-2024.jar"]