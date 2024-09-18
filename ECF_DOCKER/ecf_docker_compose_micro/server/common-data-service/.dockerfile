FROM maven:3.6.3-jdk-11 AS build

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline


COPY src ./src

RUN mvn clean package -DskipTests

FROM openjdk:11-jdk-slim

WORKDIR /app

COPY --from=build /app/target/common-data-service.jar common-data-service.jar

EXPOSE 8083

ENTRYPOINT ["java", "-jar", "common-data-service.jar"]

