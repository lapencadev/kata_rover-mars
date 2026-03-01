FROM maven:3.9.12-eclipse-temurin-25-alpine AS build
WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package

FROM eclipse-temurin:25-jre-alpine
WORKDIR /app

COPY --from=build /app/target/kata_rover-mars-1.0-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
