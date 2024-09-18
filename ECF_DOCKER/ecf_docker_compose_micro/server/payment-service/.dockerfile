FROM maven:3.6.3-jdk-11 AS build

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline


COPY src ./src

RUN mvn clean package -DskipTests

FROM openjdk:11-jdk-slim

WORKDIR /app

COPY --from=build /app/target/payment-service.jar payment-service.jar

EXPOSE 8085

ENTRYPOINT ["java", "-jar", "payment-service.jar"]

