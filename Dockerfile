FROM openjdk:17-alpine

EXPOSE 7070

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} cookbook-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","cookbook-0.0.1-SNAPSHOT.jar"]
