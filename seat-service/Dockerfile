FROM eclipse-temurin:17

WORKDIR /app

COPY target/*.jar app.jar

EXPOSE 9002

ENTRYPOINT ["java","-jar","app.jar"]