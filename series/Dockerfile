FROM openjdk:17-jdk-slim
ARG JAR_FILE=./target/series-*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]
EXPOSE 8086