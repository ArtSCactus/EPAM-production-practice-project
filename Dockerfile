FROM openjdk:12.0-jdk
MAINTAINER artemir14@gmail.com
EXPOSE 8080
ARG JAR_FILE=target/news-manager-api-*.jar
ADD ${JAR_FILE} news-manager-runnable.jar
ENTRYPOINT ["java","-jar","/news-manager-runnable.jar", "--spring.profiles.active=docker"]