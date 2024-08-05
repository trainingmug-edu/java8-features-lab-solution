package com.trainingmug.employee.repository;

import com.trainingmug.employee.domain.Designer;
import com.trainingmug.employee.domain.Developer;
import com.trainingmug.employee.domain.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeRepositoryTest {

    @Test
    @Order(1)
    @DisplayName("Test Collections Initialization in EmployeeRepository Class")
    void testCollectionsInitialization() {
        EmployeeRepository employeeRepository = new EmployeeRepository();

        assertNotNull(employeeRepository.employeeSet, "employeeSet should be initialized.");
        assertTrue(employeeRepository.employeeSet instanceof Set, "employeeSet should be an instance of Set.");

        assertNotNull(employeeRepository.employeeList, "employeeList should be initialized.");
        assertTrue(employeeRepository.employeeList instanceof List, "employeeList should be an instance of List.");

        assertNotNull(employeeRepository.employeeMap, "employeeMap should be initialized.");
        assertTrue(employeeRepository.employeeMap instanceof Map, "employeeMap should be an instance of Map.");
    }

    @Test
    @Order(2)
    @DisplayName("Test Getters Should Be Present in EmployeeRepository Class")
    void testGettersShouldBePresent() {
        EmployeeRepository employeeRepository = new EmployeeRepository();
        Set<Employee> employeeSet = employeeRepository.getEmployeeSet();
        assertNotNull(employeeSet, "getEmployeeSet() should return a non-null Set.");
        assertTrue(employeeSet instanceof Set, "getEmployeeSet() should return an instance of Set.");

        List<Employee> employeeList = employeeRepository.getEmployeeList();
        assertNotNull(employeeList, "getEmployeeList() should return a non-null List.");
        assertTrue(employeeList instanceof List, "getEmployeeList() should return an instance of List.");

        Map<Integer, Employee> employeeMap = employeeRepository.getEmployeeMap();
        assertNotNull(employeeMap, "getEmployeeMap() should return a non-null Map.");
        assertTrue(employeeMap instanceof Map, "getEmployeeMap() should return an instance of Map.");
    }



    @Test
    @Order(3)
    @DisplayName("Test Constructor Initialization with data in EmployeeRepository Class")
    void testConstructorInitialization() {
        EmployeeRepository employeeRepository = new EmployeeRepository();
        Set<Employee> employeeSet = employeeRepository.getEmployeeSet();
        assertNotNull(employeeSet, "employeeSet should be initialized and not null.");
        assertEquals(6, employeeSet.size(), "employeeSet should contain 6 employees.");

        assertTrue(employeeSet.contains(new Employee(3333, "Nancy Davolio", "Devops Engineer", 4569.45F, 280.5F, 535.45F, 326.34F, 12.5F, "00343538343")), "employeeSet should contain Nancy Davolio.");
        assertTrue(employeeSet.contains(new Developer(5555, "David Austin", "Senior Backend Developer", 6579.45F, 332.5F, 629.45F, 398.34F, 9.5F, "01642558343", 5)), "employeeSet should contain David Austin.");
        assertTrue(employeeSet.contains(new Designer(8888, "Daniel Faviet", "Junior UI/UX Designer", 4339.45F, 277.5F, 526.45F, 316.34F, 12.8F, "01243657343", 3)), "employeeSet should contain Daniel Faviet.");

        List<Employee> employeeList = employeeRepository.getEmployeeList();
        assertNotNull(employeeList, "employeeList should be initialized and not null.");
        assertEquals(6, employeeList.size(), "employeeList should contain 6 employees.");

        assertTrue(employeeList.contains(new Employee(3333, "Nancy Davolio", "Devops Engineer", 4569.45F, 280.5F, 535.45F, 326.34F, 12.5F, "00343538343")), "employeeList should contain Nancy Davolio.");
        assertTrue(employeeList.contains(new Developer(5555, "David Austin", "Senior Backend Developer", 6579.45F, 332.5F, 629.45F, 398.34F, 9.5F, "01642558343", 5)), "employeeList should contain David Austin.");
        assertTrue(employeeList.contains(new Designer(8888, "Daniel Faviet", "Junior UI/UX Designer", 4339.45F, 277.5F, 526.45F, 316.34F, 12.8F, "01243657343", 3)), "employeeList should contain Daniel Faviet.");

        Map<Integer, Employee> employeeMap = employeeRepository.getEmployeeMap();
        assertNotNull(employeeMap, "employeeMap should be initialized and not null.");
        assertEquals(6, employeeMap.size(), "employeeMap should contain 6 entries.");

        assertTrue(employeeMap.containsKey(3333), "employeeMap should contain employee with ID 3333.");
        assertTrue(employeeMap.containsKey(5555), "employeeMap should contain employee with ID 5555.");
        assertTrue(employeeMap.containsKey(8888), "employeeMap should contain employee with ID 8888.");
    }

}
