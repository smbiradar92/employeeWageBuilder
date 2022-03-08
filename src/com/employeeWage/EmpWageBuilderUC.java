package com.employeeWage;

public class EmpWageBuilderUC {

	final int PRESENT_NUMBER_RANGE = 3;
	final int PRESENT = 1;
	final int PART_TIME = 2;
	final int WORKING_HOUR = 8;

	String company;
	int maxWorkingDay, maxWorkingHour, wagePerHour;

	public EmpWageBuilderUC(String company, int maxWorkingDay, int maxWorkingHour, int wagePerHour) {
		this.company = company;					 //blue is instance variable	
		this.maxWorkingDay = maxWorkingDay;
		this.maxWorkingHour = maxWorkingHour;
		this.wagePerHour = wagePerHour;
		
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

	public double calculateEmpWage() {
		System.out.println("Calculating the wage for the employee of " +company );
		int totalWorkingHour = 0;
		int day = 0;
		int isPresent;
		while (day < maxWorkingDay && totalWorkingHour < maxWorkingDay) {
			
			int remainingHour = maxWorkingHour - totalWorkingHour;	
			if(maxWorkingHour - totalWorkingHour  < WORKING_HOUR && !(remainingHour < (WORKING_HOUR/2))) {
				isPresent = PART_TIME;
			} else if (remainingHour < (WORKING_HOUR/2)) {
				break;				
			} else {
				isPresent = (int) (Math.random() * PRESENT_NUMBER_RANGE);
			}
			totalWorkingHour = totalWorkingHour + getWorkingHour(isPresent);
			day++;
		}

		double salary = totalWorkingHour * wagePerHour;
		System.out.println("Employee monthly wage : $" + salary + " USD (total working hour : " + totalWorkingHour + ")");
		System.out.println("Total working day : " + day);
		return salary;
	}

	public static void main(String[] args) {
		
		EmpWageBuilderUC dmartEmp = new EmpWageBuilderUC("DMart",22, 60, 30);
		dmartEmp.calculateEmpWage();
		System.out.println("----------------------------------------------------------------------------------------");		
		EmpWageBuilderUC rilmp = new EmpWageBuilderUC("RIL",25, 50, 25);
		dmartEmp.calculateEmpWage();
		System.out.println("----------------------------------------------------------------------------------------");	
		EmpWageBuilderUC hpEmp = new EmpWageBuilderUC("hp",30, 50, 25);
		dmartEmp.calculateEmpWage();
		System.out.println("----------------------------------------------------------------------------------------");
		EmpWageBuilderUC lenovoEmp = new EmpWageBuilderUC("Lenovo",20, 50, 25);
		dmartEmp.calculateEmpWage();
		System.out.println("----------------------------------------------------------------------------------------");
	}
}

