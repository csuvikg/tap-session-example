FROM maven:3.8.4-amazoncorretto-17 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -Dmaven.test.skip=true

FROM openjdk:17
WORKDIR /app
COPY --from=builder /app/target/app.jar .
EXPOSE 8080
HEALTHCHECK --start-period=40s --timeout=3s CMD curl --fail --silent localhost:8080/actuator/health || exit 1
ENTRYPOINT java -jar /app/app.jar
