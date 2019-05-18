FROM openjdk:8-alpine
# Required for starting application up.
RUN apk update && apk add bash
RUN mkdir -p /opt/app
ENV PROJECT_PATH /opt/app
ARG ARTIFACT_PATH=target
COPY ${ARTIFACT_PATH}/customermanager.jar $PROJECT_PATH/customermanager.jar
WORKDIR $PROJECT_HOME
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","./customermanager.jar"]
