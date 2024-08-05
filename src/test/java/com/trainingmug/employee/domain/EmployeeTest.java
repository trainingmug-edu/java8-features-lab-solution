package com.trainingmug.employee.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {

    @Test
    @Order(1)
    @DisplayName("Test Employee class should be present in com.trainingmug.employee package")
    void testEmployeeClassShouldBePresent() {
        assertDoesNotThrow(() -> {
            Class.forName("com.trainingmug.employee.domain.Employee");
        }, "Employee class should be present");
    }


    @Test
    @Order(2)
    @DisplayName("Test Instance Properties Presence And Modifiers in Employee Class")
    void testInstancePropertiesPresenceAndModifiers() {
        verifyPropertyPresenceAndModifiers("empId", long.class, Modifier.PRIVATE);
        verifyPropertyPresenceAndModifiers("name", String.class, Modifier.PRIVATE);
        verifyPropertyPresenceAndModifiers("designation", String.class, Modifier.PRIVATE);
        verifyPropertyPresenceAndModifiers("grossSalary", float.class, Modifier.PRIVATE);
        verifyPropertyPresenceAndModifiers("travellingAllowances", float.class, Modifier.PRIVATE);
        verifyPropertyPresenceAndModifiers("federalTax", float.class, Modifier.PRIVATE);
        verifyPropertyPresenceAndModifiers("stateTax", float.class, Modifier.PRIVATE);
        verifyPropertyPresenceAndModifiers("incrementPercentage", float.class, Modifier.PRIVATE );
        verifyPropertyPresenceAndModifiers("bankAccountNo", String.class, Modifier.PRIVATE);

        verifyPropertyPresenceAndModifiers("companyName", String.class, Modifier.PRIVATE | Modifier.STATIC);
        verifyPropertyPresenceAndModifiers("companyContactNo", String.class, Modifier.PRIVATE | Modifier.STATIC);
        verifyPropertyPresenceAndModifiers("employeeCount", int.class, Modifier.PRIVATE | Modifier.STATIC);

    }

    private void verifyPropertyPresenceAndModifiers(String fieldName, Class<?> expectedType, int expectedModifiers) {
        try {
            Class<?> clazz = Class.forName("com.trainingmug.employee.domain.Employee");

            Field field = clazz.getDeclaredField(fieldName);

            assertNotNull(field, "The '" + fieldName + "' field should be present in the " + clazz.getSimpleName() + " class.");
            assertEquals(expectedType, field.getType(), "The '" + fieldName + "' field should be of type " + expectedType.getSimpleName() + ".");
            assertEquals(expectedModifiers, field.getModifiers(), "The '" + fieldName + "' field should have the correct modifiers.");
        } catch (ClassNotFoundException e) {
            fail("Class " + "com.trainingmug.employee.domain.Employee" + " not found.");
        } catch (NoSuchFieldException e) {
            fail("Field '" + fieldName + "' not found in class " + "com.trainingmug.employee.domain.Employee" + ".");
        }
    }

    @Test
    @Order(3)
    @DisplayName("Should have Employee() no-arg constructor")
    public void testEmployeeConstructor() {

        try {
            Class<?> clazz = Class.forName("com.trainingmug.employee.domain.Employee");
            Constructor<?> noArgConstructor = clazz.getDeclaredConstructor();
            assertNotNull(noArgConstructor, "Employee() No-arg constructor should be present");
            assertTrue(Modifier.isPublic(noArgConstructor.getModifiers()), "No-arg constructor should be public");
        } catch (ClassNotFoundException e) {
            fail("Class " + "com.trainingmug.employee.d.Employee" + " does not exist");
        } catch (NoSuchMethodException e) {
            fail("Employee() No-arg constructor not found in class " + "com.trainingmug.employee.d.Employee");
        }
    }

    @Test
    @Order(4)
    @DisplayName("Test Employee constructor initialization with parameters")
    void testEmployeeConstructorInitialization() {
        long empId = 1234;
        String name = "John Doe";
        String designation = "Software Engineer";
        float grossSalary = 5000.0F;
        float travellingAllowances = 200.0F;
        float federalTax = 300.0F;
        float stateTax = 100.0F;
        float incrementPercentage = 5.0F;
        String bankAccountNo = "1234567890";

        int initialEmployeeCount = Employee.getEmployeeCount();

        Employee employee = new Employee(empId, name, designation, grossSalary, travellingAllowances,
                federalTax, stateTax, incrementPercentage, bankAccountNo);

        assertAll("Employee Constructor",
                () -> assertEquals(empId, employee.getEmpId(), "Employee ID should match"),
                () -> assertEquals(name, employee.getName(), "Name should match"),
                () -> assertEquals(designation, employee.getDesignation(), "Designation should match"),
                () -> assertEquals(grossSalary, employee.getGrossSalary(), "Gross Salary should match"),
                () -> assertEquals(travellingAllowances, employee.getTravellingAllowances(), "Travelling Allowances should match"),
                () -> assertEquals(federalTax, employee.getFederalTax(), "Federal Tax should match"),
                () -> assertEquals(stateTax, employee.getStateTax(), "State Tax should match"),
                () -> assertEquals(incrementPercentage, employee.getIncrementPercentage(), "Increment Percentage should match"),
                () -> assertEquals(bankAccountNo, employee.getBankAccountNo(), "Bank Account No should match")
        );

        assertEquals(initialEmployeeCount + 1, Employee.getEmployeeCount(), "Employee count should be incremented");
    }

    @Test
    @Order(5)
    @DisplayName("Test if Getter and Setter is Generated in Employee Class")
    void testGettersAndSetters() {
        Employee employee = new Employee();

        employee.setEmpId(12345L);
        assertEquals(12345L, employee.getEmpId(), "The employee ID should be correctly set and retrieved.");

        employee.setName("John Doe");
        assertEquals("John Doe", employee.getName(), "The employee name should be correctly set and retrieved.");

        employee.setDesignation("Developer");
        assertEquals("Developer", employee.getDesignation(), "The employee designation should be correctly set and retrieved.");

        employee.setGrossSalary(75000.0f);
        assertEquals(75000.0f, employee.getGrossSalary(), "The employee gross salary should be correctly set and retrieved.");

        employee.setTravellingAllowances(5000.0f);
        assertEquals(5000.0f, employee.getTravellingAllowances(), "The employee travelling allowances should be correctly set and retrieved.");

        employee.setFederalTax(1500.0f);
        assertEquals(1500.0f, employee.getFederalTax(), "The employee federal tax should be correctly set and retrieved.");

        employee.setStateTax(750.0f);
        assertEquals(750.0f, employee.getStateTax(), "The employee state tax should be correctly set and retrieved.");

        employee.setIncrementPercentage(5.0f);
        assertEquals(5.0f, employee.getIncrementPercentage(), "The employee increment percentage should be correctly set and retrieved.");

        employee.setBankAccountNo("123456789");
        assertEquals("123456789", employee.getBankAccountNo(), "The employee bank account number should be correctly set and retrieved.");

        Employee.setCompanyName("ABC Corp");
        assertEquals("ABC Corp", Employee.getCompanyName(), "The company name should be correctly set and retrieved.");

        Employee.setCompanyContactNo("123-456-7890");
        assertEquals("123-456-7890", Employee.getCompanyContactNo(), "The company contact number should be correctly set and retrieved.");

        Employee.setEmployeeCount(100);
        assertEquals(100, Employee.getEmployeeCount(), "The employee count should be correctly set and retrieved.");
    }



    @Test
    @Order(6)
    @DisplayName("Test HashCode Method Presence in Employee class")
    void testHashCodeMethodPresence() {
        try {
            Class<?> employeeClass = Class.forName("com.trainingmug.employee.domain.Employee");

            Method hashCodeMethod = employeeClass.getMethod("hashCode");

            assertNotNull(hashCodeMethod, "The 'hashCode' method should be present in the Employee class.");
            assertEquals(int.class, hashCodeMethod.getReturnType(), "The return type of 'hashCode' should be int.");

        } catch (ClassNotFoundException e) {
            fail("Employee class not found. Ensure the class is correctly defined.");
        } catch (NoSuchMethodException e) {
            fail("The 'hashCode' method is missing from Employee class. Ensure the method is overridden.");
        }
    }

    @Test
    @Order(7)
    @DisplayName("Test HashCode Implementation in Employee class")
    void testHashCodeImplementation() {
        Employee emp1 = new Employee();
        emp1.setEmpId(1);
        emp1.setName("John Doe");
        emp1.setDesignation("Developer");
        emp1.setGrossSalary(5000.0f);
        emp1.setTravellingAllowances(300.0f);
        emp1.setFederalTax(200.0f);
        emp1.setStateTax(100.0f);
        emp1.setIncrementPercentage(5.0f);
        emp1.setBankAccountNo("12345678901");

        Employee emp2 = new Employee();
        emp2.setEmpId(1);
        emp2.setName("John Doe");
        emp2.setDesignation("Developer");
        emp2.setGrossSalary(5000.0f);
        emp2.setTravellingAllowances(300.0f);
        emp2.setFederalTax(200.0f);
        emp2.setStateTax(100.0f);
        emp2.setIncrementPercentage(5.0f);
        emp2.setBankAccountNo("12345678901");

        assertEquals(emp1.hashCode(), emp2.hashCode(),
                "The hashCode of two identical Employee objects should be equal.");
    }

    @Test
    @Order(8)
    @DisplayName("Test Equals Method Presence in Employee Class")
    void testEqualsMethodPresence() {
        try {
            Class<?> employeeClass = Class.forName("com.trainingmug.employee.domain.Employee");

            Method equalsMethod = employeeClass.getMethod("equals", Object.class);

            assertNotNull(equalsMethod, "The 'equals' method should be present in the Employee class.");
            assertEquals(boolean.class, equalsMethod.getReturnType(), "The return type of 'equals' should be boolean.");
            assertArrayEquals(new Class<?>[]{Object.class}, equalsMethod.getParameterTypes(),
                    "The 'equals' method should have a single parameter of type Object.");

        } catch (ClassNotFoundException e) {
            fail("Employee class not found. Ensure the class is correctly defined.");
        } catch (NoSuchMethodException e) {
            fail("The 'equals' method is missing from Employee class. Ensure the method is overridden.");
        }
    }

    @Test
    @Order(9)
    @DisplayName("Test Equals Implementation in Employee Class")
    void testEqualsImplementation() {
        Employee emp1 = new Employee();
        emp1.setEmpId(1);
        emp1.setName("John Doe");
        emp1.setDesignation("Developer");
        emp1.setGrossSalary(5000.0f);
        emp1.setTravellingAllowances(300.0f);
        emp1.setFederalTax(200.0f);
        emp1.setStateTax(100.0f);
        emp1.setIncrementPercentage(5.0f);
        emp1.setBankAccountNo("12345678901");

        Employee emp2 = new Employee();
        emp2.setEmpId(1);
        emp2.setName("John Doe");
        emp2.setDesignation("Developer");
        emp2.setGrossSalary(5000.0f);
        emp2.setTravellingAllowances(300.0f);
        emp2.setFederalTax(200.0f);
        emp2.setStateTax(100.0f);
        emp2.setIncrementPercentage(5.0f);
        emp2.setBankAccountNo("12345678901");

        Employee emp3 = new Employee();
        emp3.setEmpId(2);
        emp3.setName("Jane Doe");
        emp3.setDesignation("Designer");
        emp3.setGrossSalary(4500.0f);
        emp3.setTravellingAllowances(250.0f);
        emp3.setFederalTax(180.0f);
        emp3.setStateTax(90.0f);
        emp3.setIncrementPercentage(4.0f);
        emp3.setBankAccountNo("09876543210");

        assertEquals(emp1, emp2, "Two identical Employee objects should be equal.");
        assertNotEquals(emp1, emp3, "Two different Employee objects should not be equal.");
        assertNotEquals(null, emp1, "Employee object should not be equal to null.");
        assertNotEquals(emp1, new Object(), "Employee object should not be equal to an object of different class.");
    }

    @Test
    @Order(10)
    @DisplayName("Test DisplayProfile Method Presence And Implementation in Employee Class")
    void testDisplayProfileMethodPresenceAndImplementation() {
        verifyMethodPresenceAndImplementation(Employee.class, "displayProfile", void.class);

        Employee employee = new Employee();
        employee.setEmpId(12345);
        employee.setName("John Doe");
        employee.setDesignation("Software Engineer");
        employee.setGrossSalary(100000);
        employee.setTravellingAllowances(5000);
        employee.setFederalTax(15000);
        employee.setStateTax(5000);
        employee.setBankAccountNo("12345678901");
        employee.setIncrementPercentage(10);

        assertDoesNotThrow(employee::displayProfile, "The displayProfile method should execute without throwing an exception.");
    }

    @Test
    @Order(11)
    @DisplayName("Test DisplayCompanyInfo Method Presence And Implementation in  Employee Class")
    void testDisplayCompanyInfoMethodPresenceAndImplementation() {
        verifyMethodPresenceAndImplementation(Employee.class, "displayCompanyInfo", void.class);

        assertDoesNotThrow(Employee::displayCompanyInfo, "The displayCompanyInfo method should execute without throwing an exception.");
    }

    private void verifyMethodPresenceAndImplementation(Class<?> clazz, String methodName, Class<?> expectedReturnType, Class<?>... parameterTypes) {
        try {
            Method method = clazz.getDeclaredMethod(methodName, parameterTypes);

            assertNotNull(method, "The method '" + methodName + "' should be present in the " + clazz.getSimpleName() + " class.");
            assertEquals(expectedReturnType, method.getReturnType(), "The return type of '" + methodName + "' should be " + expectedReturnType.getSimpleName() + ".");

            assertTrue(Modifier.isPublic(method.getModifiers()), "The method '" + methodName + "' should be public.");
        } catch (NoSuchMethodException e) {
            fail("Method '" + methodName + "' not found in class " + clazz.getSimpleName() + ".");
        }
    }

}
