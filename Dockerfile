FROM maven:3.6.0-jdk-11-slim AS build
COPY src /app/src
COPY pom.xml /app/
WORKDIR /app
RUN mvn -f pom.xml clean package

FROM openjdk:8-jdk-alpine
MAINTAINER ajay
WORKDIR /app
RUN pwd
COPY target/backend-0.0.1-SNAPSHOT.jar backend-java-v1.0.0.jar
RUN pwd
ENTRYPOINT ["java","-jar","/app/backend-java-v1.0.0.jar"]
EXPOSE 8080