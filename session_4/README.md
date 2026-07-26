# Maven Single-Module Class Demo

This project is intentionally a **single-module Maven project**.

It does not introduce:

- Parent/child POMs
- Multi-module builds
- Reactor builds
- Module dependencies
- `-pl`
- `-am`

Those concepts can be taught in the later class.

## Concepts demonstrated

- What Maven is
- What a build tool does
- `pom.xml`
- Project coordinates
- Standard directory structure
- Dependencies
- Dependency scopes
- Transitive dependencies
- Local and remote repositories
- Maven Central
- Lifecycles and phases
- Plugins and goals
- Profiles
- `settings.xml`
- Compilation
- Tests
- Packaging
- Local installation
- Common Maven commands

## Project structure

```text
maven-single-module-demo/
├── pom.xml
├── settings-example.xml
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/training/
│   │   │       ├── Main.java
│   │   │       └── GreetingService.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── com/example/training/
│               ├── GreetingServiceTest.java
│               └── ConfigurationTest.java
└── target/
```

`target/` appears only after Maven runs.

## 1. Verify Java and Maven

```bash
java --version
mvn --version
```

Explain that Maven requires Java because Maven itself runs on the JVM.

## 2. Examine pom.xml

The project coordinates are:

```text
com.example.training:maven-single-module-demo:1.0.0-SNAPSHOT
```

Meaning:

```text
groupId     Organization or namespace
artifactId  Project name
version     Project version
```

The project uses:

```xml
<packaging>jar</packaging>
```

so Maven creates a JAR file.

## 3. Standard directory structure

```text
src/main/java       Application Java code
src/main/resources  Application resources
src/test/java       Test Java code
target/              Generated build output
```

Maven understands these directories by convention.

## 4. Validate

```bash
mvn validate
```

This checks that the project model is valid and usable.

## 5. Compile

```bash
mvn compile
```

Inspect:

```text
target/classes/
```

You should find:

- Compiled `.class` files
- Filtered `application.properties`

## 6. Dependencies

The project directly depends on Apache Commons Lang:

```xml
<dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-lang3</artifactId>
    <version>${commons.lang3.version}</version>
</dependency>
```

It is used in `GreetingService`.

JUnit is declared with:

```xml
<scope>test</scope>
```

so it is available only to test code.

## 7. Transitive dependencies

Run:

```bash
mvn dependency:tree
```

This displays direct and transitive dependencies.

Explain:

- Direct dependency: written explicitly in this POM
- Transitive dependency: needed by another dependency and downloaded automatically

## 8. Repositories

Maven first checks the local repository:

```text
~/.m2/repository
```

If a dependency is missing, Maven resolves it from configured remote repositories.

Maven Central is the default public remote repository.

Search the local repository for:

```text
org/apache/commons/commons-lang3
org/junit/jupiter
```

## 9. Tests

```bash
mvn test
```

Maven compiles and executes the tests.

Inspect:

```text
target/test-classes/
target/surefire-reports/
```

The Surefire plugin performs the test execution.

## 10. Package

```bash
mvn package
```

This runs all earlier default lifecycle phases through `package`.

Inspect:

```text
target/maven-single-module-demo-1.0.0-SNAPSHOT.jar
```

Also inspect the JAR contents:

```bash
jar tf target/maven-single-module-demo-1.0.0-SNAPSHOT.jar
```

## 11. Run the application

Use the Exec Maven Plugin goal:

```bash
mvn exec:java
```

Pass a name:

```bash
mvn exec:java -Dexec.args="ana"
```

Expected output:

```text
Hello, Ana!
Build environment: development
```

This demonstrates the difference between:

```text
mvn package    Lifecycle phase
mvn exec:java  Plugin goal
```

## 12. Profile demonstration

Activate the `training` profile:

```bash
mvn clean package -Ptraining
mvn exec:java -Ptraining -Dexec.args="ana"
```

Expected output:

```text
Welcome, Ana!
Build environment: training
```

The profile changes build-time properties.

Maven filters the values into:

```text
target/classes/application.properties
```

## 13. Clean

```bash
mvn clean
```

This deletes `target/`.

Then rebuild:

```bash
mvn clean package
```

## 14. Install

```bash
mvn install
```

This creates the JAR and copies it into the local Maven repository.

Look for:

```text
~/.m2/repository/
└── com/
    └── example/
        └── training/
            └── maven-single-module-demo/
                └── 1.0.0-SNAPSHOT/
```

This allows another project on the same machine to use the artifact as a dependency.

## 15. Verify

```bash
mvn verify
```

This runs the default lifecycle through `verify`.

This project has only unit tests. Integration tests would require additional plugin configuration, which is not introduced here.

## 16. settings.xml

Open:

```text
settings-example.xml
```

It demonstrates where Maven can configure:

- A custom local repository
- A company mirror
- Remote repository credentials

User settings normally live at:

```text
~/.m2/settings.xml
```

## 17. Effective configuration

```bash
mvn help:effective-pom
mvn help:active-profiles
mvn help:effective-settings
```

These commands show the configuration Maven actually uses after combining the project POM, profiles, settings, and defaults.

## 18. Test skipping

Compile tests but do not run them:

```bash
mvn package -DskipTests
```

Do not compile or run tests:

```bash
mvn package -Dmaven.test.skip=true
```

Skipping tests should be exceptional.

## Recommended classroom order

```bash
mvn --version
mvn validate
mvn compile
mvn test
mvn package
mvn exec:java -Dexec.args="ana"
mvn dependency:tree
mvn clean package -Ptraining
mvn exec:java -Ptraining -Dexec.args="ana"
mvn install
mvn help:effective-pom
mvn clean
```

## Student exercises

1. Add a `greetFormally()` method and a unit test.
2. Add a new property to `application.properties`.
3. Add another profile with a different greeting prefix.
4. Break one test and compare:
   - `mvn package`
   - `mvn package -DskipTests`
   - `mvn package -Dmaven.test.skip=true`
5. Run `mvn dependency:tree` and identify direct and transitive dependencies.
6. Change `1.0.0-SNAPSHOT` to `1.0.0`, run `mvn install`, and compare the local repository folders.
7. Add another test-scoped dependency.
8. Inspect the generated JAR with `jar tf`.
