FROM openjdk:8-alpine AS test-env
FROM openjdk:8-jre-alpine AS prod-env
# Required for starting application up.
RUN apk update && apk add bash
RUN mkdir -p /opt/app
ENV PROJECT_HOME /opt/app
COPY target/customermanager.jar $PROJECT_HOME/customermanager.jar
WORKDIR $PROJECT_HOME
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","./customermanager.jar"]
