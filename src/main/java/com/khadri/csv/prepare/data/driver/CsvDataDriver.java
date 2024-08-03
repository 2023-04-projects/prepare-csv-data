package com.khadri.csv.prepare.data.driver;

import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

import com.khadri.csv.prepare.data.customer.processor.CustomerDataProcessor;
import com.khadri.csv.prepare.data.driver.types.DriverTypes;
import com.khadri.csv.prepare.data.employee.processor.EmployeeDataProcessor;
import com.khadri.csv.prepare.data.employee.util.EmployeeFileUtil;
import com.khadri.csv.prepare.data.mobile.processor.MobileDataProcessor;
import com.khadri.csv.prepare.data.mobile.util.MobileFileUtil;
import com.khadri.csv.prepare.data.movie.processor.MovieDataProcessor;
import com.khadri.csv.prepare.data.movie.util.MovieFileUtil;
import com.khadri.csv.prepare.data.student.processor.StudentDataProcessor;
import com.khadri.csv.prepare.data.student.util.StudentFileUtil;
import com.khadri.csv.prepare.data.supermarket.processor.SuperMarketDataProcessor;
import com.khadri.csv.prepare.data.supermarket.util.SuperMarketFileUtil;
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
		case 3:
			CustomerDataProcessor custProcessor = new CustomerDataProcessor(scanner);
			Tuple2<File, PrintWriter> tupleFilePW2 = CustomerFileUtil.customerCsvFilePrintWriter();

			try {
				System.out.println(" How many records you want to enter ?  : ");
				int records2 = scanner.nextInt();

				for (int i = 1; i <= records2; i++) {
					custProcessor.process(tupleFilePW2._2, i);
				}
			} catch (Exception e) {
				System.out.println("Exception Occured " + e.getCause());
			} finally {
				System.out.println("The remaining records were inserted into file. ");
				tupleFilePW2._2.flush();
				tupleFilePW2._2.close();
			}
			break;
		case 4:
			SuperMarketDataProcessor superMarketDataProcessor = new SuperMarketDataProcessor(scanner);
			Tuple2<File, PrintWriter> tupleFilePW4 = SuperMarketFileUtil.superMarketCsvFilePrintWriter();
			try {
				System.out.println("How Many Records Do You Want ? : ");
				int records4 = scanner.nextInt();

				for (int i = 1; i <= records4; i++) {
					superMarketDataProcessor.process(tupleFilePW4._2, i);
				}

			} catch (Exception e) {
				System.out.println("Exception Occured " + e.getCause());
			} finally {
				System.out.println("The remaining records were inserted into file. ");
				tupleFilePW4._2.flush();
				tupleFilePW4._2.close();

			}

		case 5:
			MovieDataProcessor dataProcessor = new MovieDataProcessor(scanner);
			Tuple2<File, PrintWriter> tupleFilePW5 = MovieFileUtil.movieCsvFilePrintWriter();
			try {
				System.out.println(" How many records you want to enter ?  : ");
				int movieRecords = scanner.nextInt();

				for (int i = 0; i < movieRecords; i++) {
					dataProcessor.process(tupleFilePW5._2, i);

				}

			} catch (Exception e) {
				System.out.println("Exception Occured " + e.getCause());
			} finally {
				System.out.println("The remaining records were inserted into file. ");
				tupleFilePW5._2.flush();
				tupleFilePW5._2.close();

			}

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
