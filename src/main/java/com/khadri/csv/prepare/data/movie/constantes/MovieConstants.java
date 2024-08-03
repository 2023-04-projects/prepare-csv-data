package com.khadri.csv.prepare.data.movie.constantes;

public enum MovieConstants {
	ID(1), Movie_NAME(2), Movie_Making_Price(3), Movie_songs_Making_Price(4), TOTAL_Collection(5), AVG(6), GRADE(8);

	private int id;

	private MovieConstants(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
