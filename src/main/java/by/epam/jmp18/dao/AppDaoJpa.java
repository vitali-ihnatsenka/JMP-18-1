package by.epam.jmp18.dao;

import by.epam.jmp18.domain.Employee;
import by.epam.jmp18.domain.Project;
import by.epam.jmp18.domain.Unit;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Vitali on 13.11.2016.
 */
@Repository
public class AppDaoJpa implements AppDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Employee getEmployee(long id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    @Transactional
    public Unit getUnit(long id) {
        return entityManager.find(Unit.class, id);
    }

    @Override
    @Transactional
    public Project getProject(long id) {
        return entityManager.find(Project.class, id);
    }

    @Override
    @Transactional
    public void updateEmployee(Employee employee) {
        entityManager.merge(employee);
    }

    @Override
    @Transactional
    public void updateUnit(Unit unit) {
        entityManager.persist(unit);
    }

    @Override
    @Transactional
    public void updateProject(Project project) {
        entityManager.merge(project);
    }
}
