package com.cursosdedesarrollo.springbootresth2;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{
¡
    @Autowired
    private EmployeeRepository employeeRepository;

    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> retrieveEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }

    public Employee getEmployee(Long employeeId) {
        Optional<Employee> optEmp = employeeRepository.findById(employeeId);
        return optEmp.get();
    }

    public Employee saveEmployee(Employee employee){
        employeeRepository.save(employee);
        return employee;
    }

    public Employee deleteEmployee(Long employeeId){
        Optional<Employee> optEmp = employeeRepository.findById(employeeId);
        Employee employee= optEmp.get();
        employeeRepository.deleteById(employee.getId());
        return employee;
    }

    public Employee updateEmployee(Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }
}
