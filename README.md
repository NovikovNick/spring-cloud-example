# spring-cloud-example

```.env
curl http://172.18.0.2:20080 -H "Content-type: text/plain" -d "Happy streaming"
docker exec -it skipper tail -f /tmp/1579077998034/Stream_6.log-v1/stdout_0.log
docker exec -it skipper tail -f /tmp/1579347438968/Stream_1.data-source-v3/stderr_0.log


```

```$xslt
./gradlew clean build

docker build -t spring-cloud-example/config-server:latest ./docker/config

docker build -t spring-cloud-example/app:latest ./docker/app
docker build -t spring-cloud-example/data-source:latest ./docker/data-source
docker build -t spring-cloud-example/data-flow-processor:latest ./docker/data-flow-processor
docker-compose up


docker build -t data-source:latest ./docker/data-source


app register --name data-source --type source --uri file:///apps/data-source/data-source-1.0.0.jar

```

```.env

  app:
    image: spring-cloud-example/app:latest
    network_mode: "host"
  data-source:
    image: spring-cloud-example/data-source
    network_mode: "host"
  data-flow-processor:
    image: spring-cloud-example/data-flow-processor
    network_mode: "host"
  app-import:
    image: springcloud/openjdk:2.0.0.RELEASE
    container_name: dataflow-app-import
    depends_on:
      - dataflow-server
    command: >
      /bin/sh -c "
        ./wait-for-it.sh -t 180 dataflow-server:9393;
        wget -qO- 'http://dataflow-server:9393/apps' --post-data='uri=${STREAM_APPS_URI:-https://dataflow.spring.io/rabbitmq-maven-latest&force=true}';
        echo 'Stream apps imported'
        wget -qO- 'http://dataflow-server:9393/apps' --post-data='uri=${TASK_APPS_URI:-https://dataflow.spring.io/task-maven-latest&force=true}';
        echo 'Task apps imported'"

```