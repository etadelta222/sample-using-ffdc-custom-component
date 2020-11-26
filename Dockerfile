ARG docker_registry=p21d11107559001.azurecr.io/
# FROM ${docker_registry}base/global-bakery/openjdk:11.X.X-alpine311
FROM openjdk:11-jdk

USER root

COPY target/*.jar app.jar

RUN chmod a=r /app.jar

USER finastra

ENTRYPOINT [ "java", "-Djava.security.egd=file:/dev/urandom", "-jar", "/app.jar"]