# Use a Java runtime as the base
FROM eclipse-temurin:21-jre-alpine

# Set the directory inside the container
WORKDIR /app

# Copy the distribution you built locally into the container
# This copies the libs and the startup scripts
COPY app/build/install/app .

# Ensure the startup script is executable
RUN chmod +x ./bin/app

# Run the app using the script Gradle created
CMD ["./bin/app"]
