package com.fillswim.spring.springboot.my_springboot_rest_jpa.DAO;

import com.fillswim.spring.springboot.my_springboot_rest_jpa.Entity.Employee;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository()
public class EmployeeDAOImpl implements EmployeeDAO{

    private final EntityManager entityManager;

    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void saveEmployee(Employee employee) {

        Employee newEmployee = entityManager.merge(employee);
        employee.setId(newEmployee.getId());

    }

    @Override
    public Employee getEmployee(int id) {

        Employee employee = entityManager.find(Employee.class, id);

        return employee;
    }


    @Override
    public List<Employee> getAllEmployees() {

        List<Employee> employees = entityManager.createQuery("from Employee", Employee.class).getResultList();

        return employees;
    }

    @Override
    public void deleteEmployee(int id) {

        Session session = entityManager.unwrap(Session.class);

        Query query = entityManager.createQuery("delete from Employee where id =: id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
