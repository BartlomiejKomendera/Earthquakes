FROM adoptopenjdk/openjdk15:ubi
ADD target/earthquakes-0.0.1-SNAPSHOT.jar /
EXPOSE 8080
ENTRYPOINT ["java","-jar","earthquakes-0.0.1-SNAPSHOT.jar"]