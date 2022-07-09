#
# Build stage
#
FROM maven:3.8.5-openjdk-17-slim AS build

# Set the working directory to /app
WORKDIR /app

# copy the pom.xml file to download dependencies
COPY pom.xml ./

COPY ./config ./config
COPY ./core ./core
COPY ./in ./in
COPY ./in-adapter ./in-adapter
COPY ./out ./out
COPY ./out-adapter ./out-adapter
COPY ./service ./service

# Compile the application.
RUN mvn -Dmaven.test.skip=true package -P docker && cp service/target/messagebox-docker.jar app.jar

#
# Package stage
#
FROM eclipse-temurin:17.0.1_10-jre-jammy

# set deployment directory
WORKDIR /app

COPY --from=build /app/app.jar ./app.jar

ENV VAULT_TOKEN "null"

EXPOSE 80

CMD ["java", "-jar", "/app/app.jar"]