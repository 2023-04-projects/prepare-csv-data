package com.khadri.csv.prepare.data.driver;

import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

import com.khadri.csv.prepare.data.driver.types.DriverTypes;
import com.khadri.csv.prepare.data.employee.processor.EmployeeDataProcessor;
import com.khadri.csv.prepare.data.employee.util.EmployeeFileUtil;
import com.khadri.csv.prepare.data.student.processor.StudentDataProcessor;
import com.khadri.csv.prepare.data.student.util.StudentFileUtil;

import io.vavr.Tuple2;

public class CsvDataDriver {

	private Scanner scanner;

	{
		scanner = new Scanner(System.in);
	}

	public static void main(String[] args) {

		System.out.println("###################### Welocme to CSV data Driver  ########################");
		System.out.println("$$$$$$$$$$$$$$ The data procesors $$$$$$$$$$$$$$$$$");

		Arrays.stream(DriverTypes.values()).forEach(each -> {
			System.out.println(each.getId() + " : " + each.getName());
		});

		CsvDataDriver csvDataDriver = new CsvDataDriver();
		csvDataDriver.process();
	}

	private void process() {
		System.out.println("Please choose the data processor : ");
		int dataProcessId = scanner.nextInt();

		switch (dataProcessId) {
		case 1:
			StudentDataProcessor stdProcessor = new StudentDataProcessor(scanner);
			Tuple2<File, PrintWriter> tupleFilePW = StudentFileUtil.studentCsvFilePrintWriter();

			try {
				System.out.println(" How many records you want to enter ?  : ");
				int records = scanner.nextInt();

				for (int i = 1; i <= records; i++) {
					stdProcessor.process(tupleFilePW._2, i);
				}
			} catch (Exception e) {
				System.out.println("Exception Occured " + e.getCause());
			} finally {
				System.out.println("The remaining records were inserted into file. ");
				tupleFilePW._2.flush();
				tupleFilePW._2.close();
			}
			break;
		case 2:
			EmployeeDataProcessor empProcessor = new EmployeeDataProcessor(scanner);
			Tuple2<File, PrintWriter> tupleFilePW1 = EmployeeFileUtil.employeeCsvFilePrintWriter();
			try {
				System.out.println(" How many records you want to enter ?  : ");
				int records1 = scanner.nextInt();
				for (int i = 1; i <= records1; i++) {
					empProcessor.process(tupleFilePW1._2, i);
				}
			} catch (Exception e) {
				System.out.println("Exception Occured" + e.getCause());
			} finally {
				System.out.println("The remaining records were inserted into file. ");
				tupleFilePW1._2.flush();
				tupleFilePW1._2.close();
			}
			break;
		default:
			break;
		}
	}

}
