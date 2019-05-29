#!/bin/bash
cd ./apigateway
mvn clean package -P development -DskipTests
java -jar ./target/apigateway.jar &

cd ../customermanager
mvn clean package -P development -DskipTests
java -jar ./target/customermanager.jar &

cd ../vehiclemanager
mvn clean package -P development -DskipTests
java -jar ./target/vehiclemanager.jar &

cd ../customervehiclesmanager -DskipTests
mvn clean package -P development
java -jar ./target/customervehiclesmanager.jar &

cd ../vehiclesimulator
mvn clean package -P development -DskipTests
java -jar ./target/vehiclesimulator.jar &

cd ../monitoringdashboard
npm install bootstrap
ng build
ng serve --port 8085 &
