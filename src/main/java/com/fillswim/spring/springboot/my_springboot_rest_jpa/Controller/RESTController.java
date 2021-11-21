package com.fillswim.spring.springboot.my_springboot_rest_jpa.Controller;

import com.fillswim.spring.springboot.my_springboot_rest_jpa.Entity.Employee;
import com.fillswim.spring.springboot.my_springboot_rest_jpa.Service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RESTController {

    // Метод GET        http://localhost:8080/api/employees                  Получение всех работников
    // Метод GET        http://localhost:8080/api/employees{employeeID}      Получение одного работника
    // Метод POST       http://localhost:8080/api/employees                  Добавление работника
    // Метод PUT        http://localhost:8080/api/employees                  Изменение работника
    // Метод DELETE     http://localhost:8080/api/employees{employeeID}      Удаление работника

    private final EmployeeService employeeService;

    public RESTController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        return employeeService.getEmployee(id);
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {

        employeeService.deleteEmployee(id);

        return "Employee with ID = " + id + " was deleted";
    }


}
