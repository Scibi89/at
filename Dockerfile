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
RUN apt-get install -y openjdk-11-jdk
RUN java -version
RUN apt-get install -y maven

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

