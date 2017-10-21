# Using env variables with Spring Boot

This is an example application which demonstrates how to configure a Spring Boot app via environment
variables. This simple app expects to receive a property named `ec2.public.url`.

## SPRING_APPLICATION_JSON

You can set a a set of environment variables by assigning a JSON structure to `SPRING_APPLICATION_JSON`
environment variable. For example, to set `ec2.public.url` to `http://mydomain.com`, you could
run this application as follows.

```
SPRING_APPLICATION_JSON='{"ec2":{"public":{"url":"http://mydomain.com"}}}'
java -jar configuration-0.0.1-SNAPSHOT.jar
```

Spring will read `SPRING_APPLICATION_JSON` environment variable to get its application properties.