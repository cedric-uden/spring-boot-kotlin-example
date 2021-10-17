FROM openjdk:13-alpine
VOLUME /tmp

RUN mkdir /spring-boot-kotlin-example
WORKDIR /spring-boot-kotlin-example

ENV JAVA_OPTS=""
COPY ./build/libs/spring-boot-kotlin-example-0.0.1.jar /spring-boot-kotlin-example
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /spring-boot-kotlin-example/spring-boot-kotlin-example-0.0.1.jar" ]