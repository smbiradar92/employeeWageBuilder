package com.employeeWage;

public class EmpWageBuilderUC {

	final int PRESENT_NUMBER_RANGE = 3;
	final int PRESENT = 1;
	final int PART_TIME = 2;
	final int WORKING_HOUR = 8;

	public int getWorkingHour(int empPresent) {
		switch (empPresent) {
		case PRESENT:
			return WORKING_HOUR;
		case PART_TIME: 
			return WORKING_HOUR / 2;		
		}
		return 0;
	}

	public double calculateEmpWage(String company,int maxWorkingDay,int maxWorkingHour,int wagePerHour) {
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
		EmpWageBuilderUC empWageBuilderUC = new EmpWageBuilderUC();
		empWageBuilderUC.calculateEmpWage("DMart",20,80,20);
		System.out.println("----------------------------------------------------------------------------------------");
		empWageBuilderUC.calculateEmpWage("RIL",15,50,30);
		System.out.println("----------------------------------------------------------------------------------------");
		empWageBuilderUC.calculateEmpWage("TCS",20,40,40);
		System.out.println("----------------------------------------------------------------------------------------");
		empWageBuilderUC.calculateEmpWage("RIL",25,35,30);
		System.out.println("----------------------------------------------------------------------------------------");
	}
}

