FROM amazoncorretto:21-alpine-jdk
WORKDIR /app
ADD ./target/msvc-users-0.0.1-SNAPSHOT.jar msvc-user.jar
ENTRYPOINT ["java", "-jar", "msvc-user.jar"]