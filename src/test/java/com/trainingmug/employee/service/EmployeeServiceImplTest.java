package com.trainingmug.employee.service;

import com.trainingmug.employee.domain.Employee;
import com.trainingmug.employee.exception.EmployeeAlreadyExistsException;
import com.trainingmug.employee.exception.EmployeeNotFoundException;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeServiceImplTest {

    private EmployeeServiceImpl employeeService;

    @BeforeEach
    void setUp() {
        employeeService = new EmployeeServiceImpl();
    }

    @Test
    @Order(1)
    @DisplayName("Check if EmployeeServiceImpl is created and implements EmployeeService")
    void testClassCreationAndInterfaceImplementation() {
        assertNotNull(employeeService, "EmployeeServiceImpl object should not be null");
        assertTrue(employeeService instanceof EmployeeService, "EmployeeServiceImpl should implement EmployeeService interface");
    }

    @Test
    @Order(2)
    @DisplayName("Check if getEmployees() method is declared and working")
    void testGetEmployees() {
        List<Employee> employees = employeeService.getEmployees();
        assertNotNull(employees, "Employee list should not be null");
        assertEquals(6, employees.size(), "Employee list size should be 6"); // Assuming the initial size is 7 as per the repository setup
    }

    @Test
    @Order(3)
    @DisplayName("Check if findEmployeeById() method is declared and working")
    void testFindEmployeeById() throws EmployeeNotFoundException {
        Employee employee = employeeService.findEmployeeById(3333);
        assertNotNull(employee, "Employee should not be null");
        assertEquals(3333, employee.getEmpId(), "Employee ID should be 3333");
        assertEquals("Nancy Davolio", employee.getName(), "Employee name should be 'Nancy Davolio'");

        assertThrows(EmployeeNotFoundException.class, () -> {
            employeeService.findEmployeeById(9999); // Assuming 9999 does not exist
        }, "Should throw EmployeeNotFoundException for non-existent ID");
    }

    @Test
    @Order(4)
    @DisplayName("Check if addEmployee() method is declared and working")
    void testAddEmployee() throws EmployeeAlreadyExistsException {
        Employee newEmployee = new Employee(9999, "John Doe", "Developer", 5000.00F, 300.00F, 400.00F, 200.00F, 10.0F, "1234567890");
        Employee addedEmployee = employeeService.addEmployee(newEmployee);
        assertNotNull(addedEmployee, "Added employee should not be null");
        assertEquals(9999, addedEmployee.getEmpId(), "Added employee ID should be 9999");
        assertEquals("John Doe", addedEmployee.getName(), "Added employee name should be 'John Doe'");

        assertThrows(EmployeeAlreadyExistsException.class, () -> {
            employeeService.addEmployee(newEmployee); // Adding the same employee again
        }, "Should throw EmployeeAlreadyExistsException for duplicate employee ID");
    }

    @Test
    @Order(5)
    @DisplayName("Check if updateEmployee() method is declared and working")
    void testUpdateEmployee() throws EmployeeNotFoundException {
        Employee updatedEmployee = new Employee(3333, "Nancy Davolio", "Senior DevOps Engineer", 7000.00F, 320.00F, 550.00F, 350.00F, 15.0F, "00343538343");
        Employee result = employeeService.updateEmployee(updatedEmployee);
        assertNotNull(result, "Updated employee should not be null");
        assertEquals("Senior DevOps Engineer", result.getDesignation(), "Designation should be 'Senior DevOps Engineer'");
        //assertEquals(7000.00F, result.getSalary(), "Salary should be 7000.00F");

        assertThrows(EmployeeNotFoundException.class, () -> {
            Employee nonExistentEmployee = new Employee(9999, "Ghost Employee", "Unknown", 0, 0, 0, 0, 0, "0000000000");
            employeeService.updateEmployee(nonExistentEmployee); // Updating a non-existent employee
        }, "Should throw EmployeeNotFoundException for non-existent employee ID");
    }

    @Test
    @Order(6)
    @DisplayName("Check if deleteEmployee() method is declared and working")
    void testDeleteEmployee() throws EmployeeNotFoundException {
        boolean isDeleted = employeeService.deleteEmployee(3333);
        assertTrue(isDeleted, "Employee should be deleted successfully");

        assertThrows(EmployeeNotFoundException.class, () -> {
            employeeService.deleteEmployee(3333); // Deleting the same employee again
        }, "Should throw EmployeeNotFoundException for non-existent employee ID");
    }
}
