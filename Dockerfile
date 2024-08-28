# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/userapplication-0.0.1-SNAPSHOT.jar /app/userapplication-0.0.1-SNAPSHOT.jar


# Run the application
ENTRYPOINT ["java", "-jar", "userapplication-0.0.1-SNAPSHOT.jar.jar"]
