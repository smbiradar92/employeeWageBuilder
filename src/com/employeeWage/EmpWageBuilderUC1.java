package com.employeeWage;

public class EmpWageBuilderUC1 {

	public static void main(String[] args) {
		// declare variables
		final int PRESENT_RANGE = 3;
		final int PRESENT = 1;
		final int PARTTIME = 2;
		final int WAGE_PER_HOUR = 20;
		final int MAX_NUM_WORKING_DAYS = 20; 
		int WORKING_HOUR = 0;
		int EMP_WAGE=0;
		int day = 0;
		int totalWorkingHour = 0;
		
		//Computation by for loop
		
		for (day = 1; day < MAX_NUM_WORKING_DAYS; day++) {
		
		int isEmpPresent = (int)Math.floor(Math.random()*PRESENT_RANGE);
		
			switch ( isEmpPresent ) {
			case PRESENT: {
				//System.out.println("The Employee works as Present");
				WORKING_HOUR = 8;			
				break;
			}
			case PARTTIME: {
				//System.out.println("The Employee is Parttime");
				WORKING_HOUR = 4;			
			}
				break;
			
			default:
				//System.out.println("The Employee is Absent");
				//WORKING_HOUR = 0;
			break;
			}	
		
		// Wage calculation condtion:
			
		EMP_WAGE = WAGE_PER_HOUR*WORKING_HOUR;	
		totalWorkingHour = totalWorkingHour + WORKING_HOUR/2;
		}
		double salary= totalWorkingHour*EMP_WAGE;	
		
		System.out.println("Total Working hours:" +totalWorkingHour + " " + "Employee Monthly Wage is : $" +salary );
		
	}
	
}
