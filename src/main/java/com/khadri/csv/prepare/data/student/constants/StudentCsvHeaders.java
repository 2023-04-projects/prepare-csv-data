package com.khadri.csv.prepare.data.student.constants;

public enum StudentCsvHeaders {

	ID(1), NAME(2), SUB1_MARKS(3), SUB2_MARKS(4), SUB3_MARKS(5), TOTAL_MARKS(6), AVG(7), GRADE(8);

	private int id;

	private StudentCsvHeaders(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
