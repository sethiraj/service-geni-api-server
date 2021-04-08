# service-geni-api-server
API server for Service Geni Services

## Pre-requiste For Building the Code ##
- JDK 1.8+
- Maven 3.1+

## Build Service ##
To Build the Code, install the pre-requiste and run the following commands

### As a Spring Boot Service ###
    mvn clean spring-boot:run

### As an artifact ###
    mvn clean install

Post running the previous command run the following to execute the code as an artifact 

    java -jar service-genie-api-0.0.1-SNAPSHOT.war

# Technology Details #
- Spring Boot Rest Controller
- H2 Database 
(The Data would be cleaned up every time we re-boot the system - This is used as an temporary database would be migrated to MYSQL post validation)
- JPA (Hibernate for Database Connections)

# Swagger File #
If Loaded on localhost, Swagger could be loaded on the following URL
> http://localhost:8080/swagger-ui.html

## API Authentication ##
> Authentication Type : Basic

## Bulk API ##
> Ensure you refer BulkData.csv, the columns could be interchanged as the mapping had been done, please ensure that the first line is for heading.
> Ensure you refer PostBulkReviews.csv, the columns could be interchanged as the mapping had been done, please ensure that the first line is for heading.

## Image To Base64 String ##
Please find some URL's which could be used to convert Image files

> https://www.base64-image.de/
> https://base64.guru/converter/encode/image