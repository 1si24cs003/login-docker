FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY LoginApp.java .
RUN javac LoginApp.java
CMD ["java", "LoginApp"]
