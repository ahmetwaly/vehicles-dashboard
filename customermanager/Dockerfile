FROM openjdk:8-jdk-alpine
EXPOSE 8080
WORKDIR /app
COPY target/customersmanager.jar app.jar
ENTRYPOINT ["/bin/bash","mvn test && java -Djava.security.egd=file:/dev/./urandom -jar app.jar"]