FROM springcloud/spring-cloud-skipper-server:2.2.1.RELEASE

RUN rm -rf /opt/openjdk && \
    cd /opt && \
    curl https://download.java.net/openjdk/jdk11/ri/openjdk-11+28_linux-x64_bin.tar.gz | tar xz && \
    mv /opt/jdk-11 /opt/openjdk
