package com.khadri.csv.prepare.data.mobile.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import com.khadri.csv.prepare.data.mobile.constants.MobileCsvHeaders;

import io.vavr.Tuple;
import io.vavr.Tuple2;

public class MobileFileUtil {

	private static PrintWriter pw;
	private static File file;

	public static Tuple2<File, PrintWriter> mobileCsvFilePrintWriter() {
		System.out.println("===========> MOBILE CSV File Creation  STARTS ===========>");

		try {
			file = new File("src/main/resources/mobile.csv");
			boolean isNewFile = file.createNewFile();
			pw = new PrintWriter(new FileWriter(file, true));
			if (isNewFile) {
				System.out.println("File is new, writing header...");
				Arrays.stream(MobileCsvHeaders.values()).forEach(eachHeader -> {
					pw.print(eachHeader.name());
					pw.print(",");
				});
				pw.println(",");
			} else {
				System.out.println("File already exists, skipping header...");
			}

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
		System.out.println("<=========== MOBILE CSV File Creation ENDS <===========");

		System.out.println("===========> MOBILE HEADER ROW WRITING INTO CSV File STARTS ===========>");

		//System.out.println("Process of Writing Headers into : " + file.getName());
		

		System.out.println("<=========== MOBILE HEADER ROW WRITING INTO CSV File ENDS <===========");

		return Tuple.of(file, pw);
	}

}
