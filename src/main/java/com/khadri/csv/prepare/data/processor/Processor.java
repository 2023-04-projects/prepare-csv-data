package com.khadri.csv.prepare.data.processor;

import java.io.PrintWriter;

@FunctionalInterface
public interface Processor {

	void process(PrintWriter pw, int recordNumber);
}
