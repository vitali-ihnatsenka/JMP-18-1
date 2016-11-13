package by.epam.jmp18.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Vitali on 12.11.2016.
 */
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private EmployeeStatus status;

    @Embedded
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="personal")
    private Personal personal;

    @ManyToMany
    @JoinTable(
            name = "EMPLOYEE_TO_PROJECT",
            joinColumns = @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "PROJECT_ID", referencedColumnName = "id"))
    private Set<Project> projects = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "UNIT")
    private Unit unit;

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}
