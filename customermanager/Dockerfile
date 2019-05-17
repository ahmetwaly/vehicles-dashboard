FROM openjdk:8-jdk-alpine AS test-env
FROM openjdk:8-jre-alpine AS prod-env
EXPOSE 8080
WORKDIR /user/app 
COPY target/customersmanager.jar /app.jar
ENTRYPOINT [ "java","-jar","app.jar" ]
