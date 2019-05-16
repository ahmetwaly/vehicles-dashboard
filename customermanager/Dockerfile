FROM openjdk:8-jdk-alpine AS test-env
EXPOSE 8080
COPY target/customersmanager.jar app.jar
ENTRYPOINT ["java -Djava.security.egd=file:/dev/./urandom -jar app.jar"]