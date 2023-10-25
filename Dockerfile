FROM openjdk:11
ADD build/libs/pruebatec-0.0.1-SNAPSHOT.jar bundle.jar
EXPOSE 8080
CMD ["java", "-jar", "bundle.jar"]