package com.trainingmug.employee.main;

import com.trainingmug.employee.domain.Designer;
import com.trainingmug.employee.domain.Developer;
import com.trainingmug.employee.domain.Employee;
import com.trainingmug.employee.exception.InvalidBankAccountException;
import com.trainingmug.employee.service.PayrollImpl;

public class Main {

    public static void main(String[] args) {

        Employee employee1 = new Employee(); // Creating new Object (Instance )
        /*
         * Accessing and Initializing the instance variables
         */

        Employee employee3 = new Employee(3333, "Nancy Davolio", "Devops Engineer", 4569.45F, 280.5F, 535.45F, 326.34F,
                12.5F, "00343538343");
        Employee employee4 = new Employee(4444, "Steven Buchanan", "Frontend Developer", 4769.45F, 286.5F, 525.45F,
                336.34F, 12.0F, "01443558343");

        // Invoking the instance methods
        // employee1.displayProfile();
        // employee2.displayProfile();
        /*
         * employee3.displayProfile(); employee4.displayProfile();
         */
        // Employee.displayCompanyInfo();

        Developer developer1 = new Developer(5555, "David Austin", "Senior Backend Developer", 6579.45F, 332.5F,
                629.45F, 398.34F, 9.5F, "01642558343", 5);
        Developer developer2 = new Developer(6666, "Nancy Greenberg", "Junior Backend Developer", 4369.45F, 278.5F,
                529.45F, 318.34F, 12.5F, "02743538343", 3);

        Designer designer1 = new Designer(7777, "Daniel Faviet", "Senior UI/UX Designer", 6349.45F, 322.5F, 618.45F,
                387.34F, 8.5F, "01642568343", 5);
        Designer designer2 = new Designer(8888, "Daniel Faviet", "Junior UI/UX Designer", 4339.45F, 277.5F, 526.45F,
                316.34F, 12.8F, "01243657343", 3);

        PayrollImpl payroll = new PayrollImpl();
        payroll.calculateNetSalary(developer1);
        payroll.calculateNetSalary(developer2);
        payroll.calculateNetSalary(designer1);
        payroll.calculateNetSalary(designer2);

        payroll.calculateNetSalaryAfterIncrement(developer1);
        payroll.calculateNetSalaryAfterIncrement(developer2);
        payroll.calculateNetSalaryAfterIncrement(designer1);
        payroll.calculateNetSalaryAfterIncrement(designer2);

        payroll.displayProfile(developer1);
        payroll.displayProfile(developer2);
        payroll.displayProfile(designer1);
        payroll.displayProfile(designer2);

        payroll.displayProfile(null);
        payroll.calculateNetSalary(null);
        payroll.calculateNetSalaryAfterIncrement(null);

        try {
            payroll.processSalary(developer1);
        } catch (InvalidBankAccountException e) {
            System.out.println(e.getMessage());
        }
        try {
            payroll.processSalary(developer2);
        } catch (InvalidBankAccountException e) {
            System.out.println(e.getMessage());
        }
        try {
            payroll.processSalary(designer1);
        } catch (InvalidBankAccountException e) {
            System.out.println(e.getMessage());
        }
        try {
            payroll.processSalary(designer2);
        } catch (InvalidBankAccountException e) {
            System.out.println(e.getMessage());
        }

        Developer developer3 = new Developer(9999, "Alexander Khoo", "Senior Backend Developer", 6579.45F, 332.5F,
                629.45F, 398.34F, 9.5F, null, 5);

        try {
            payroll.processSalary(developer3);
        } catch (InvalidBankAccountException e) {
            System.out.println(e.getMessage());
        }

        Developer developer4 = new Developer(9877, "Shelli Baida", "Senior Backend Developer", 6579.45F, 332.5F,
                629.45F, 398.34F, 9.5F, "01234567", 5);
        try {
            payroll.processSalary(developer4);
        } catch (InvalidBankAccountException e) {
            System.out.println(e.getMessage());
        }

    }
}
