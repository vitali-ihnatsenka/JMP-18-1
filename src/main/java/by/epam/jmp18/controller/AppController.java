package by.epam.jmp18.controller;

import by.epam.jmp18.dao.AppDao;
import by.epam.jmp18.domain.Employee;
import by.epam.jmp18.domain.Project;
import by.epam.jmp18.domain.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Vitali on 13.11.2016.
 */
@RestController
public class AppController {
    @Autowired
    private AppDao appDao;

    @RequestMapping(value = "/addEmployee/{employeeId}/toUnit/{unitId}", method = RequestMethod.POST)
    public ResponseEntity<String> addEmployeeToUnit(@PathVariable("employeeId") long employeeId,
                                                    @PathVariable("unitId") long unitId) {
        Employee employee = appDao.getEmployee(employeeId);
        Unit unit = appDao.getUnit(unitId);
        if(employee == null || unit == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        unit.addEmployee(employee);
        appDao.updateUnit(unit);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/assignEmployee/{employeeId}/ForProject/{projectId}", method = RequestMethod.POST)
    public ResponseEntity<String> assignEmployeeForProject(@PathVariable("employeeId") long employeeId,
                                                    @PathVariable("projectId") long projectId) {
        Employee employee = appDao.getEmployee(employeeId);
        Project project = appDao.getProject(projectId);
        if(employee == null || project == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        project.getEmployees().add(employee);
        employee.getProjects().add(project);
        appDao.updateEmployee(employee);
        appDao.updateProject(project);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
