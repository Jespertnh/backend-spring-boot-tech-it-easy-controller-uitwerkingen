FROM maven:3.8.7-openjdk-18-slim AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM openjdk:24-ea-18-slim
RUN addgroup --system --gid 1000 spring && \
    adduser --system --uid 1000 --gid 1000 spring
USER spring
ARG JAR_FILE=target/*.jar
COPY --from=build /app/target/*.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
