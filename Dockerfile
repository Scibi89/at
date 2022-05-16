FROM ubuntu:20.04
MAINTAINER Scibi

#==============
# Applications
#==============
RUN apt-get update -y --fix-missing \
 && apt-get install -y wget unzip xvfb curl \
 && apt-get install -y gnupg gnupg1 gnupg2

#======================
# Set Warsaw Time Zone
#======================
RUN ln -s /usr/share/zoneinfo/Europe/Warsaw /etc/localtime
RUN ls -l /etc/localtime

#======================
# Install JAVA and MVN
#======================
RUN cd /opt
RUN apt-get -y install software-properties-common
RUN apt-get -y update
RUN apt-get install -y openjdk-17-jdk
RUN java -version
#RUN apt-get install -y maven
ARG MAVEN_VERSION=3.8.5
ARG USER_HOME_DIR="/root"
ARG SHA=89ab8ece99292476447ef6a6800d9842bbb60787b9b8a45c103aa61d2f205a971d8c3ddfb8b03e514455b4173602bd015e82958c0b3ddc1728a57126f773c743
ARG BASE_URL=https://apache.osuosl.org/maven/maven-3/${MAVEN_VERSION}/binaries

RUN mkdir -p /usr/share/maven /usr/share/maven/ref \
  && curl -fsSL -o /tmp/apache-maven.tar.gz ${BASE_URL}/apache-maven-${MAVEN_VERSION}-bin.tar.gz \
  && echo "${SHA}  /tmp/apache-maven.tar.gz" | sha512sum -c - \
  && tar -xzf /tmp/apache-maven.tar.gz -C /usr/share/maven --strip-components=1 \
  && rm -f /tmp/apache-maven.tar.gz \
  && ln -s /usr/share/maven/bin/mvn /usr/bin/mvn

ENV MAVEN_HOME /usr/share/maven
ENV MAVEN_CONFIG "$USER_HOME_DIR/.m2"

#COPY mvn-entrypoint.sh /usr/local/bin/mvn-entrypoint.sh
#COPY settings-docker.xml /usr/share/maven/ref/

#===============
# Google Chrome
#===============
#RUN wget https://dl.google.com/linux/direct/google-chrome-beta_current_amd64.deb
#RUN apt install -y ./google-chrome-beta_current_amd64.deb
RUN wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
RUN apt install -y ./google-chrome-stable_current_amd64.deb

#=========
# Firefox
#=========
RUN apt-get update \
&& apt-get install -y software-properties-common \
&& add-apt-repository ppa:mozillateam/firefox-next \
&& apt update \
&& apt upgrade -y
RUN apt install -y firefox \
&& firefox --version

#=========
# Allure
#=========
RUN curl -o allure-2.13.8.tgz -Ls https://github.com/allure-framework/allure2/releases/download/2.13.8/allure-2.13.8.tgz \
&& tar -zxvf allure-2.13.8.tgz -C /opt/ \
&& ln -s /opt/allure-2.13.8/bin/allure /usr/bin/allure \
&& allure --version

#======================
# Run.sh script
#======================
ADD pom.xml AT/pom.xml

WORKDIR AT
RUN mvn dependency:go-offline

WORKDIR /
RUN rm -rf AT

#======================
# Run.sh script
#======================
ADD run.sh /usr/local/bin/run.sh
RUN sed -i 's/\r$//' /usr/local/bin/run.sh
RUN chmod +x /usr/local/bin/run.sh

WORKDIR /at

CMD ["run.sh"]

