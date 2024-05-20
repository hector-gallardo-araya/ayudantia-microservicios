FROM openjdk:17
ARG JAR_FILE=./target/*.jar
COPY ${JAR_FILE} ms-products.jar
ENTRYPOINT ["java","-jar","/ms-products.jar"]