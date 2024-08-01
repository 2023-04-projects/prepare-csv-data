package com.khadri.csv.prepare.data.mobile.processor;

import java.io.PrintWriter;
import java.util.Scanner;

import com.khadri.csv.prepare.data.processor.Processor;

public class MobileDataProcessor implements Processor {

	private Scanner scanner;

	public MobileDataProcessor(Scanner scanner) {
		this.scanner = scanner;
	}

	@Override
	public void process(PrintWriter pw, int recordNumber) {

		System.out.println("===========> MOBILE " + recordNumber + " DATA READING STARTS ===========>");
		System.out.println("Enter MOBILE_ID : ");
		int id = scanner.nextInt();

		System.out.println("Enter MOBILE_NAME : ");
		String name = scanner.next();

		System.out.println("Enter MOBILE_PRICE : ");
		int price = scanner.nextInt();

		System.out.println("Processing MOBILE DATA");
		try {
			for (int i = 0; i < 1; i++) {
				Thread.sleep(1000);
				System.out.print("=>");
			}
		} catch (Exception e) {
			System.out.println("never comes");
		}

		System.out.println("Processing MOBILE DETAILS");
		try {
			for (int i = 0; i < 1; i++) {
				Thread.sleep(1000);
				System.out.print("=>");
			}
		} catch (Exception e) {
			System.out.println("never comes");
		}

		try {
			for (int i = 0; i < 1; i++) {
				Thread.sleep(1000);
				System.out.print("=>");
			}
		} catch (Exception e) {
			System.out.println("never comes");
		}

		System.out.println("<=========== MOBILE " + recordNumber + " DATA READING ENDS <===========");

		System.out.println("===========> MOBILE" + recordNumber + " DATA WRITING INTO CSV File STARTS ===========>");
		System.out.println("Processing  File Wrting ");

		pw.println();// new empty row
		String line = id + "," + name + "," + price;

		pw.println(line);

		try {
			for (int i = 0; i < 5; i++) {
				Thread.sleep(1000);
				System.out.print("=>");
			}
		} catch (Exception e) {
			System.out.println("never comes");
		}
		System.out.println();
		System.out.println("<=========== MOBILE " + recordNumber + " DATA WRITING INTO CSV File ENDS <===========");

	}

}
