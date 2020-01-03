FROM openjdk:8-jre
MAINTAINER Ruanjiayu <1005572910@qq.com>

ENV APP_VERSION 1.0.0-SNAPSHOT

RUN mkdir /app

COPY itoken-config-$APP_VERSION.jar /app/app.jar

ENTRYPOINT ["java", "-jar", "/app/app.jar", "--spring.profiles.active=prod"]

EXPOSE 8888