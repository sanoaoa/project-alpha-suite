FROM openjdk:8u191-jre-alpine3.8

RUN apk add curl jq

# WorkSpace
WORKDIR /usr/share/trial

# Add all .jars to target from host into this image

ADD target/selenium-docker.jar 			selenium-docker.jar
ADD target/selenium-docker-tests.jar 	selenium-docker-tests.jar
ADD target/libs							libs

# Add suite files
ADD regression_test.xml  				regression_test.xml
ADD smoke_test.xml						smoke_test.xml

#ADD health check script
ADD healthcheck.sh 						healthcheck.sh

# BROWSER
# HUB_HOST
# MODULE. (smoke_test.xml or regression_test.xml)

ENTRYPOINT sh healthcheck.sh