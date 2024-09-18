FROM maven:3.6.3-jdk-11 AS build

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline


COPY src ./src

RUN mvn clean package -DskipTests

FROM openjdk:11-jdk-slim

WORKDIR /app

COPY --from=build /app/target/authentication-service.jar authentication-service.jar

EXPOSE 8084

ENTRYPOINT ["java", "-jar", "authentication-service.jar"]

