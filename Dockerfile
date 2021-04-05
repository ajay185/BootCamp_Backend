FROM maven:3.6.0-jdk-11-slim AS build
COPY src /app/src
#COPY pom.xml /app/
#WORKDIR /app
RUN mvn -f pom.xml clean package

FROM openjdk:8-jdk-alpine
MAINTAINER ajay
#WORKDIR /app
COPY ./backend-0.0.1-SNAPSHOT.jar backend-java-v1.0.0.jar
#COPY ./target/backend-0.0.1-SNAPSHOT.jar backend-java-v1.0.0.jar
ENTRYPOINT ["java","-jar","/backend-java-v1.0.0.jar"]
EXPOSE 8080
