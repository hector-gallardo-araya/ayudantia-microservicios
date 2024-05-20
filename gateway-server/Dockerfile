FROM openjdk:17
ARG JAR_FILE=./target/*.jar
COPY ${JAR_FILE} gateway-server.jar
ENTRYPOINT ["java","-jar","/gateway-server.jar"]