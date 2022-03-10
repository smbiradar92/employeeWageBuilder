package com.employeeWage;

import java.util.LinkedList;
import java.util.List;

public class EmpWageBuilderUC { // API Approach

	final int PRESENT = 1;
	final int PART_TIME = 2;
	final int WORKING_HOUR = 8;

	List<CompanyEmpWage> companies;

	public EmpWageBuilderUC() {
		this.companies = new LinkedList<CompanyEmpWage>();
	}

	public void addCompany(String companyName, int maxWorkingDay, int maxWorkingHour, int wagePerHour) {
		CompanyEmpWage company = new CompanyEmpWage(companyName, maxWorkingDay, maxWorkingHour, wagePerHour);
		companies.add(company);
	}

	public int getWorkingHour(int empPresent) {
		switch (empPresent) {
		case PRESENT:
			return WORKING_HOUR;

		case PART_TIME:
			return WORKING_HOUR / 2;

		}
		return 0;
	}

	public void calculateEmpWage() {
		for (int i = 0; i < companies.size(); i++) {
			calculateEmpWage(companies.get(i));
			System.out.println(companies.get(i));
		}
	}

	public void calculateEmpWage(CompanyEmpWage company) {
		int totalWorkingHour = 0;
		int day = 0;

		while (day < company.maxWorkingDay && totalWorkingHour < company.maxWorkingHour) {
			int isPresent;
			int remainingWorkingHour = company.maxWorkingHour - totalWorkingHour;
			if (remainingWorkingHour < WORKING_HOUR && !(remainingWorkingHour < (WORKING_HOUR / 2))) {
				isPresent = PART_TIME;
			} else if (remainingWorkingHour < (WORKING_HOUR / 2)) {
				break;
			} else {
				isPresent = (int) (Math.random() * 3);
			}

			totalWorkingHour = totalWorkingHour + getWorkingHour(isPresent);
			day++;
		}
		company.totalWorkingHour = totalWorkingHour;
		company.totalSalary = totalWorkingHour * company.wagePerHour;

	}

	public static void main(String[] args) {

		EmpWageBuilderUC empWageBuilder = new EmpWageBuilderUC();
		empWageBuilder.addCompany("DMart", 20, 60, 25);
		empWageBuilder.addCompany("Reliance", 22, 80, 35);
		empWageBuilder.addCompany("Asus", 20, 48, 22);
		empWageBuilder.addCompany("Tech Mahindra", 25, 80, 40);

		empWageBuilder.calculateEmpWage();
	}
}
