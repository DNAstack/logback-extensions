# logback-extensions
Extensions to logback for smoother integration with cloud environments. Currently, supports transforming default spring-boot logs into a JSON format appropriate for Google's Stackdriver.


## Usage


1. Add maven dependency for this package to your app:
```
<dependency>
  <groupId>com.dnastack</groupId>
  <artifactId>logback-extensions</artifactId>
  <version>0.1</version>
</dependency>
```

1. Configure logback (see `/examples`). For spring-boot applications, `/examples/logback-spring.xml` is a copy-pastable configurations.

  * If you are using the above example configuration, enable the `gke-logging` Spring profile.