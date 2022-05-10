FROM java:openjdk-8-jdk-alpine
MAINTAINER Deebendu Kumar
RUN apk update && apk add openssh
ENV TZ=Asia/Kolkata
ENV JAVA_OPTS " -Xms512m -Xmx512m"

#The ARG instruction defines a variable that users can pass at build-time to the builder with the docker build command using the --build-arg <varname>=<value> flag.
#If a user specifies a build argument that was not defined in the Dockerfile, the build outputs a warning.
ARG profile

#The RUN instruction will execute any commands in a new layer on top of the current image and commit the results. The resulting committed image will be used for the next step in the Dockerfile.
#RUN ln -snf /usr/share/zoneinfo/$TIMEZONE /etc/localtime && echo $TIMEZONE > /etc/timezone && dpkg-reconfigure -f noninteractive tzdata
#RUN apk add --no-cache bash curl jq docker
RUN mkdir -p /opt/service
RUN mkdir -p /opt/service/config
RUN mkdir -p /opt/service/dist

COPY target /opt/service/dist
COPY src/main/resources/application.properties /opt/service/config
COPY src/main/resources/bootstrap.properties /opt/service/config
COPY src/main/resources/banner.txt /opt/service/config
COPY src/main/resources/log4j.properties /opt/service/config

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "-Djava.library.path=/opt/service/dist", "-Dspring.config.location=/opt/service/config/application.properties", "-Dlog4j.configuration=file:////opt/service/config/log4j.properties", "/opt/service/dist/service-1.0.jar"]
