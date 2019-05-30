<h1 align="center"> Customer Vehicle Dashboard </h1> <br>

<p align="center">
  dashboard for displaying the  current customers and their vechile connection status . 
</p>


## Table of Contents

- [Introduction](#introduction)
- [Business Requirement](alten-challenge.txt)
- [Solution Architecture](#solution-architecture)
- [Solution microservices](#solution-microservices)
- [API Documentation](#API)
- [CI/CD](#CICD)
- [Deployment](#deployment)
- [Integration Test](#test)


## Introduction

  * The application adopts the [microservices Archtiture patterens](https://microservices.io/patterns/microservices.html).
  * The workload are containerized and pushed to Azure conainter registery .
  * The workload are deployed on Azure Kuberntese cluster by [Helm](https://helm.sh/) .
  * The whole process is being managed CI/CD pipline using [azure pipline](https://azure.microsoft.com/en-us/services/devops/pipelines/) with proper quaity gates and unit testing implemented .

## Solution-Architecture
* the business usecase is best to be implemetned by microservice architure.
* There is two subdomains identified as per the usecase (Customers and Vehicles) and it requires a service aggregator that retirve information from both domains and provide it to frontend/customer-facing application(monitoring dashboard).
* Other technical components was provided to adopt the microservice archtiture pattern and provide a cloud native capabilities to the solution .

![alt text](https://raw.githubusercontent.com/ahmetwaly/vehicles-dashboard/master/solution-architecture.png)
## Solution-microservices
### customer manager [![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=se.alten%3Acustomermangaer&metric=alert_status)](https://sonarcloud.io/dashboard?id=se.alten%3Acustomermangaer) [![Build Status](https://dev.azure.com/altenchallenge/vehicles-dashboard/_apis/build/status/customer%20manager?branchName=master)](https://dev.azure.com/altenchallenge/vehicles-dashboard/_build/latest?definitionId=2&branchName=master)

hold the business logic of the customer domain and expose API to retireve the customers .
* chassis framework : Spring boot , Spring data 
* DB :HSQLDB

### vehicle manager [![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=se.alten%3Avehiclemanager&metric=alert_status)](https://sonarcloud.io/dashboard?id=se.alten%3Avehiclemanager) [![Build Status](https://dev.azure.com/altenchallenge/vehicles-dashboard/_apis/build/status/vehicle%20manager?branchName=master)](https://dev.azure.com/altenchallenge/vehicles-dashboard/_build/latest?definitionId=4&branchName=master)
hold the business logic of the vehicle domain and expose API to retireve the vehicles and update the vehicle status .
* chassis framework : Spring boot , Spring data 
* DB :HSQLDB

### customer vehicele manager [![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=se.alten%3Acustomervehiclesmanager&metric=alert_status)](https://sonarcloud.io/dashboard?id=se.alten%3Acustomervehiclesmanager) [![Build Status](https://dev.azure.com/altenchallenge/vehicles-dashboard/_apis/build/status/customer%20vehicles%20manager?branchName=master)](https://dev.azure.com/altenchallenge/vehicles-dashboard/_build/latest?definitionId=5&branchName=master)
[aggregator service](https://microservices.io/patterns/apigateway.html) that works as a gateway for collecting the data from different service and aggregate it based on certain business logic
* chassis framework : Spring boot 

### monitor dashboard [![Build Status](https://dev.azure.com/altenchallenge/vehicles-dashboard/_apis/build/status/monitoring%20dashboard?branchName=master)](https://dev.azure.com/altenchallenge/vehicles-dashboard/_build/latest?definitionId=8&branchName=master) 
 micorservice for  displaying the customer and viechle data and status . 
 * chassis framework : Angular 
 
### apigateway [![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=se.alten%3Aapigateway&metric=alert_status)](https://sonarcloud.io/dashboard?id=se.alten%3Aapigateway) [![Build Status](https://dev.azure.com/altenchallenge/vehicles-dashboard/_apis/build/status/apigateway?branchName=master)](https://dev.azure.com/altenchallenge/vehicles-dashboard/_build/latest?definitionId=1&branchName=master)
Netilix zuul API Gateway for API verisioning , service metrics , security 
### ingnix ingress 
Ngnix ingress component for K8 used as a reverse proxy for the cluster , SSL termination , etc

### microservice package structure 
* each microservice package contains (DockerFile to deploy the application , CLI piline file ,Helm charts folder and configuration file .
![alt text](https://raw.githubusercontent.com/ahmetwaly/vehicles-dashboard/master/package-structure.png)

## API
Solution components APIs is documented using swagger .

 - URL
    - http://localhost:8082/swagger-ui.html
    - http://localhost:8083/swagger-ui.html
    - http://localhost:8084/swagger-ui.html
    ![alt text](https://raw.githubusercontent.com/ahmetwaly/vehicles-dashboard/master/swagger.png)

    

## CI/CD
Azure pipline was used as a pipline orchestrator for CI/CD 

### CI 
* All the microservice are continiously intgerated and unit test once the code is pushed to the repo .
* Each microservice has a seprate CI pipline 
* each CI pipline contains the below steps and artifacts 
![alt text](https://raw.githubusercontent.com/ahmetwaly/vehicles-dashboard/master/CI-Diagram.png)

### CD  
* Contiouse deployment release pipline is configured to run on specific schedule with latest artifcats pushed to the container registry .
* The release contains all solution microservice to be deployed to staging environment in specific sequence based on dependencies . 
* Integration test runs after all service depployed and if successed then manual approval is required to deploy to upper environment.
![alt text](https://raw.githubusercontent.com/ahmetwaly/vehicles-dashboard/master/realse-pipline.png)

## Deployment

### cloud URL : http://monitordashboard.eastus.cloudapp.azure.com/monitoringdashboard

### local deployment on local 
 * prerequistes 
    * [Java 8 SDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
    * [Maven](https://maven.apache.org/download.cgi)
    * Angular CLI.
  * step to run 
    * please run run.sh from root folder .
    * URL:http://localhost:8085
 
### docker deployment on local 
 * prerequistes 
   * [docker](https://www.docker.com/get-docker)
  * step to run 
    * please run run-dockercompose.sh from root folder .
    * URL:http://localhost:8085

### Cloud Deployment 
    The solution is build to be deployed on Kubernetese platform to avoid one vendor locking .  
* [step to deploy AKS on Azure](deployment.md) : please follow those attached steps to deploy AKS cluster on azure .


## Test
During the release pipilien and after API gateway deployed quality gate runs to ensure that the service are up and running by hitting the actual deployed service URL 
![alt text](https://raw.githubusercontent.com/ahmetwaly/vehicles-dashboard/master/qualitygate.png)
