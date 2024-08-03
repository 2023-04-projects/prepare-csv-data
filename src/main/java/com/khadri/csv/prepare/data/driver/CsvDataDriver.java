package com.khadri.csv.prepare.data.driver;

import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

import com.khadri.csv.prepare.data.driver.types.DriverTypes;
import com.khadri.csv.prepare.data.movie.processor.MovieDataProcessor;
import com.khadri.csv.prepare.data.movie.util.MovieFileUtil;
import com.khadri.csv.prepare.data.student.processor.StudentDataProcessor;
import com.khadri.csv.prepare.data.student.util.StudentFileUtil;
import com.khadri.csv.prepare.data.supermarket.processor.SuperMarketDataProcessor;
import com.khadri.csv.prepare.data.supermarket.util.SuperMarketFileUtil;

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
			Tuple2<File, PrintWriter> movieCsvFilePrintWriter = MovieFileUtil.movieCsvFilePrintWriter();
			System.out.println(" How many records you want to enter ?  : ");
			int movieRecords = scanner.nextInt();

			for (int i = 0; i < movieRecords; i++) {
				dataProcessor.process(movieCsvFilePrintWriter._2, i);

			}

			movieCsvFilePrintWriter._2.flush();
			movieCsvFilePrintWriter._2.close();
			break;

		default:
			break;
		}
	}

}
