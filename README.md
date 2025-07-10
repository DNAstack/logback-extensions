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
<dependency>
      <groupId>ch.qos.logback.contrib</groupId>
      <artifactId>logback-jackson</artifactId>
      <version>0.1.5</version>
</dependency>
```

2. Configure logback: `/examples/logback-spring.xml` is a copy-pastable configurations.

  * If you are using the above example configuration, enable the `gcp` Spring profile to enable JSON logging.

## Deployment Process

This library is published to Maven Central. The deployment process is automated using Concourse CI.

### Build Pipeline

Commits trigger builds in the libraries-build pipeline.

### Release Process

1. **Create a SNAPSHOT tag**: Create an annotated tag on the main branch for the next release with the SNAPSHOT postfix (e.g., `1.2.1-SNAPSHOT`)
   ```bash
   git tag -a 1.2.1-SNAPSHOT -m "Start development of version 1.2.1"
   git push origin 1.2.1-SNAPSHOT
   ```

2. **Development**: Branch, commit, push, and create pull requests as usual

3. **Release**: When the current snapshot is ready to become a release, create the release tag (e.g., `1.2.1`)
   ```bash
   git tag -a 1.2.1 -m "Release version 1.2.1"
   git push origin 1.2.1
   ```

4. **Next development cycle**: Once the release build completes and the new release is available on Maven Central, tag the current commit with the next release version's SNAPSHOT
   ```bash
   git tag -a 1.2.2-SNAPSHOT -m "Start development of version 1.2.2"
   git push origin 1.2.2-SNAPSHOT
   ```

**Note**: Tags must match the regex `^[0-9]+\.[0-9]+\.[0-9]+$` to trigger a release build.