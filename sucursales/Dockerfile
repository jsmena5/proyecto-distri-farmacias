FROM openjdk:17.0.2

WORKDIR /app

COPY target/sucursales-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8092

ENTRYPOINT ["java", "-jar", "app.jar"]