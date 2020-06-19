FROM maven:3.6.2-jdk-12 AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package

FROM openjdk:12.0-jdk AS running
MAINTAINER artemir14@gmail.com
COPY --from=build /usr/src/app/target/news-manager-api-*.jar /usr/app/news-manager-runnable.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar", "-Dspring.profiles.active=docker", "/usr/app/news-manager-runnable.jar"]
#"-Dspring.profiles.active=container",