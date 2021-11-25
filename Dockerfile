FROM openjdk:11-jre-slim
WORKDIR /home
ENV TZ="America/Lima"
COPY /target/apigateway-0.0.1-SNAPSHOT.jar apigateway.jar
EXPOSE 8443
ENTRYPOINT ["java", "-jar", "apigateway.jar"]
