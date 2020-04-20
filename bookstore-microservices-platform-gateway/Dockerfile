FROM openjdk:12-alpine

MAINTAINER icyfenix

ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    JAVA_OPTS="" \
    PORT=8080 \
    PROFILES="default"

ADD /target/*.jar /gateway.jar

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /gateway.jar --spring.profiles.active=$PROFILES"]

EXPOSE $PORT
