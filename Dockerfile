FROM openjdk:17-jdk-slim
WORKDIR /usr/app
ADD target/*.jar deadlocksimulator.jar
ENV JAVA_OPTS=""
EXPOSE 8013
ENTRYPOINT exec java ${JAVA_OPTS} -jar deadlocksimulator.jar
