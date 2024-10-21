* `docker-compose up` - to start OTLP collector locally
* `dev1` and `dev2` are equals, you can run any of it, or both to simulate cross-service communication (PingPong test)
* `jagger-ui` is available at http://localhost:16686/
* service swagger at
  * http://127.0.0.1:18080/swagger-ui/index.html for dev1 profile
  * http://127.0.0.1:19090/swagger-ui/index.html for dev2 profile
* `/test` runs local service operation
* `/check` runs cross-service operation
* `/check2` runs multithreaded cross-service operation