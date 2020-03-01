FROM openjdk:11-slim-buster

# ENV PROXY_ADDRESS 192.168.6.145:80

# ENV HTTP_PROXY http://$PROXY_ADDRESS/
# ENV http_proxy http://$PROXY_ADDRESS/
# ENV HTTPS_PROXY http://$PROXY_ADDRESS/
# ENV https_proxy http://$PROXY_ADDRESS/

RUN apt-get update && apt-get install -yq \
       dnsutils \
       iputils-ping \																				
       iputils-tracepath \
       dnsutils \
       coreutils \
       locate \
       findutils \
       net-tools \
       telnet \
       curl \
       libjemalloc2 \
       iproute2 && apt-get clean && rm -rf /var/lib/apt/lists

# unset the environment variables only needed to install above

ENV PROXY_ADDRESS ""
ENV HTTP_PROXY ""
ENV http_proxy ""
ENV HTTPS_PROXY ""
ENV https_proxy ""
ENV LD_PRELOAD "/usr/lib/x86_64-linux-gnu/libjemalloc.so.2"

ARG JAR_FILE
RUN echo ${JAR_FILE}
ADD ${JAR_FILE} /app.jar
EXPOSE 8080

CMD ["java", "-jar", "/app.jar"]
# HEALTHCHECK --interval=10s --timeout=8s --start-period=120s --retries=3 CMD curl --fail http://localhost:8080/actuator/health/ || exit 1

