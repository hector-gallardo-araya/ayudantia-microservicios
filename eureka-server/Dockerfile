FROM openjdk:17
ARG JAR_FILE=./target/*.jar
COPY ${JAR_FILE} eureka-server.jar
ENTRYPOINT ["java","-jar","/eureka-server.jar"]