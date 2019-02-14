package com.cursosdedesarrollo.springbootresth2;

import java.util.List;

public interface EmployeeService {
    public List<Employee> retrieveEmployees();

    public Employee getEmployee(Long employeeId);

    public Employee saveEmployee(Employee employee);

    public Employee deleteEmployee(Long employeeId);

    public Employee updateEmployee(Employee employee);
}
