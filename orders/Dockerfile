FROM openjdk:8
EXPOSE 8080
ADD target/order-docker.jar order-docker.jar
ENTRYPOINT [ "java", "-jar", "/order-docker.jar" ]