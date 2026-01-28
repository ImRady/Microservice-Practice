FROM eclipse-temurin:21-jdk-jammy AS build
LABEL maintainer="bank"

COPY target/eurekaserver-0.0.1-SNAPSHOT.jar eurekaserver-0.0.1-SNAPSHOT.jar
ENV SPRING_CONFIG_IMPORT=configserver:http://configserver:8071

ENTRYPOINT ["java", "-jar", "/eurekaserver-0.0.1-SNAPSHOT.jar"]