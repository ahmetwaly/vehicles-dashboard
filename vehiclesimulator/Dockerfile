#!/bin/bash
FROM openjdk:8-alpine
# Required for starting application up.
RUN apk update && apk add bash
RUN mkdir -p /opt/app
ENV APP_PATH /opt/app/
ARG ARTIFACT_PATH=./target
COPY  ${ARTIFACT_PATH}/vehiclesimulator.jar $APP_PATH/vehiclesimulator.jar
WORKDIR $APP_PATH/
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","vehiclesimulator.jar"]