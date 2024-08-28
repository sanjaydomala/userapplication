# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Install Git
RUN apt-get update && apt-get install -y git

# Set the working directory inside the container
WORKDIR /app

# Clone the Git repository
RUN git clone https://github.com/sanjaydomala/userapplication.git .

# Copy the JAR file into the container
COPY target/userapplication-0.0.1-SNAPSHOT.jar /app/userapplication-0.0.1-SNAPSHOT.jar


# Run the application
ENTRYPOINT ["java", "-jar", "userapplication-0.0.1-SNAPSHOT.jar.jar"]
