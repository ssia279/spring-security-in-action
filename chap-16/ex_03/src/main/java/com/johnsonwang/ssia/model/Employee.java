package com.johnsonwang.ssia.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class Employee {

    private String name;
    private List<String> books;
    private List<String> roles;

    public Employee(String name, List<String> books, List<String> roles) {
        this.name = name;
        this.books = books;
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;

        return Objects.equals(name, employee.name) &&
                Objects.equals(books, employee.books) &&
                Objects.equals(roles, employee.roles);
    }
}
