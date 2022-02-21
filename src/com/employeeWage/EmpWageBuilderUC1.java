package com.employeeWage;

public class EmpWageBuilderUC1 {

	public static void main(String[] args) {
		// declare variables
		final int PRESENT = 1; 
		//Computation
		int isEmpPresent = (int)Math.floor(Math.random()*2);
			
			System.out.println(isEmpPresent);
		
		if ( isEmpPresent==PRESENT ) {
			
			System.out.println("The Employee is Present");
			
		}else {
			
			System.out.println("The Employee is Absent");
		}
	}
	
}
