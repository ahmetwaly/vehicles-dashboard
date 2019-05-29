#!/bin/bash
cd ./apigateway
mvn clean package -P dockercompose -DskipTests

cd ../customermanager
mvn clean package -P development  -DskipTests

cd ../vehiclemanager
mvn clean package -P development  -DskipTests

cd ../customervehiclesmanager
mvn clean package -P dockercompose  -DskipTests

cd ../vehiclesimulator
mvn clean package -P dockercompose  -DskipTests

docker-compose up --build