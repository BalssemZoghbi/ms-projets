FROM eclipse-temurin:17-jdk-alpine
WORKDIR /Config-Server
EXPOSE 8888
ADD target/*.jar Config-Server-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "Config-Server-0.0.1-SNAPSHOT.jar"]