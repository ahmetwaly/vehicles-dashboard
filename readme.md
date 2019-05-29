<h1 align="center"> Customer Vehicle Dashboard </h1> <br>

<p align="center">
  dashboard for displaying the  current customers and their vechile connection status . 
</p>


## Table of Contents

- [Introduction](#introduction)
- [Business Requirement](alten-challenge.txt)
- [Solution Architecture](#ApplicationArchitecture)
- [Quick Start](#quick-start)
- [Testing](#testing)
- [API](#requirements)
- [Acknowledgements](#acknowledgements)




## Introduction

  * The application adopts the [microservices Archtiture patterens](https://microservices.io/patterns/microservices.html).
  * The workload are containerized and pushed to Azure conainter registery .
  * The workload are deployed on Azure Kuberntese cluster by [Helm](https://helm.sh/) .
  * The whole process is being managed CI/CD pipline using [azure pipline](https://azure.microsoft.com/en-us/services/devops/pipelines/) with proper quaity gates and unit testing implemented .

## Application Architecture
the business usecase is the best to be implemetned by microservice architure.There is two subdomains identified as per the usecase (Customers and Vehicles) and they require a service aggregator that retirve information from both domains and provide it to frontend/customer facing application (monitoring dashboard) .Other technical components was provided to adopt the microservice archtiture pattern and provide a cloud native capabilities to the solution .

![alt text](https://raw.githubusercontent.com/ahmetwaly/vehicles-dashboard/master/solution-architecture.png)
## Architecture components
### customer manager
hold the business logic of the customer domain and expose API to retireve the customers .

### vehicle manager 
### customer vehicele manager 
### monitor dashboard

### ingnix ingress 
### apigateway



### EGO
A running instance of [EGO](https://github.com/overture-stack/ego/) is required to generate the Authorization tokens and to provide the verification key.

[EGO](https://github.com/overture-stack/ego/) can be cloned and run locally if no public server is available. 


### Local
* [Java 8 SDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [Maven](https://maven.apache.org/download.cgi)


### Docker
* [Docker](https://www.docker.com/get-docker)


## Quick Start
Make sure the JWT Verification Key URL is configured, then you can run the server in a docker container or on your local machine.

### Configure JWT Verification Key
Update __application.yml__. Set `auth.jwt.publicKeyUrl` to the URL to fetch the JWT verification key. The application will not start if it can't set the verification key for the JWTConverter.

The default value in the __application.yml__ file is set to connect to EGO running locally on its default port `8081`.

### Run Local
```bash
$ mvn spring-boot:run
```

Application will run by default on port `1234`

Configure the port by changing `server.port` in __application.yml__


### Run Docker

First build the image:
```bash
$ docker-compose build
```

When ready, run it:
```bash
$ docker-compose up
```

Application will run by default on port `1234`

Configure the port by changing `services.api.ports` in __docker-compose.yml__. Port 1234 was used by default so the value is easy to identify and change in the configuration file.


## Testing
TODO: Additional instructions for testing the application.


## API
TODO: API Reference with examples, or a link to a wiki or other documentation source.

## Acknowledgements
TODO: Show folks some love.
