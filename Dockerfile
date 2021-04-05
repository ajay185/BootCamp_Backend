FROM maven:3.5.2-jdk-8-alpine AS MAVEN_BUILD

COPY pom.xml /build/
COPY src /build/src/

WORKDIR /build/
RUN mvn package

FROM openjdk:8-jre-alpine

WORKDIR /app

COPY --from=MAVEN_BUILD /build/target/backend-0.0.1-SNAPSHOT.jar /app/backend-test1.jar

ENTRYPOINT ["java", "-jar", "docker-boot-intro-0.1.0.jar"]
