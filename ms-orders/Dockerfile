FROM openjdk:17
ARG JAR_FILE=./target/*.jar
COPY ${JAR_FILE} ms-orders.jar
ENTRYPOINT ["java","-jar","/ms-orders.jar"]