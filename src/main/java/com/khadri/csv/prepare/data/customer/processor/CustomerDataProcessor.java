package com.khadri.csv.prepare.data.customer.processor;

import java.io.PrintWriter;
import java.util.Scanner;

import com.khadri.csv.prepare.data.processor.Processor;

public class CustomerDataProcessor implements Processor {
	private Scanner scanner;

	public CustomerDataProcessor(Scanner scanner) {
		this.scanner = scanner;
	}

	public void process(PrintWriter pw, int recordNumber) {
		System.out.println("===========> CUSTOMER " + recordNumber + " DATA READING STARTS ===========>");
		System.out.println("Enter Cust_Id : ");
		int id = scanner.nextInt();

		System.out.println("Enter Customer Name : ");
		String name = scanner.next();

		System.out.println("Enter  Customer Address : ");
		String address = scanner.next();

		System.out.println("Enter Customer Phone_Num : ");
		Long phone_Num = scanner.nextLong();

		System.out.println("<=========== CUSTOMER " + recordNumber + " DATA READING ENDS <===========");

		System.out.println("===========> CUSTOMER " + recordNumber + " DATA WRITING INTO CSV File STARTS ===========>");
		System.out.println("Processing  File Wrting ");

		//pw.println();// new empty row
		String line = id + "," + name + "," + address + "," + phone_Num;
		pw.println(line);

		System.out.println();
		System.out.println("<=========== CUSTOMER " + recordNumber + " DATA WRITING INTO CSV File ENDS <===========");

	}
}
