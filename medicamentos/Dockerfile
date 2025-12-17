FROM openjdk:17.0.2

WORKDIR /app

COPY target/medicamentos-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 8091

ENTRYPOINT ["java", "-jar", "app.jar"]