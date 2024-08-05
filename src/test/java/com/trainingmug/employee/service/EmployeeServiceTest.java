package com.trainingmug.employee.service;

import com.trainingmug.employee.domain.Employee;
import com.trainingmug.employee.exception.EmployeeAlreadyExistsException;
import com.trainingmug.employee.exception.EmployeeNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

class EmployeeServiceTest {

    @Test
    @Order(1)
    @DisplayName("Check if interface EmployeeService is present")
    void testEmployeeServiceInterfacePresent() {
        try {
            Class<?> employeeServiceClass = Class.forName("com.trainingmug.employee.service.EmployeeService");
            assertNotNull(employeeServiceClass, "EmployeeService interface should be present");
        } catch (ClassNotFoundException e) {
            fail("EmployeeService interface not found");
        }
    }

    @Test
    @Order(2)
    @DisplayName("Check if method getEmployees() is present with correct return type and parameters")
    void testGetEmployeesMethod() {
        try {
            Method method = EmployeeService.class.getMethod("getEmployees");
            assertNotNull(method, "Method getEmployees() should be present");
            if (!List.class.isAssignableFrom(method.getReturnType())) {
                fail("Return type of getEmployees() should be List");
            }
            if (method.getParameterCount() != 0) {
                fail("getEmployees() should have no parameters");
            }
        } catch (NoSuchMethodException e) {
            fail("Method getEmployees() not found");
        }
    }

    @Test
    @Order(3)
    @DisplayName("Check if method findEmployeeById(int empId) is present with correct return type and exceptions")
    void testFindEmployeeByIdMethod() {
        try {
            Method method = EmployeeService.class.getMethod("findEmployeeById", int.class);
            assertNotNull(method, "Method findEmployeeById(int empId) should be present");
            if (!Employee.class.isAssignableFrom(method.getReturnType())) {
                fail("Return type of findEmployeeById() should be Employee");
            }
            if (method.getParameterCount() != 1 || method.getParameterTypes()[0] != int.class) {
                fail("findEmployeeById() should have one int parameter");
            }
            if (!method.getExceptionTypes()[0].equals(EmployeeNotFoundException.class)) {
                fail("findEmployeeById() should throw EmployeeNotFoundException");
            }
        } catch (NoSuchMethodException e) {
            fail("Method findEmployeeById(int empId) not found");
        }
    }

    @Test
    @Order(4)
    @DisplayName("Check if method addEmployee(Employee employee) is present with correct return type and exceptions")
    void testAddEmployeeMethod() {
        try {
            Method method = EmployeeService.class.getMethod("addEmployee", Employee.class);
            assertNotNull(method, "Method addEmployee(Employee employee) should be present");
            if (!Employee.class.isAssignableFrom(method.getReturnType())) {
                fail("Return type of addEmployee() should be Employee");
            }
            if (method.getParameterCount() != 1 || method.getParameterTypes()[0] != Employee.class) {
                fail("addEmployee() should have one Employee parameter");
            }
            if (!method.getExceptionTypes()[0].equals(EmployeeAlreadyExistsException.class)) {
                fail("addEmployee() should throw EmployeeAlreadyExistsException");
            }
        } catch (NoSuchMethodException e) {
            fail("Method addEmployee(Employee employee) not found");
        }
    }

    @Test
    @Order(5)
    @DisplayName("Check if method updateEmployee(Employee employee) is present with correct return type and exceptions")
    void testUpdateEmployeeMethod() {
        try {
            Method method = EmployeeService.class.getMethod("updateEmployee", Employee.class);
            assertNotNull(method, "Method updateEmployee(Employee employee) should be present");
            if (!Employee.class.isAssignableFrom(method.getReturnType())) {
                fail("Return type of updateEmployee() should be Employee");
            }
            if (method.getParameterCount() != 1 || method.getParameterTypes()[0] != Employee.class) {
                fail("updateEmployee() should have one Employee parameter");
            }
            if (!method.getExceptionTypes()[0].equals(EmployeeNotFoundException.class)) {
                fail("updateEmployee() should throw EmployeeNotFoundException");
            }
        } catch (NoSuchMethodException e) {
            fail("Method updateEmployee(Employee employee) not found");
        }
    }

    @Test
    @Order(6)
    @DisplayName("Check if method deleteEmployee(int empId) is present with correct return type and exceptions")
    void testDeleteEmployeeMethod() {
        try {
            Method method = EmployeeService.class.getMethod("deleteEmployee", int.class);
            assertNotNull(method, "Method deleteEmployee(int empId) should be present");
            if (method.getReturnType() != boolean.class) {
                fail("Return type of deleteEmployee() should be boolean");
            }
            if (method.getParameterCount() != 1 || method.getParameterTypes()[0] != int.class) {
                fail("deleteEmployee() should have one int parameter");
            }
            if (!method.getExceptionTypes()[0].equals(EmployeeNotFoundException.class)) {
                fail("deleteEmployee() should throw EmployeeNotFoundException");
            }
        } catch (NoSuchMethodException e) {
            fail("Method deleteEmployee(int empId) not found");
        }
    }
}


