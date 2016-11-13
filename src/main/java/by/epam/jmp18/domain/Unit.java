package by.epam.jmp18.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Vitali on 12.11.2016.
 */
@Entity
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "unit", cascade = CascadeType.ALL)
    private Set<Employee> employees = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public boolean addEmployee(Employee employee) {
        return this.employees.add(employee);
    }
}
