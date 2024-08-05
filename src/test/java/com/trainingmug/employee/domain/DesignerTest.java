package com.trainingmug.employee.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

public class DesignerTest {

    @Test
    @Order(1)
    @DisplayName("Test Designer Constructor Presence and Super Constructor Invocation")
    public void testDesignerConstructor() {
        try {
            Class<?> designerClass = Class.forName("com.trainingmug.employee.domain.Designer");

            Constructor<?> constructor = designerClass.getConstructor(
                    long.class, String.class, String.class, float.class, float.class,
                    float.class, float.class, float.class, String.class, int.class
            );

            assertNotNull(constructor, "Constructor should be present in Designer class");

            Designer designer = (Designer) constructor.newInstance(
                    1234L, "Jane Doe", "Senior Developer", 5000.0f, 300.0f,
                    150.0f, 100.0f, 10.0f, "1234567890", 5
            );

            assertEquals(1234L, designer.getEmpId(), "Employee ID should be set correctly");
            assertEquals("Jane Doe", designer.getName(), "Name should be set correctly");
            assertEquals("Senior Developer", designer.getDesignation(), "Designation should be set correctly");
            assertEquals(5000.0f, designer.getGrossSalary(), "Gross Salary should be set correctly");
            assertEquals(300.0f, designer.getTravellingAllowances(), "Travelling Allowances should be set correctly");
            assertEquals(150.0f, designer.getFederalTax(), "Federal Tax should be set correctly");
            assertEquals(100.0f, designer.getStateTax(), "State Tax should be set correctly");
            assertEquals(10.0f, designer.getIncrementPercentage(), "Increment Percentage should be set correctly");
            assertEquals("1234567890", designer.getBankAccountNo(), "BankAccountNo should be set correctly");
            assertEquals(5, designer.getNoOfWebsites(), "No of Websites should be set correctly");

        } catch (Exception e) {
            fail("Exception occurred during constructor testing: " + e.getMessage());
        }
    }

    @Test
    @Order(2)
    @DisplayName("Test if Getter and Setter is Generated in Designer Class")
    void testGettersAndSettersInDesignerClass() {
        Designer designer = new Designer();

        designer.setNoOfWebsites(4);
        assertEquals(4, designer.getNoOfWebsites(), "The designer number of websites should be correctly set and retrieved.");

    }

    @Test
    @Order(3)
    @DisplayName("Test if CalculateNetSalary Method Presence in Designer Class")
    void testCalculateNetSalaryMethodPresence() {
        try {
            Class<?> designerClass = Class.forName("com.trainingmug.employee.domain.Designer");

            Method calculateNetSalaryMethod = designerClass.getMethod("calculateNetSalary");

            assertNotNull(calculateNetSalaryMethod, "The 'calculateNetSalary' method should be present in the Designer class.");
            assertEquals(float.class, calculateNetSalaryMethod.getReturnType(), "The return type of 'calculateNetSalary' should be float.");
            assertArrayEquals(new Class<?>[]{}, calculateNetSalaryMethod.getParameterTypes(), "The 'calculateNetSalary' method should have no parameters.");

        } catch (ClassNotFoundException e) {
            fail("Designer class not found. Ensure the class is correctly defined.");
        } catch (NoSuchMethodException e) {
            fail("The 'calculateNetSalary' method is missing from Designer class. Ensure the method is defined.");
        }
    }

    @Test
    @Order(4)
    @DisplayName("Test CalculateNetSalary Method Implementation in Designer Class")
    void testCalculateNetSalaryImplementation() {
        Designer designer = new Designer();
        designer.setEmpId(1);
        designer.setName("Alice");
        designer.setDesignation("Designer");
        designer.setGrossSalary(5000.0f);
        designer.setFederalTax(200.0f);
        designer.setStateTax(100.0f);

        float expectedNetSalary = 5000.0f - 200.0f - 100.0f;
        float actualNetSalary = designer.calculateNetSalary();

        assertEquals(expectedNetSalary, actualNetSalary, 0.01f,
                "The 'calculateNetSalary' method should correctly calculate the net salary.");
    }


    @Test
    @Order(5)
    @DisplayName("Test if CalculateNetSalaryAfterIncrement Method Presence in Designer Class")
    void testCalculateNetSalaryAfterIncrementMethodPresence() {
        try {
            Class<?> designerClass = Class.forName("com.trainingmug.employee.domain.Designer");

            Method calculateNetSalaryAfterIncrementMethod = designerClass.getMethod("calculateNetSalaryAfterIncrement");

            assertNotNull(calculateNetSalaryAfterIncrementMethod, "The 'calculateNetSalaryAfterIncrement' method should be present in the Designer class.");
            assertEquals(float.class, calculateNetSalaryAfterIncrementMethod.getReturnType(), "The return type of 'calculateNetSalaryAfterIncrement' should be float.");
            assertArrayEquals(new Class<?>[]{}, calculateNetSalaryAfterIncrementMethod.getParameterTypes(), "The 'calculateNetSalaryAfterIncrement' method should have no parameters.");

        } catch (ClassNotFoundException e) {
            fail("Designer class not found. Ensure the class is correctly defined.");
        } catch (NoSuchMethodException e) {
            fail("The 'calculateNetSalaryAfterIncrement' method is missing from Designer class. Ensure the method is defined.");
        }
    }

    @Test
    @Order(6)
    @DisplayName("Test CalculateNetSalaryAfterIncrement Method Implementation in Designer Class")
    void testCalculateNetSalaryAfterIncrementImplementation() {
        Designer designer = new Designer();
        designer.setEmpId(1);
        designer.setName("Alice");
        designer.setDesignation("Designer");
        designer.setGrossSalary(5000.0f);
        designer.setFederalTax(200.0f);
        designer.setStateTax(100.0f);
        designer.setIncrementPercentage(10.0f);

        float netSalary = designer.calculateNetSalary();
        float expectedNetSalary = netSalary + (netSalary * 10.0f / 100.0f);
        float actualNetSalaryAfterIncrement = designer.calculateNetSalaryAfterIncrement();

        assertEquals(expectedNetSalary, actualNetSalaryAfterIncrement, 0.01f,
                "The 'calculateNetSalaryAfterIncrement' method should correctly calculate the net salary after increment.");
    }

}
