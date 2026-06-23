FROM eclipse-temurin:17-jdk-alpine

# Definimos el directorio de trabajo dentro del contenedor
WORKDIR /app


COPY target/Malla-0.0.1-SNAPSHOT.jar app.jar


EXPOSE 8002


ENTRYPOINT ["java", "-jar", "app.jar"]