package com.trainingmug.employee.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class InvalidBankAccountExceptionTest {

    @Test
    @DisplayName("Test if InvalidBankAccountException class exists with the correct package")
    void testInvalidBankAccountExceptionClassExists() {
        try {
            Class<?> exceptionClass = Class.forName("com.trainingmug.employee.exception.InvalidBankAccountException");

            assertNotNull(exceptionClass, "Class InvalidBankAccountException should exist");

            Constructor<?> constructor = exceptionClass.getConstructor(String.class);
            assertNotNull(constructor, "Constructor with String argument should exist");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Class not found: com.trainingmug.employee.exception.InvalidBankAccountException", e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Constructor with String argument not found in InvalidBankAccountException", e);
        }
    }

}
