FROM openjdk:17-alpine
ARG JAR_FILE=./target/configServer-*.jar
COPY ${JAR_FILE} app.jar
COPY dominguez_github .ssh/dominguez_github
COPY *.yml .
RUN apk --no-cache add curl
ENTRYPOINT ["java","-jar","app.jar"]
EXPOSE 8083