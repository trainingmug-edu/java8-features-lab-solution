package com.trainingmug.employee.domain;

import java.util.Objects;

public class Employee {

    // Instance Variables

    private long empId;
    private String name;
    private String designation;
    private float grossSalary;
    private float travellingAllowances;
    private float federalTax;
    private float stateTax;
    private float incrementPercentage;
    private String bankAccountNo;


    private static String companyName = "Digi-Safari Pvt Ltd";
    private static String companyContactNo = "+1 678-505-0990";
    private static int employeeCount = 0;


    public Employee() {
        employeeCount++;
    }

    public Employee(long empId, String name, String designation, float grossSalary, float travellingAllowances,
                    float federalTax, float stateTax, float incrementPercentage, String bankAccountNo) {
        this.empId = empId;
        this.name = name;
        this.designation = designation;
        this.grossSalary = grossSalary;
        this.travellingAllowances = travellingAllowances;
        this.federalTax = federalTax;
        this.stateTax = stateTax;
        this.incrementPercentage = incrementPercentage;
        this.bankAccountNo = bankAccountNo;
        employeeCount++;
    }

    public void displayProfile() {
        System.out.println("displayProfile() - Employee Class");
        System.out.println("Id : " + empId);
        System.out.println("Name : " + name);
        System.out.println("Designation : " + designation);
        System.out.println("Gross Salary : " + grossSalary);
        System.out.println("Travelling Allowances : " + travellingAllowances);
        System.out.println("Federal Tax : " + federalTax);
        System.out.println("State Tax : " + stateTax);
        System.out.println("Bank Account Number : " + bankAccountNo);
        System.out.println("Net Salary Increment Percentage : " + incrementPercentage);
        System.out.println("Net Salary : " + this.calculateNetSalary());
        System.out.println("Net Salary After Increment : " + this.calculateNetSalaryAfterIncrement());
    }

    public static void displayCompanyInfo() {
        System.out.println("Company Name : " + companyName);
        System.out.println("Company Contact No : " + companyContactNo);
        System.out.println("Employee Count : " + employeeCount);
    }

    public float calculateNetSalary() {
        System.out.println("calculateNetSalary() - Employee Class");
        return grossSalary - federalTax - stateTax;
    }

    public float calculateNetSalaryAfterIncrement() {
        System.out.println("calculateNetSalaryAfterIncrement() - Employee Class");
        float netSalary;
        netSalary = calculateNetSalary();
        netSalary += (netSalary * incrementPercentage / 100);
        return netSalary;
    }

    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public float getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(float grossSalary) {
        this.grossSalary = grossSalary;
    }

    public float getTravellingAllowances() {
        return travellingAllowances;
    }

    public void setTravellingAllowances(float travellingAllowances) {
        this.travellingAllowances = travellingAllowances;
    }

    public float getFederalTax() {
        return federalTax;
    }

    public void setFederalTax(float federalTax) {
        this.federalTax = federalTax;
    }

    public float getStateTax() {
        return stateTax;
    }

    public void setStateTax(float stateTax) {
        this.stateTax = stateTax;
    }

    public float getIncrementPercentage() {
        return incrementPercentage;
    }

    public void setIncrementPercentage(float incrementPercentage) {
        this.incrementPercentage = incrementPercentage;
    }


    public String getBankAccountNo() {
        return bankAccountNo;
    }

    public void setBankAccountNo(String bankAccountNo) {
        this.bankAccountNo = bankAccountNo;
    }

    public static String getCompanyName() {
        return companyName;
    }

    public static void setCompanyName(String companyName) {
        Employee.companyName = companyName;
    }

    public static String getCompanyContactNo() {
        return companyContactNo;
    }

    public static void setCompanyContactNo(String companyContactNo) {
        Employee.companyContactNo = companyContactNo;
    }

    public static int getEmployeeCount() {
        return employeeCount;
    }

    public static void setEmployeeCount(int employeeCount) {
        Employee.employeeCount = employeeCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bankAccountNo, designation, empId, federalTax, grossSalary, incrementPercentage, name,
                stateTax, travellingAllowances);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        return Objects.equals(bankAccountNo, other.bankAccountNo) && Objects.equals(designation, other.designation)
                && empId == other.empId && Float.floatToIntBits(federalTax) == Float.floatToIntBits(other.federalTax)
                && Float.floatToIntBits(grossSalary) == Float.floatToIntBits(other.grossSalary)
                && Float.floatToIntBits(incrementPercentage) == Float.floatToIntBits(other.incrementPercentage)
                && Objects.equals(name, other.name)
                && Float.floatToIntBits(stateTax) == Float.floatToIntBits(other.stateTax)
                && Float.floatToIntBits(travellingAllowances) == Float.floatToIntBits(other.travellingAllowances);
    }

}
