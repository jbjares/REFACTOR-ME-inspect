FROM gradle:4.10.2-jdk8 AS build
LABEL maintainer="luk.zim91@gmail.com"

COPY --chown=gradle:gradle . /opt/srv
WORKDIR /opt/srv
RUN gradle clean bootJar --no-daemon

#############################################
FROM openjdk:8-jre-alpine3.8
COPY --from=build /opt/srv/build/libs/inspect-0.0.1.jar /opt/srv/inspect.jar

ENTRYPOINT [ "java", "-jar", "/opt/srv/inspect.jar"]
EXPOSE 9393

