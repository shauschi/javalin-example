FROM openjdk:8-jdk-alpine
MAINTAINER Stefan Hauschildt <stefan.h@uschildt.de>

COPY build/libs/app.jar .
EXPOSE 7000
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]