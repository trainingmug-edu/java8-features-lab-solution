package com.trainingmug.employee.service;

import com.trainingmug.employee.domain.Employee;
import com.trainingmug.employee.exception.InvalidBankAccountException;

public class PayrollImpl implements Payroll {

    @Override
    public void displayProfile(Employee employee) {
        try {
            employee.displayProfile();
        } catch (NullPointerException exception) {
            System.out.println("Employee object shouldn't be null");
        } catch (Exception e) {
            System.out.println("Some internal error occured . Please try again !");
        }
    }

    @Override
    public float calculateNetSalary(Employee employee) {
        try {
            return employee.calculateNetSalary();
        } catch (NullPointerException exception) {
            System.out.println("Employee object shouldn't be null");
            return 0;
        } catch (Exception e) {
            System.out.println("Some internal error occured . Please try again !");
            return 0;
        }

    }

    @Override
    public float calculateNetSalaryAfterIncrement(Employee employee) {
        try {
            return employee.calculateNetSalaryAfterIncrement();
        } catch (NullPointerException exception) {
            System.out.println("Employee object shouldn't be null");
            return 0;
        } catch (Exception e) {
            System.out.println("Some internal error occured . Please try again !");
            return 0;
        }
    }

    @Override
    public void displayProfile(int empId) {
        System.out.println("This method display the employee profile with Employee ID");
    }

    @Override
    public void displayProfile(float fromSalaryRange, float toSalaryRange) {
        System.out.println("This method display all employee profiles from and to given salary ranges");
    }

    @Override
    public boolean processSalary(Employee employee) throws InvalidBankAccountException {
        if (employee.getBankAccountNo() == null || employee.getBankAccountNo().length() != 11)
            throw new InvalidBankAccountException("Hey " + employee.getName()
                    + ", Invalid Bank Account, Please provide the proper Bank Account Number to process your salary..");
        else
            System.out.println("Net Salary : $" + employee.calculateNetSalary() + " is successfully processed to "
                    + employee.getName());
        return true;
    }

    /*
     * @Override public void displayProfile(String department) { System.out.
     * println("This method display all the employee profiles from a given department"
     * ); }
     */

}
