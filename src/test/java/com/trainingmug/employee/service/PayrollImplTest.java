package com.trainingmug.employee.service;

import com.trainingmug.employee.domain.Employee;
import com.trainingmug.employee.exception.InvalidBankAccountException;
import org.junit.jupiter.api.*;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PayrollImplTest {

    private PayrollImpl payrollImpl;

    @BeforeEach
    void setUp() {
        payrollImpl = new PayrollImpl();
    }

    @Test
    @Order(1)
    @DisplayName("Test if PayrollImpl class is created and implements Payroll interface")
    void testPayrollImplClassIsCreated() {
        assertNotNull(payrollImpl, "PayrollImpl class should be instantiated");
        assertTrue(payrollImpl instanceof Payroll, "PayrollImpl should implement Payroll interface");
    }

    @Test
    @Order(2)
    @DisplayName("Test if overridden methods are declared with correct properties")
    void testOverriddenMethodsDeclaration() throws NoSuchMethodException {
        Method displayProfileEmployee = PayrollImpl.class.getMethod("displayProfile", Employee.class);
        assertNotNull(displayProfileEmployee, "Method displayProfile(Employee) should be declared");
        assertEquals(Void.TYPE, displayProfileEmployee.getReturnType(), "Return type should be void");
        assertTrue(Modifier.isPublic(displayProfileEmployee.getModifiers()), "Method should be public");

        Method calculateNetSalary = PayrollImpl.class.getMethod("calculateNetSalary", Employee.class);
        assertNotNull(calculateNetSalary, "Method calculateNetSalary(Employee) should be declared");
        assertEquals(float.class, calculateNetSalary.getReturnType(), "Return type should be float");
        assertTrue(Modifier.isPublic(calculateNetSalary.getModifiers()), "Method should be public");

        Method calculateNetSalaryAfterIncrement = PayrollImpl.class.getMethod("calculateNetSalaryAfterIncrement", Employee.class);
        assertNotNull(calculateNetSalaryAfterIncrement, "Method calculateNetSalaryAfterIncrement(Employee) should be declared");
        assertEquals(float.class, calculateNetSalaryAfterIncrement.getReturnType(), "Return type should be float");
        assertTrue(Modifier.isPublic(calculateNetSalaryAfterIncrement.getModifiers()), "Method should be public");

        Method displayProfileEmpId = PayrollImpl.class.getMethod("displayProfile", int.class);
        assertNotNull(displayProfileEmpId, "Method displayProfile(int) should be declared");
        assertEquals(Void.TYPE, displayProfileEmpId.getReturnType(), "Return type should be void");
        assertTrue(Modifier.isPublic(displayProfileEmpId.getModifiers()), "Method should be public");

        Method displayProfileSalaryRange = PayrollImpl.class.getMethod("displayProfile", float.class, float.class);
        assertNotNull(displayProfileSalaryRange, "Method displayProfile(float, float) should be declared");
        assertEquals(Void.TYPE, displayProfileSalaryRange.getReturnType(), "Return type should be void");
        assertTrue(Modifier.isPublic(displayProfileSalaryRange.getModifiers()), "Method should be public");

        Method processSalary = PayrollImpl.class.getMethod("processSalary", Employee.class);
        assertNotNull(processSalary, "Method processSalary(Employee) should be declared");
        assertEquals(boolean.class, processSalary.getReturnType(), "Return type should be boolean");
        assertTrue(Modifier.isPublic(processSalary.getModifiers()), "Method should be public");

        Class<?>[] exceptionTypes = processSalary.getExceptionTypes();
        assertTrue(Arrays.asList(exceptionTypes).contains(InvalidBankAccountException.class),
                "Method processSalary(Employee) should throw InvalidBankAccountException");
    }


}
