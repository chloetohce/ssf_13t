FROM eclipse-temurin:23-jdk

LABEL MAINTAINER="chloe"
LABEL description="SSF Day 14 Lecture"
LABEL name="ssf_13t"

ARG APP_DIR=/APP

WORKDIR ${APP_DIR}
# Directory where your source code will reside and the directory where you copy your project to
COPY pom.xml .
COPY mvnw .
COPY mvnw.cmd .
COPY src src
COPY .mvn .mvn

# Package application using RUN directive
# Downloads dependencies defined in pom.xml
# Compile and package to jar
RUN chmod a+x ./mvnw && ./mvnw package -Dmaven.test.skip=true

ENV SERVER_PORT=3000

EXPOSE ${SERVER_PORT}

ENTRYPOINT SERVER_PORT=${SERVER_PORT} java -jar target/ssf_13t-0.0.1-SNAPSHOT.jar