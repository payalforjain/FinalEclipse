FROM java:8
WORKDIR /app
VOLUME /c/git/FinalEclipse/springwithDocker/spring-boot-demo/target /app
CMD java -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=8000 -jar spring-boot-demo-0.0.1-SNAPSHOT.jar