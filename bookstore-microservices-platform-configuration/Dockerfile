FROM openjdk:12-alpine

MAINTAINER icyfenix

ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    JAVA_OPTS="" \
    PORT=8888 \
    PROFILES="native"

ADD /target/*.jar /config.jar

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /config.jar --spring.profiles.active=$PROFILES"]

EXPOSE $PORT
