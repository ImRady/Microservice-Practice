FROM eclipse-temurin:21-jdk-jammy AS build
LABEL maintainer="bank"

COPY target/card-0.0.1-SNAPSHOT.jar card-0.0.1-SNAPSHOT.jar
ENV SPRING_CONFIG_IMPORT=configserver:http://configserver:8071

ENTRYPOINT ["java", "-jar", "/card-0.0.1-SNAPSHOT.jar"]