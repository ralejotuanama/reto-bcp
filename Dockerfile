FROM java:8-jdk-alpine

COPY ./target/bcp-backend-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch bcp-backend-0.0.1-SNAPSHOT.jar'

ENTRYPOINT ["java","-jar","bcp-backend-0.0.1-SNAPSHOT.jar"]


