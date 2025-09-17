# Java 22–25 Examples 🚀

## 📌 Purpose

This project provides a collection of Java code examples demonstrating **finalized language features and APIs** introduced between **Java 22 and Java
25**.
It is designed to help developers **understand changes between LTS releases** and make upgrading from **Java 21 to Java 25** easier.

All examples are implemented as **JUnit 5 tests**, allowing you to run and verify each feature in action.
All included features are **finalized and ready for production use**.

---

## 🗂 Feature Summary (Java 22 → 25, Finalized Only)

| Java Version | Key Features (Finalized, Production-Ready)                                                                                                                                                                                                                                                                                    |
|--------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Java 22**  | - **[JEP 456](https://openjdk.org/jeps/456)**: Unnamed Variables & Patterns<br>- **[JEP 454](https://openjdk.org/jeps/454)**: Foreign Function & Memory API<br>- **[JEP 458](https://openjdk.org/jeps/458)**: Launch Multi-File Source-Code Programs                                                                          |
| **Java 23**  | - **[JEP 467](https://openjdk.org/jeps/467)**: Markdown Documentation Comments                                                                                                                                                                                                                                                |
| **Java 24**  | - **[JEP 485](https://openjdk.org/jeps/485)**: Stream Gatherers                                                                                                                                                                                                                                                               |
| **Java 25**  | - **[JEP 506](https://openjdk.org/jeps/506)**: Scoped Values<br>- **[JEP 510](https://openjdk.org/jeps/510)**: Key Derivation Function API<br>- **[JEP 512](https://openjdk.org/jeps/512)**: Compact Source Files and Instance Main Methods<br>- **[JEP 513](https://openjdk.org/jeps/513)**: Flexible Constructor Bodies<br> |

> ⚠️ **Note:** This table includes only **finalized, production-ready features**. Features in preview or incubator status are not included.

---

## ⬆️ Upgrade Guide: From Java 21 → 25

This project serves as a **practical reference** to understand **new finalized features** and API changes across LTS releases, making the migration
smoother:

* Explore examples in each version folder to identify **new language syntax or API changes**.
* Run the JUnit tests to ensure your code **behaves consistently** across versions.
* Use this project as a **step-by-step guide for upgrading your projects incrementally**.

All examples are **safe for production environments**.

---

## 🛠️ Requirements

* Install **JDK 25** (latest release).

  > Although examples are grouped by version, the project is compiled and executed with Java 25.

* Build and run with either **Gradle** or **Maven** using the included wrappers (`./gradlew`, `./mvnw`).

---

## ⚡ Running the Examples

### Using Gradle

The wrapper will ensure the correct Gradle version is used.

To clean and run all tests:
```bash
./gradlew clean test
```

**If you’re having issues with Gradle, try these commands to fix them:**

1. Stop all running Gradle daemon processes:
```bash
./gradlew --stop
```

2. Clean build, refresh dependencies, and run tests (forces re-download of dependencies)
```bash
./gradlew clean test --refresh-dependencies
```

For more details of Gradle build support see build.gradle in the project's root folder.

### Using Maven

The wrapper will download and use the correct Maven version.
To clean and run all tests:

```bash
./mvnw clean test
```

For more details of Maven build support see pom.xml in the project's root folder.


---

## 📖 References

* [JEPs in Java 22](https://openjdk.org/projects/jdk/22/)
* [JEPs in Java 23](https://openjdk.org/projects/jdk/23/)
* [JEPs in Java 24](https://openjdk.org/projects/jdk/24/)
* [JEPs in Java 25](https://openjdk.org/projects/jdk/25/)
* [Java Foreign Function & Memory API (FFM API)](https://www.happycoders.eu/java/foreign-function-memory-api/)
* [Markdown in Java Docs? Shut Up and Take My Comments!](https://blog.jetbrains.com/idea/2025/04/markdown-in-java-docs-shut-up-and-take-my-comments/)
* [Stream Gatherers in JDK 24](https://www.danvega.dev/blog/stream-gatherers)
* [Java 25 Launch Stream](https://www.youtube.com/live/duIceCXObrA?si=azsPW7Jv16IISZDV&t=390)

---