package com.khadri.csv.prepare.data.student.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import com.khadri.csv.prepare.data.student.constants.StudentCsvHeaders;

import io.vavr.Tuple;
import io.vavr.Tuple2;

public class StudentFileUtil {

	private static PrintWriter pw;
	private static File file;

	public static Tuple2<File, PrintWriter> studentCsvFilePrintWriter() {
		System.out.println("===========> STUDENT CSV File Creation  STARTS ===========>");

		try {
			file = new File("src/main/resources/student.csv");
			pw = new PrintWriter(new FileWriter(file, true));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Process of File creation In Progress");
		try {
			for (int i = 0; i < 1; i++) {
				Thread.sleep(1000);
				System.out.print("=>");
			}
		} catch (Exception e) {
			System.out.println("never comes");
		}
	
		
		System.out.println("File Name : " + file.getName() + " Created At : " + file.getPath());
		System.out.println("<=========== STUDENT CSV File Creation ENDS <===========");

		System.out.println("===========> STUDENT HEADER ROW WRITING INTO CSV File STARTS ===========>");

		Integer maxHeaderCount = Arrays.stream(StudentCsvHeaders.values()).map(eachHeder -> eachHeder.getId())
				.max((i1, i2) -> i1.compareTo(i2)).get();

		Arrays.stream(StudentCsvHeaders.values()).forEach(eachHeader -> {
			pw.print(eachHeader.name());

			if (eachHeader.getId() != maxHeaderCount)
				pw.print(",");
		});

		System.out.println("Process of Writing Headers into : "+file.getName());
		try {
			for (int i = 0; i < 1; i++) {
				Thread.sleep(1000);
				System.out.print("=>");
			}
		} catch (Exception e) {
			System.out.println("never comes");
		}
	

		System.out.println("<=========== STUDENT HEADER ROW WRITING INTO CSV File ENDS <===========");

		return Tuple.of(file, pw);
	}
}
