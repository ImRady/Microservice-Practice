FROM eclipse-temurin:21-jdk-jammy AS build
LABEL maintainer="bank"

COPY target/account-0.0.1-SNAPSHOT.jar account-0.0.1-SNAPSHOT.jar
ENV SPRING_CONFIG_IMPORT=configserver:http://configserver:8071

ENTRYPOINT ["java", "-jar", "/account-0.0.1-SNAPSHOT.jar"]