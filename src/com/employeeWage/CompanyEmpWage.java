package com.employeeWage;

public class CompanyEmpWage {

	String company;
	int maxWorkingDay, maxWorkingHour, wagePerHour;
	
	double totalSalary;
	public int totalWorkingHour;
	
	public CompanyEmpWage(String company, int maxWorkingDay, int maxWorkingHour, int wagePerHour) {
		this.company = company;					 //blue is instance variable	
		this.maxWorkingDay = maxWorkingDay;
		this.maxWorkingHour = maxWorkingHour;
		this.wagePerHour = wagePerHour;
	}

	@Override
	public String toString() {
	
		return "Employee company name is "+company +  "\nEmployee monthly wage is :" +totalSalary +"\nEmployee total working hour is " +totalWorkingHour;
	}

	
}
