package com.github.ismail2ov.java25;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class FlexibleConstructorBodiesTest {

    public static final String EMPLOYEE_NAME = "John Doe";

    @Test
    void shouldCreateEmployeeWithValidAge() {
        Employee employee = new Employee(EMPLOYEE_NAME, 30);

        assertThat(employee).extracting("name", "age")
            .containsExactly(EMPLOYEE_NAME, 30);
    }

    @Test
    void shouldThrowExceptionForUnderageEmployee() {
        assertThatThrownBy(() -> new Employee(EMPLOYEE_NAME, 17))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void shouldThrowExceptionForOverageEmployee() {
        assertThatThrownBy(() -> new Employee(EMPLOYEE_NAME, 68))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void shouldThrowExceptionForNegativeAge() {
        assertThatThrownBy(() -> new Employee(EMPLOYEE_NAME, -1))
            .isInstanceOf(IllegalArgumentException.class);
    }
}

class Person {

    String name;
    int age;

    Person(String name, int age) {
        if (age < 0) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.age = age;
    }
}

class Employee extends Person {

    Employee(String name, int age) {
        if (age < 18 || age > 67) {
            throw new IllegalArgumentException();
        }
        super(name, age);
    }

}