# Using env variables with Spring Boot

This is an example application which demonstrates how to configure a Spring Boot app via environment
variables. This simple app expects to receive three properties. Default values are provided in the app.

## SPRING_APPLICATION_JSON

You can set a a set of environment variables by assigning a JSON structure to `SPRING_APPLICATION_JSON`
environment variable. For example, to set `ec2.public.url` to `http://mydomain.com`, you could
run this application as follows.

```
SPRING_APPLICATION_JSON='{"ec2":{"public":{"url":"http://mydomain.com"}}}'
java -jar configuration-0.0.1-SNAPSHOT.jar
```

Spring will read `SPRING_APPLICATION_JSON` environment variable to get its application properties. On
application startup, the value of `ec2.public.url` is printed to the console.

## Injecting env variables directly

`@Value` annotation can be used to inject properties to beans. It also looks for values from the
environment. This example demonstrates how the application reads a database url from the environment.

```java
@Value("${DB_URL}")
private String dbUrl;
```

Run the application as follows.

```
DB_URL="jdbc:hsqldb:mem:mymemdb"
java -jar configuration-0.0.1-SNAPSHOT.jar
```

You should see that the database url is printed to the console.

## Setting `applicaiton.properties` values from environment

Similar to the previous approach, it is possible to assign values to properties from the environment
in your `application.properties` file.

```
api.key=${API_KEY:not set}
```

And run your app as follows.

```
API_KEY="123abc"
java -jar configuration-0.0.1-SNAPSHOT.jar 
```