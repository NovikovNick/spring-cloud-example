# spring-cloud-example


```$xslt
./gradlew clean build
docker build -t spring-cloud-example/app:latest ./docker/app
docker build -t spring-cloud-example/config-server:latest ./docker/config
docker-compose up
```