# https://github.com/axltxl/docker-jenkins-dood/blob/develop/Dockerfile
FROM jenkins:2.19.2

# Install necessary packages
USER root
RUN apt-get update \
      && apt-get install -y sudo supervisor \
      && rm -rf /var/lib/apt/lists/*

# Install docker-engine
# According to Petazzoni's article:
# ---------------------------------
# "Former versions of this post advised to bind-mount the docker binary from
# the host to the container. This is not reliable anymore, because the Docker
# Engine is no longer distributed as (almost) static libraries."
ARG docker_version=1.12.3
RUN curl -sSL https://get.docker.com/ | sh && \
    apt-get purge -y docker-engine && \
    apt-get install docker-engine=${docker_version}-0~jessie && \
    apt-get install -y software-properties-common && \
    apt-add-repository ppa:ansible/ansible && \
    apt-get install -y ansible

RUN curl -L https://github.com/docker/compose/releases/download/1.9.0/docker-compose-`uname -s`-`uname -m` > /usr/local/bin/docker-compose
chmod +x /usr/local/bin/docker-compose

# Make sure jenkins user has docker privileges
RUN usermod -aG docker jenkins

# Install initial plugins
USER jenkins

# supervisord
USER root

# Create log folder for supervisor and jenkins
RUN mkdir -p /var/log/supervisor
RUN mkdir -p /var/log/jenkins

# Copy the supervisor.conf file into Docker
#COPY supervisord.conf /etc/supervisor/conf.d/supervisord.conf

# Start supervisord when running the container
#CMD /usr/bin/supervisord -c /etc/supervisor/conf.d/supervisord.conf