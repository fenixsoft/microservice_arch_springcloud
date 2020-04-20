FROM openjdk:12-alpine

MAINTAINER icyfenix

ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    JAVA_OPTS="" \
    PORT=8761 \
    PROFILES="default"

ADD /target/*.jar /registry.jar

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /registry.jar --spring.profiles.active=$PROFILES"]

EXPOSE $PORT
