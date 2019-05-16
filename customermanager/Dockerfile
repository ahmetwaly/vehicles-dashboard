FROM openjdk:8-jdk-alpine AS test-env
EXPOSE 8080
WORKDIR /app
COPY target/customersmanager.jar app.jar
ENTRYPOINT ["/bin/sh","java -Djava.security.egd=file:/dev/./urandom -jar app.jar"]