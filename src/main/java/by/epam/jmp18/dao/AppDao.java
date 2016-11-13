package by.epam.jmp18.dao;

import by.epam.jmp18.domain.Employee;
import by.epam.jmp18.domain.Project;
import by.epam.jmp18.domain.Unit;

/**
 * Created by Vitali on 13.11.2016.
 */
public interface AppDao {
    Employee getEmployee(long id);
    Unit getUnit(long id);
    Project getProject(long id);
    void updateEmployee(Employee employee);
    void updateUnit(Unit unit);
    void updateProject(Project project);
}
