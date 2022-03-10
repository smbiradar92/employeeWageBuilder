package com.employeeWage;

public class EmpWageBuilderUC {

	final int PRESENT = 1;
	final int PART_TIME = 2;
	final int WORKING_HOUR = 8;

	CompanyEmpWage[] companies;
	int lastIndex;

	public EmpWageBuilderUC() {
		this.companies = new CompanyEmpWage[10];
	}

	public void addCompany(CompanyEmpWage company) {
		try {
			companies[lastIndex++] = company;
		} catch (Exception e) {
			System.out.println(
					"You can not add more company to the array as the size of an array is 5.");
		}
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
		for (int i = 0; i < companies.length; i++) {
			if (companies[i] != null) {
				calculateEmpWage(companies[i]);
				System.out.println(companies[i]);
			}
		}
	}

	public void calculateEmpWage(CompanyEmpWage company) {
		int totalWorkingHour = 0;
		int day = 0;

		while (day < company.maxWorkingDay
				&& totalWorkingHour < company.maxWorkingHour) {
			int isPresent;
			int remainingWorkingHour = company.maxWorkingHour
					- totalWorkingHour;
			if (remainingWorkingHour < WORKING_HOUR
					&& !(remainingWorkingHour < (WORKING_HOUR
							/ 2))) {
				isPresent = PART_TIME;
			} else if (remainingWorkingHour < (WORKING_HOUR
					/ 2)) {
				break;
			} else {
				isPresent = (int) (Math.random() * 3);
			}

			totalWorkingHour = totalWorkingHour
					+ getWorkingHour(isPresent);
			day++;
		}
		company.totalWorkingHour = totalWorkingHour;
		company.totalSalary = totalWorkingHour
				* company.wagePerHour;

	}

	public static void main(String[] args) {

					CompanyEmpWage dmart = new CompanyEmpWage("DMart",
					20, 60, 25);

			CompanyEmpWage ril = new CompanyEmpWage("Reliance",
					22, 80, 35);

			CompanyEmpWage asus = new CompanyEmpWage("Asus", 20,
					48, 22);

			CompanyEmpWage techM = new CompanyEmpWage(
					"Tech Mahindra", 25, 80, 40);

			CompanyEmpWage hp = new CompanyEmpWage("HP", 20, 48,
					22);

			CompanyEmpWage lenovo = new CompanyEmpWage("Lenovo",
					25, 80, 40);

			EmpWageBuilderUC empWageBuilder = new EmpWageBuilderUC();
			empWageBuilder.addCompany(dmart);
			empWageBuilder.addCompany(ril);
			empWageBuilder.addCompany(asus);
			empWageBuilder.addCompany(techM);
			empWageBuilder.addCompany(hp);
			empWageBuilder.addCompany(lenovo);
			
			empWageBuilder.calculateEmpWage();
		}
	}
	
