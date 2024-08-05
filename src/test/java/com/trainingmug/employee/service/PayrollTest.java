package com.trainingmug.employee.service;

import com.trainingmug.employee.domain.Employee;
import com.trainingmug.employee.exception.InvalidBankAccountException;
import org.junit.jupiter.api.*;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PayrollTest {

    private Class<?> payrollInterface;

    @BeforeEach
    void setUp() throws ClassNotFoundException {
        payrollInterface = Class.forName("com.trainingmug.employee.service.Payroll");
    }

    @Test
    @Order(1)
    @DisplayName("Check if Payroll interface is declared")
    void testPayrollInterfaceIsDeclared() {
        assertNotNull(payrollInterface, "Payroll interface should be declared");
        assertTrue(payrollInterface.isInterface(), "Payroll should be an interface");
    }

    @Test
    @Order(2)
    @DisplayName("Check if displayProfile(Employee employee) method is declared")
    void testDisplayProfileWithEmployee() throws NoSuchMethodException {
        Method method = payrollInterface.getMethod("displayProfile", Employee.class);
        assertNotNull(method, "Method displayProfile(Employee employee) should be declared");
        assertEquals(Void.TYPE, method.getReturnType(), "Return type should be void");
        assertTrue(Modifier.isPublic(method.getModifiers()), "Method should be public");
    }

    @Test
    @Order(3)
    @DisplayName("Check if calculateNetSalary(Employee employee) method is declared")
    void testCalculateNetSalary() throws NoSuchMethodException {
        Method method = payrollInterface.getMethod("calculateNetSalary", Employee.class);
        assertNotNull(method, "Method calculateNetSalary(Employee employee) should be declared");
        assertEquals(float.class, method.getReturnType(), "Return type should be float");
        assertTrue(Modifier.isPublic(method.getModifiers()), "Method should be public");
    }

    @Test
    @Order(4)
    @DisplayName("Check if calculateNetSalaryAfterIncrement(Employee employee) method is declared")
    void testCalculateNetSalaryAfterIncrement() throws NoSuchMethodException {
        Method method = payrollInterface.getMethod("calculateNetSalaryAfterIncrement", Employee.class);
        assertNotNull(method, "Method calculateNetSalaryAfterIncrement(Employee employee) should be declared");
        assertEquals(float.class, method.getReturnType(), "Return type should be float");
        assertTrue(Modifier.isPublic(method.getModifiers()), "Method should be public");
    }

    @Test
    @Order(5)
    @DisplayName("Check if displayProfile(int empId) method is declared")
    void testDisplayProfileWithEmpId() throws NoSuchMethodException {
        Method method = payrollInterface.getMethod("displayProfile", int.class);
        assertNotNull(method, "Method displayProfile(int empId) should be declared");
        assertEquals(Void.TYPE, method.getReturnType(), "Return type should be void");
        assertTrue(Modifier.isPublic(method.getModifiers()), "Method should be public");
    }

    @Test
    @Order(6)
    @DisplayName("Check if displayProfile(float fromSalaryRange, float toSalaryRange) method is declared")
    void testDisplayProfileWithSalaryRange() throws NoSuchMethodException {
        Method method = payrollInterface.getMethod("displayProfile", float.class, float.class);
        assertNotNull(method, "Method displayProfile(float fromSalaryRange, float toSalaryRange) should be declared");
        assertEquals(Void.TYPE, method.getReturnType(), "Return type should be void");
        assertTrue(Modifier.isPublic(method.getModifiers()), "Method should be public");
    }

    @Test
    @Order(7)
    @DisplayName("Check if processSalary(Employee employee) method is declared with throws clause")
    void testProcessSalary() throws NoSuchMethodException {
        Method method = payrollInterface.getMethod("processSalary", Employee.class);
        assertNotNull(method, "Method processSalary(Employee employee) should be declared");
        assertEquals(boolean.class, method.getReturnType(), "Return type should be boolean");
        assertTrue(Modifier.isPublic(method.getModifiers()), "Method should be public");

        Class<?>[] exceptionTypes = method.getExceptionTypes();
        assertTrue(Arrays.asList(exceptionTypes).contains(InvalidBankAccountException.class),
                "Method processSalary(Employee employee) should throw InvalidBankAccountException");
    }
}
