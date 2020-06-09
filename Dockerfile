FROM maven:3.6.2-jdk-12 AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package

FROM openjdk:12.0-jdk AS packaging
COPY --from=build /usr/src/app/target/news-manager-api-*.jar /usr/app/news-manager-runnable.jar
EXPOSE 8080  
ENTRYPOINT ["java","-jar","/usr/app/news-manager-runnable.jar"]