FROM gradle:4.10.2-jdk8 AS build
LABEL maintainer="luk.zim91@gmail.com"

# Necessary because we need to use the Docker daemon
USER root
COPY --chown=root:root . /opt/srv
WORKDIR /opt/srv
RUN gradle clean --no-daemon
ENTRYPOINT [ "gradle", "bootRun", "--no-daemon" ]
EXPOSE 9393

