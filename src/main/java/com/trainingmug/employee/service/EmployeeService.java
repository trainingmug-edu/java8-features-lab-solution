package com.trainingmug.employee.service;

import com.trainingmug.employee.domain.Employee;
import com.trainingmug.employee.exception.EmployeeAlreadyExistsException;
import com.trainingmug.employee.exception.EmployeeNotFoundException;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getEmployees();
    public Employee findEmployeeById(int empId) throws EmployeeNotFoundException;
    public Employee addEmployee(Employee employee) throws EmployeeAlreadyExistsException;
    public Employee updateEmployee(Employee employee) throws EmployeeNotFoundException;
    public boolean deleteEmployee(int empId) throws EmployeeNotFoundException;

}
