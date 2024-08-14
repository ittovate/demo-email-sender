FROM openjdk:21-jdk
ARG JAR_FILE=/target/*.jar
RUN ls -al | cat
COPY ./target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]