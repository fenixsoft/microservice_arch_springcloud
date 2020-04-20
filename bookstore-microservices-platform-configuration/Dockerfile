FROM openjdk:12-alpine

MAINTAINER icyfenix

RUN apk update && apk add curl && rm -rf /var/cache/apk/*

ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    JAVA_OPTS="" \
    PORT=8888 \
    PROFILES="native"

ADD /target/*.jar /config.jar

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /config.jar --spring.profiles.active=$PROFILES"]

HEALTHCHECK --interval=5s --timeout=30s CMD curl -f http://localhost:$PORT/actuator/health || exit 1

EXPOSE $PORT
