package com.trainingmug.employee.service;

import com.trainingmug.employee.domain.Employee;
import com.trainingmug.employee.exception.EmployeeAlreadyExistsException;
import com.trainingmug.employee.exception.EmployeeNotFoundException;
import com.trainingmug.employee.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl() {
        this.employeeRepository = new EmployeeRepository();
    }

    @Override
    public List<Employee> getEmployees() {
        return this.employeeRepository.getEmployeeList();
    }

    @Override
    public Employee findEmployeeById(int empId) throws EmployeeNotFoundException {
        return this.employeeRepository.getEmployeeList().stream().filter(employee -> employee.getEmpId() == empId)
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("Employee Not Found with this ID :" + empId));
    }

    @Override
    public Employee addEmployee(Employee employee) throws EmployeeAlreadyExistsException {
        Optional<Employee> employeeOptional = this.employeeRepository.getEmployeeList().stream()
                .filter(emp -> emp.getEmpId() == employee.getEmpId()).findFirst();
        if (employeeOptional.isPresent())
            throw new EmployeeAlreadyExistsException("Employee Already Exists with this ID :" + employee.getEmpId());
        else
            this.employeeRepository.getEmployeeList().add(employee);
        return employee;
    }

    @Override
    public Employee updateEmployee(Employee employee) throws EmployeeNotFoundException {
        Employee employeeToBeUpdated = this.employeeRepository.getEmployeeList().stream()
                .filter(emp -> emp.getEmpId() == employee.getEmpId()).findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("Employee Not Found with this ID :" + employee.getEmpId()));
        int index = this.employeeRepository.getEmployeeList().indexOf(employeeToBeUpdated);
        this.employeeRepository.getEmployeeList().set(index, employee);
        return employee;
    }

    @Override
    public boolean deleteEmployee(int empId) throws EmployeeNotFoundException {
        Employee employeeToBeDeleted = this.employeeRepository.getEmployeeList().stream()
                .filter(employee -> employee.getEmpId() == empId).findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("Employee Not Found with this ID :"));
        int index = this.employeeRepository.getEmployeeList().indexOf(employeeToBeDeleted);
        this.employeeRepository.getEmployeeList().remove(index);
        return true;
    }

}
