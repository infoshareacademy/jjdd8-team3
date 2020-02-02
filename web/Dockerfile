FROM jboss/wildfly

ENV SENDGRID_API_KEY="${HF_SENDGRID_API_KEY}"

RUN /opt/jboss/wildfly/bin/add-user.sh -s -u admin -p admin

ADD standalone.conf /opt/jboss/wildfly/bin

USER root
RUN cd /opt
RUN yum -y install wget
RUN wget https://download.java.net/java/GA/jdk13/5b8a42f3905b406298b72d750b6919f6/33/GPL/openjdk-13_linux-x64_bin.tar.gz
RUN tar -xvf openjdk-13_linux-x64_bin.tar.gz
ENV JAVA_TOOL_OPTIONS -Dfile.encoding=UTF8

ADD target/high-five-web.war /opt/jboss/wildfly/standalone/deployments/

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]
