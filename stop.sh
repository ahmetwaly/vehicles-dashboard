#!/bin/bash
kill -9 $(cat ./apigateway/process.pid) 
kill -9 $(cat ./customermanager/process.pid) 
kill -9 $(cat ./vehiclemanager/process.pid) 
kill -9 $(cat ./customervehiclesmanager/process.pid) 
kill -9 $(cat ./vehiclesimulator/process.pid) 