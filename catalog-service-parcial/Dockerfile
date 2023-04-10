FROM openjdk:17-jdk-slim
ARG JAR_FILE=./target/catalog-service-*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]
EXPOSE 8082