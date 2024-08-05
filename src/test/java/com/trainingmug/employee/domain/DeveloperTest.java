package com.trainingmug.employee.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

public class DeveloperTest {

    @Test
    @Order(1)
    @DisplayName("Test Developer Constructor Presence and Super Constructor Invocation")
    public void testDeveloperConstructor() {
        try {
            Class<?> developerClass = Class.forName("com.trainingmug.employee.domain.Developer");

            Constructor<?> constructor = developerClass.getConstructor(
                    long.class, String.class, String.class, float.class, float.class,
                    float.class, float.class, float.class,String.class, int.class
            );

            assertNotNull(constructor, "Constructor should be present in Developer class");

            Developer developer = (Developer) constructor.newInstance(
                    1234L, "Jane Doe", "Senior Developer", 5000.0f, 300.0f,
                    150.0f, 100.0f, 10.0f, "1234567890", 5
            );

            assertEquals(1234L, developer.getEmpId(), "Employee ID should be set correctly");
            assertEquals("Jane Doe", developer.getName(), "Name should be set correctly");
            assertEquals("Senior Developer", developer.getDesignation(), "Designation should be set correctly");
            assertEquals(5000.0f, developer.getGrossSalary(), "Gross Salary should be set correctly");
            assertEquals(300.0f, developer.getTravellingAllowances(), "Travelling Allowances should be set correctly");
            assertEquals(150.0f, developer.getFederalTax(), "Federal Tax should be set correctly");
            assertEquals(100.0f, developer.getStateTax(), "State Tax should be set correctly");
            assertEquals(10.0f, developer.getIncrementPercentage(), "Increment Percentage should be set correctly");
            assertEquals("1234567890", developer.getBankAccountNo(), "BankAccountNo should be set correctly");
            assertEquals(5, developer.getNoOfProjects(), "No of Projects should be set correctly");

        } catch (Exception e) {
            fail("Exception occurred during constructor testing: " + e.getMessage());
        }
    }

    @Test
    @Order(2)
    @DisplayName("Test if Getter and Setter is Generated in Developer Class")
    void testGettersAndSettersInDeveloperClass() {
        Developer developer = new Developer();

        developer.setNoOfProjects(4);
        assertEquals(4, developer.getNoOfProjects(), "The Developer number of projects should be correctly set and retrieved.");

    }

    @Test
    @Order(3)
    @DisplayName("Test if CalculateNetSalary Method Presence in Developer Class")
    void testCalculateNetSalaryMethodPresence() {
        try {
            Class<?> developerClass = Class.forName("com.trainingmug.employee.domain.Developer");

            Method calculateNetSalaryMethod = developerClass.getMethod("calculateNetSalary");

            assertNotNull(calculateNetSalaryMethod, "The 'calculateNetSalary' method should be present in the Developer class.");
            assertEquals(float.class, calculateNetSalaryMethod.getReturnType(), "The return type of 'calculateNetSalary' should be float.");
            assertArrayEquals(new Class<?>[]{}, calculateNetSalaryMethod.getParameterTypes(), "The 'calculateNetSalary' method should have no parameters.");

        } catch (ClassNotFoundException e) {
            fail("Developer class not found. Ensure the class is correctly defined.");
        } catch (NoSuchMethodException e) {
            fail("The 'calculateNetSalary' method is missing from Developer class. Ensure the method is defined.");
        }
    }

    @Test
    @Order(4)
    @DisplayName("Test CalculateNetSalary Method Implementation in Developer Class")
    void testCalculateNetSalaryImplementation() {
        Developer developer = new Developer();
        developer.setEmpId(1);
        developer.setName("Alice");
        developer.setDesignation("Designer");
        developer.setGrossSalary(5000.0f);
        developer.setFederalTax(200.0f);
        developer.setStateTax(100.0f);

        float expectedNetSalary = 5000.0f - 200.0f - 100.0f;
        float actualNetSalary = developer.calculateNetSalary();

        assertEquals(expectedNetSalary, actualNetSalary, 0.01f,
                "The 'calculateNetSalary' method should correctly calculate the net salary.");
    }


    @Test
    @Order(5)
    @DisplayName("Test if CalculateNetSalaryAfterIncrement Method Presence in Developer Class")
    void testCalculateNetSalaryAfterIncrementMethodPresence() {
        try {
            Class<?> developerClass = Class.forName("com.trainingmug.employee.domain.Developer");

            Method calculateNetSalaryAfterIncrementMethod = developerClass.getMethod("calculateNetSalaryAfterIncrement");

            assertNotNull(calculateNetSalaryAfterIncrementMethod, "The 'calculateNetSalaryAfterIncrement' method should be present in the Developer class.");
            assertEquals(float.class, calculateNetSalaryAfterIncrementMethod.getReturnType(), "The return type of 'calculateNetSalaryAfterIncrement' should be float.");
            assertArrayEquals(new Class<?>[]{}, calculateNetSalaryAfterIncrementMethod.getParameterTypes(), "The 'calculateNetSalaryAfterIncrement' method should have no parameters.");

        } catch (ClassNotFoundException e) {
            fail("Developer class not found. Ensure the class is correctly defined.");
        } catch (NoSuchMethodException e) {
            fail("The 'calculateNetSalaryAfterIncrement' method is missing from Developer class. Ensure the method is defined.");
        }
    }

    @Test
    @Order(6)
    @DisplayName("Test CalculateNetSalaryAfterIncrement Method Implementation in Developer Class")
    void testCalculateNetSalaryAfterIncrementImplementation() {
        Developer developer = new Developer();
        developer.setEmpId(1);
        developer.setName("Alice");
        developer.setDesignation("Designer");
        developer.setGrossSalary(5000.0f);
        developer.setFederalTax(200.0f);
        developer.setStateTax(100.0f);
        developer.setIncrementPercentage(10.0f);

        float netSalary = developer.calculateNetSalary();
        float expectedNetSalary = netSalary + (netSalary * 10.0f / 100.0f);
        float actualNetSalaryAfterIncrement = developer.calculateNetSalaryAfterIncrement();

        assertEquals(expectedNetSalary, actualNetSalaryAfterIncrement, 0.01f,
                "The 'calculateNetSalaryAfterIncrement' method should correctly calculate the net salary after increment.");
    }

}
