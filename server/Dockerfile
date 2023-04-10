FROM openjdk:17-alpine
ARG JAR_FILE=./target/eureka-server-*.jar
COPY ${JAR_FILE} app.jar
RUN apk --no-cache add curl
ENTRYPOINT ["java","-jar","app.jar"]
EXPOSE 8888