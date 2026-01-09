FROM eclipse-temurin:21-jdk-jammy AS build
LABEL maintainer="bank"

COPY target/account-0.0.1-SNAPSHOT.jar /app/account-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/app/account-0.0.1-SNAPSHOT.jar"]