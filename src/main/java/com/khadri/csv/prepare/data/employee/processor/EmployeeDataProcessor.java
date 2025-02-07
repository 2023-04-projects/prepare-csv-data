package com.khadri.csv.prepare.data.employee.processor;

import java.io.PrintWriter;
import java.util.Scanner;

import com.khadri.csv.prepare.data.processor.Processor;

public class EmployeeDataProcessor implements Processor {
	private Scanner scanner;

	public EmployeeDataProcessor(Scanner scanner) {
		this.scanner = scanner;
	}

	@Override
	public void process(PrintWriter pw, int recordNumber) {
		System.out.println("===========> EMPLOYEE " + recordNumber + " DATA READING STARTS ===========>");
		System.out.println("Enter Employee Id : ");
		int id = scanner.nextInt();

		System.out.println("Enter Employee Name : ");
		String name = scanner.next();

		System.out.println("Enter Employee Desigination : ");
		String desigination = scanner.next();

		System.out.println("Enter Employee Salary :");
		Double salary = scanner.nextDouble();
		
		System.out.println("<=========== EMPLOYEE " + recordNumber + " DATA READING ENDS <===========");
		System.out.println("===========> EMPLOYEE " + recordNumber + " DATA WRITING INTO CSV File STARTS ===========>");
		System.out.println("Processing  File Wrting ");
		System.out.println("===========> EMPLOYEE " + recordNumber + " DATA WRITING INTO CSV File STARTS ===========>");
		System.out.println("Processing  File Wrting ");
		
		pw.println();
		String line = id + "," + name + "," + desigination + "," + salary ;
		pw.println(line);

	}
}
