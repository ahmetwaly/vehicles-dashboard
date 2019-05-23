#!/bin/bash
cd ./apigateway
mvn clean package -P development
java -jar ./target/apigateway.jar &

cd ../customermanager
mvn clean package -P development
java -jar ./target/customermanager.jar &

cd ../vehiclemanager
mvn clean package -P development
java -jar ./target/vehiclemanager.jar &

cd ../customervehiclesmanager
mvn clean package -P development
java -jar ./target/customervehiclesmanager.jar &

cd ../vehiclesimulator
mvn clean package -P development
java -jar ./target/vehiclesimulator.jar &
