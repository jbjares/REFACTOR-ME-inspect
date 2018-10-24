FROM gradle:4.10.2-jdk8 AS build
LABEL maintainer="luk.zim91@gmail.com"

COPY --chown=gradle:gradle . /opt/srv
WORKDIR /opt/srv
RUN gradle clean --no-daemon
ENTRYPOINT [ "gradle", "bootRun", "--no-daemon" ]
EXPOSE 9393

