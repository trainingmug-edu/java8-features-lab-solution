package com.trainingmug.employee.main;

import com.trainingmug.employee.domain.Employee;
import com.trainingmug.employee.exception.EmployeeAlreadyExistsException;
import com.trainingmug.employee.exception.EmployeeNotFoundException;
import com.trainingmug.employee.repository.EmployeeRepository;
import com.trainingmug.employee.service.EmployeeServiceImpl;
import com.trainingmug.employee.service.PayrollImpl;

import java.util.List;
import java.util.Set;

public class CollectionTest {

    public static void main(String[] args) {

        EmployeeRepository empRepository = new EmployeeRepository();
        Set<Employee> employeeSet = empRepository.getEmployeeSet();
        // Print the empoyee count
        // System.out.println("No of Employees : " + employeeSet.size());

        PayrollImpl payroll = new PayrollImpl();

        /*
         * Iterator<Employee> iterator = employeeSet.iterator();
         * while(iterator.hasNext()) { payroll.displayProfile(iterator.next()); }
         */

        List<Employee> employeeList = empRepository.getEmployeeList();
        /*
         * System.out.println("No of Employees : " + employeeList.size());
         *
         * Iterator<Employee> iterator = employeeList.iterator();
         *
         * while(iterator.hasNext()) { payroll.displayProfile(iterator.next()); }
         */

        /*
         * Map<Integer, Employee> employeeMap = empRepository.getEmployeeMap();
         * System.out.println("No of Employees : " + employeeMap.size());
         * Set<Entry<Integer, Employee>> entrySet = employeeMap.entrySet();
         * for(Entry<Integer,Employee> entry : entrySet) {
         * payroll.displayProfile(entry.getValue()); }
         */

        EmployeeServiceImpl empService = new EmployeeServiceImpl();

        // Testing - getAllEmployees

        System.out.println(" ::::  Get All Employees :::::");
        empService.getEmployees().forEach(employee -> employee.displayProfile());

        // Testing - findEmployeeById
        try {
            Employee employee = empService.findEmployeeById(4443454);
            employee.displayProfile();
        } catch (EmployeeNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // Testing - addEmployee

        Employee newEmployee = new Employee(9999, "John Peter", "Senior Devops Engineer", 4569.45F, 280.5F, 535.45F,
                326.34F, 12.5F, "00343538343");

        try {
            empService.addEmployee(newEmployee);
        } catch (EmployeeAlreadyExistsException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        // Testing - updateEmployee
        Employee empToBeUpdated = new Employee(3333, "Nancy Davolio", "Senior Devops Engineer", 4569.45F, 280.5F,
                535.45F, 326.34F, 12.5F, "00343538343");
        try {
            empService.updateEmployee(empToBeUpdated);
        } catch (EmployeeNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        empService.getEmployees().forEach(emp -> emp.displayProfile());

        // Testing - deleteEmployee
        int empId = 3333;
        try {
            empService.deleteEmployee(empId);
        } catch (EmployeeNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        empService.getEmployees().forEach(emp -> emp.displayProfile());

    }

}

