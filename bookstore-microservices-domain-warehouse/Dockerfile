FROM openjdk:12-alpine

MAINTAINER icyfenix

ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    JAVA_OPTS="" \
    PORT=8501 \
    PROFILES="default"

ADD /target/*.jar /bookstore-warehouse.jar

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /bookstore-warehouse.jar --spring.profiles.active=$PROFILES"]

EXPOSE $PORT
