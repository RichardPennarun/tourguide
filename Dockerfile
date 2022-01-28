FROM openjdk:11
ARG JAR_FILE=build/libs/tourGuide-1.0.0.jar
COPY ${JAR_FILE} tourGuide-1.0.0.jar
ENTRYPOINT ["java", "-jar", "/tourGuide-1.0.0.jar"]
EXPOSE 9005