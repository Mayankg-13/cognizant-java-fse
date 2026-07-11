# Week 3: Spring Web & Spring Core Exercises (spring-learn)

This directory contains the exercises completed for Week 3 of the Cognizant Java FSE training, focusing on Spring Boot Web, XML Bean Configuration, Dependency Injection, and custom logging.

---

## Exercise 1: Spring Boot Web Application & Custom Logging

### Description
In this exercise, we initialize a Spring Boot Web MVC application, inspect its Maven configuration, and implement custom SLF4J logging in the main application entry point to print a startup confirmation log.

### Code Implementation (Initial Main Method)
```java
package spring_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringLearnApplication.class, args);
		LOGGER.info("Inside main method");
	}
}
```

### Compile and Run
1. Navigate to the project directory:
   ```powershell
   cd "week 3/spring-learn"
   ```
2. Build the project:
   ```powershell
   ./mvnw clean package
   ```
3. Run the application:
   ```powershell
   ./mvnw spring-boot:run
   ```

### Output Screenshot (Exercise 1)
![Spring Learn Exercise 1 Output](./spring_learn_win.png)

---

## Exercise 2: Load Country from Spring Configuration XML

### Description
This exercise demonstrates Spring Core XML bean configuration and Property Dependency Injection. A `Country` bean is defined in `country.xml`, loaded into the Spring `ApplicationContext` via `ClassPathXmlApplicationContext`, and retrieved to display the country's details.

### Code Implementation

#### 1. Spring XML Configuration (`src/main/resources/country.xml`)
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="country" class="spring_learn.Country">
        <property name="code" value="IN" />
        <property name="name" value="India" />
    </bean>

</beans>
```

#### 2. Country Bean Class (`src/main/java/spring_learn/Country.java`)
```java
package spring_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Country {
    private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);

    private String code;
    private String name;

    public Country() {
        LOGGER.debug("Inside Country Constructor.");
    }

    public String getCode() {
        LOGGER.debug("Inside getCode Getter.");
        return code;
    }

    public void setCode(String code) {
        LOGGER.debug("Inside setCode Setter: " + code);
        this.code = code;
    }

    public String getName() {
        LOGGER.debug("Inside getName Getter.");
        return name;
    }

    public void setName(String name) {
        LOGGER.debug("Inside setName Setter: " + name);
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country{code='" + code + "', name='" + name + "'}";
    }
}
```

#### 3. Main Application Class (`SpringLearnApplication.java`)
```java
package spring_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringLearnApplication.class, args);
		LOGGER.info("Inside main method");
		displayCountry();
	}

	private static void displayCountry() {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = context.getBean("country", Country.class);
		LOGGER.debug("Country : {}", country.toString());
	}
}
```

### Compile and Run
1. Run the application:
   ```powershell
   ./mvnw spring-boot:run
   ```

### Output Screenshot (Exercise 2)
![Spring Learn Exercise 2 Output](./spring_learn_country_win.png)

---

## Detailed Explanations (SME Corner)

### 1. Spring XML Bean Configuration Key Concepts
- **`<bean>` tag**: Defines a Java object (bean) that will be managed by the Spring IoC (Inversion of Control) container.
- **`id` attribute**: A unique identifier for the bean in the container context. This ID is used to retrieve the bean using `context.getBean("beanId")`.
- **`class` attribute**: The fully qualified class name of the bean to be instantiated by Spring.
- **`<property>` tag**: Configures dependency injection using setter injection. Spring calls the corresponding setter method on the class to inject the values.
- **`name` attribute**: Specifies the name of the class property (e.g. `code` corresponds to `setCode(String code)`).
- **`value` attribute**: Specifies the literal value to inject into the property.

### 2. ApplicationContext & ClassPathXmlApplicationContext
- **`ApplicationContext`**: The central interface representing the Spring IoC container. It is responsible for instantiating, configuring, and assembling beans, as well as managing their lifecycle.
- **`ClassPathXmlApplicationContext`**: A concrete implementation of `ApplicationContext` that loads configuration definitions from an XML file located on the application classpath (e.g. `src/main/resources/country.xml`).

### 3. What Happens on `context.getBean()`?
When `context.getBean("country", Country.class)` is invoked:
1. **Container Check**: The IoC container checks its internal registry of singleton instances to see if a bean with the ID `"country"` has already been instantiated.
2. **Instance Creation (if singleton not yet instantiated)**:
   - Spring invokes the no-argument constructor of `Country` (logging `"Inside Country Constructor."`).
   - Spring uses reflection to call `setCode("IN")` and `setName("India")` (logging setter operations).
3. **Retrieval**: Since it is scoped as a Singleton (default scope), it returns the fully configured `Country` instance. Subsequent calls will return the same cached instance.
