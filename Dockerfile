FROM eclipse-temurin:20-jdk-jammy
WORKDIR /app
LABEL authors="tarielakmatov"
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:resolve
COPY src ./src
CMD ["./mvnw", "spring-boot:run"]