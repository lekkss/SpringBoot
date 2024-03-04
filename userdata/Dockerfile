FROM openjdk:18
WORKDIR /app
COPY ./target/userdata-0.0.1-SNAPSHOT.jar /app
EXPOSE 8080
CMD [ "java", "-jar", "userdata-0.0.1-SNAPSHOT.jar" ]
# docker build -t [name:tag] .
# docker build -t lekkss/userdata .
# docker run -d -p [host_port]:[container_port] --name [container_name] [image_id/image_tag]
# docker run -d -p 8080:8080 --name userdata lekkss/userdata:latest