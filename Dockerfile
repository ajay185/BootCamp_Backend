FROM maven:3.6.0-jdk-11-slim AS build
#COPY src /app/src
#COPY pom.xml /app/
#WORKDIR /app
#RUN mvn -f pom.xml clean package

#FROM openjdk:8-jdk-alpine
#WORKDIR /app
#COPY ./target/backend-0.0.1-SNAPSHOT.jar backend-java-v1.0.0.jar
#ENTRYPOINT ["java","-jar","/backend-java-v1.0.0.jar"]
#EXPOSE 8080
# For Java 8, try this
# FROM openjdk:8-jdk-alpine

# For Java 11, try this
FROM adoptopenjdk/openjdk11:alpine-jre

# Refer to Maven build -> finalName
ARG JAR_FILE=target/backend-0.0.1-SNAPSHOT.jar

# cd /opt/app
WORKDIR /opt/app

# cp target/spring-boot-web.jar /opt/app/app.jar
COPY ${JAR_FILE} app.jar

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]
EXPOSE 8080
