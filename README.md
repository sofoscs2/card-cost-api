# Restful-api

>Back-end application is created by using:
- Maven framework (https://maven.apache.org/)
- Spring Boot (https://projects.spring.io/spring-boot/)
- IntelliJ IDEA (https://www.jetbrains.com/idea/)

## Build Setup

``` bash
# install dependencies
mvn clean install 

# run server will load at localhost:8080
mvn spring-boot:run

# working build
mvn package
```

In order to build and run project requires
- Install Java SE 17 
- Install Maven (https://maven.apache.org/download.cgi)

Why Maven: (https://maven.apache.org/what-is-maven.html)
- Making the build process easy
- Providing a uniform build system
- Providing quality project information
- Providing guidelines for best practices development
- Allowing transparent migration to new features

Why Spring Boot: (https://spring.io/why-spring)
- Predefined Templates
- Loose Coupling
- Easy to test
- Lightweight
- Fast Development
- Powerful Abstraction
- Declarative support

## Docker Setup

``` bash
# Build the Docker Image
docker build -t cardcostapi:latest .

# Run images
docker images

# Run Docker Image in a Container
docker run -d -p 8080:8080 cardcostapi
```
## JMeter Setup

- File : CardCostServices.jmx
- Number of threads (Users) : 100
- Ramp up period (seconds) : 60
- Loop count : 100
- Repeat process : 700