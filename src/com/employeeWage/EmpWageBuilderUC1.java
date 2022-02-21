package com.employeeWage;

public class EmpWageBuilderUC1 {

	public static void main(String[] args) {
		// declare variables
		final int PRESENT_WAGE_RANGE = 3;
		final int PRESENT = 1;
		final int PARTTIME = 2;
		final int WAGE_PER_HOUR = 20;
		int WORKING_HOUR = 0;
		int EMP_WAGE=0;
		
		//Computation
		int isEmpPresent = (int)Math.floor(Math.random()*2);
		
			System.out.println(isEmpPresent);
			
		if ( isEmpPresent == PRESENT ) {	
			System.out.println("The Employee is Present");
			WORKING_HOUR = 8;
		}
		else if ( isEmpPresent == PARTTIME ) {
			System.out.println("The Employee works as Parttime");
			WORKING_HOUR = 4;
		}
		else {			
			System.out.println("The Employee is Absent");
			WORKING_HOUR = 0;
		}
		
		// Wage calculation condtion:
		
		EMP_WAGE = WAGE_PER_HOUR*WORKING_HOUR;
			System.out.println("Employee Wage is : Rs." +EMP_WAGE );
	}
	
}
