FROM openjdk:8-jdk-alpine
EXPOSE 8081
ARG JAR_FILE=common-api-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]