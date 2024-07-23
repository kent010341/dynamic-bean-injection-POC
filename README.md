# Dynamic Bean Injection POC

This project is a proof of concept (POC) for dynamic bean injection in Spring Boot 
using factory methods to enforce dependency injection.

## Overview

In many Spring Boot applications, you might encounter a scenario where you need to 
create an instance with dynamic parameters (e.g., `Foo#name`) while also needing 
dependencies injected by Spring (e.g., `Foo#barService`).

Directly using `applicationContext.getBean` or `@Autowired` cannot handle 
dynamic parameters, and using `new` to instantiate `Foo` will bypass 
Spring's dependency injection, resulting in missing dependencies.

To address this, we use a factory method to create instances of `Foo`. 
This approach ensures that:

1. **Dynamic Parameters**: We can pass dynamic parameters to the constructor.
2. **Dependency Injection**: Spring can still manage and inject the necessary dependencies.
3. **Proper Construction**: Instances are properly constructed with all necessary dependencies, 
avoiding issues with direct instantiation.

## Structure

- **Foo**: Represents the main class that requires a `BarService` to perform operations. 
It uses a static inner class `FooFactory` to create instances.
- **BarService**: An interface defining a service with a method to perform an operation on a string.
- **BarServiceImpl**: Implementation of `BarService`.
- **FooController**: A REST controller to handle requests and demonstrate the creation and usage of `Foo`.

## Running the Application

1. Clone the repository.
2. Navigate to the project directory.
3. Run the application using:
    ```bash
    mvn spring-boot:run
    ```
4. Access the API endpoint:
    ```
    http://localhost:8080/api/foo?name=dynamicName
    ```

## Example

Send a GET request to the following endpoint:
```
http://localhost:8080/api/foo?name=dynamicName
```

You should see a response like:

```
BarServiceImpl received dynamicName
```
