## Java 8 Features

### Objective

The objective of this module is to gain hands-on experience with the following Java 8 features:

1. Functional Programming
2. Lambda Expressions
3. Streams
4. Optional Class

---

## Working with Java 8 Features

### Objectives

1. Understand and implement Lambda Expressions in Java.
2. Understand and implement Streams for processing large datasets.
3. Work with the Optional Class.

### Problem Statement

Process the list of Employees based on the following business requirements:
- Display each employee profile.
- Find an employee based on ID and display their profile. If no employee exists with the specified ID, throw `EmployeeNotFoundException`.
- Add a new employee to the list. If the employee already exists, throw `EmployeeAlreadyExistsException`.
- Group all employees based on their department, using their designation to filter since there is no department property.

### Tasks

1. **Remove Duplicates**: Remove duplicate employee objects from `employeeList` added in the previous Lab.

2. **Create Exception Classes**:
   - Under the `com.digisafari.exception` package, create `EmployeeNotFoundException` and `EmployeeAlreadyExistsException` classes.
   - Use argument constructors for both these Exception classes with the appropriate exception message.

3. **Create EmployeeService Interface**:
   - Define the following methods:
     ```java
     public List<Employee> getEmployees();
     public Employee findEmployeeById(int empId) throws EmployeeNotFoundException;
     public Employee addEmployee(Employee employee) throws EmployeeAlreadyExistsException;
     public Employee updateEmployee(Employee employee) throws EmployeeNotFoundException;
     public boolean deleteEmployee(int empId) throws EmployeeNotFoundException;
     ```

4. **Implement EmployeeService Interface**:
   - Create a class named `EmployeeServiceImpl` that implements the `EmployeeService` interface.
   - Create a property `employeeRepository` of type `EmployeeRepository`.
   - Initialize the `employeeRepository` property in a no-arg constructor.
   - Override all the abstract methods with appropriate logic.

5. **Test Implementation**:
   - In `CollectionTest.java`, create an instance of `EmployeeServiceImpl` and test all the methods by passing the appropriate data.

---

This README provides an overview of exercises focused on Java 8 features, specifically Lambda Expressions, Streams, and the Optional Class. Follow the tasks to implement the required functionality and ensure proper exception handling and data processing.
