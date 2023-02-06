FROM amazoncorretto:11-alpine-jdk
MAINTAINER Juan
COPY target/portfolioAP-0.0.1-SNAPSHOT.jar juan-app.jar
ENTRYPOINT ["java","-jar","/juan-app.jar"]
