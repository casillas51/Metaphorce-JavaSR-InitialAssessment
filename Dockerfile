FROM openjdk:11
ADD target/db-acasillas.jar db-acasillas.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "db-acasillas.jar"]