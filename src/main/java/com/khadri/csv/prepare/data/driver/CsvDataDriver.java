package com.khadri.csv.prepare.data.driver;

import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

import com.khadri.csv.prepare.data.customer.processor.CustomerDataProcessor;
import com.khadri.csv.prepare.data.driver.types.DriverTypes;
import com.khadri.csv.prepare.data.student.processor.StudentDataProcessor;
import com.khadri.csv.prepare.data.student.util.StudentFileUtil;
import com.khadri.cvs.prepare.data.customer.util.CustomerFileUtil;

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

			System.out.println(" How many records you want to enter ?  : ");
			int records = scanner.nextInt();

			for (int i = 1; i <= records; i++) {
				stdProcessor.process(tupleFilePW._2, i);
			}

			tupleFilePW._2.flush();
			tupleFilePW._2.close();

			break;
		case 2:
			break;
		case 3:
			CustomerDataProcessor custProcessor = new CustomerDataProcessor(scanner);
			Tuple2<File, PrintWriter> tupleFilePW2 = CustomerFileUtil.customerCsvFilePrintWriter();

			System.out.println(" How many records you want to enter ?  : ");
			int records2 = scanner.nextInt();

			for (int i = 1; i <= records2; i++) {
				custProcessor.process(tupleFilePW2._2, i);
			}

			tupleFilePW2._2.flush();
			tupleFilePW2._2.close();

			break;
			
		default:
			break;
		}
	}

}
