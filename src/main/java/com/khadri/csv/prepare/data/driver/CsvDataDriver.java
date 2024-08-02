package com.khadri.csv.prepare.data.driver;

import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

import com.khadri.csv.prepare.data.driver.types.DriverTypes;
import com.khadri.csv.prepare.data.mobile.processor.MobileDataProcessor;
import com.khadri.csv.prepare.data.mobile.util.MobileFileUtil;
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
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;

		case 6:
			MobileDataProcessor mobileProcessor = new MobileDataProcessor(scanner);
			Tuple2<File, PrintWriter> tupleFilePW6 = MobileFileUtil.mobileCsvFilePrintWriter();

			try {
				System.out.println(" How many records you want to enter ?  : ");
				int records = scanner.nextInt();

				for (int i = 1; i <= records; i++) {
					mobileProcessor.process(tupleFilePW6._2, i);
				}
			} catch (Exception e) {
				System.out.println("Exception Occured " + e.getCause());
			} finally {
				System.out.println("The remaining records were inserted into file. ");
				tupleFilePW6._2.flush();
				tupleFilePW6._2.close();
			}

			break;
		default:
			break;
		}
	}

}
