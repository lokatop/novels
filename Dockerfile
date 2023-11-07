FROM openjdk:17
WORKDIR /app
COPY target/novel_games-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
ENTRYPOINT ["java","-jar","novel_games-0.0.1-SNAPSHOT.jar"]
