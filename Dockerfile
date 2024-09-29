# Use a base image with Java installed
FROM openjdk:17

# Set the working directory
WORKDIR /apis

# Copy the JAR file into the container
COPY target/cardcostapi-0.0.1-SNAPSHOT.jar cardcostapi.jar
# If using Gradle, replace the line above with:
# COPY build/libs/your-app-name.jar app.jar

# Expose the port your app runs on
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "cardcostapi.jar"]