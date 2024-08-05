package com.trainingmug.employee.service;

import com.trainingmug.employee.domain.Employee;
import com.trainingmug.employee.exception.InvalidBankAccountException;

public interface Payroll {

    void displayProfile(Employee employee);
    float calculateNetSalary(Employee employee);
    float calculateNetSalaryAfterIncrement(Employee employee);
    void displayProfile(int empId);
    void displayProfile(float fromSalaryRange,float toSalaryRange);
    //void displayProfile(String department);
    boolean processSalary(Employee employee) throws InvalidBankAccountException;
}
