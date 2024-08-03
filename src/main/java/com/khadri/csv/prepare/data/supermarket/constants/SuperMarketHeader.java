package com.khadri.csv.prepare.data.supermarket.constants;

public enum SuperMarketHeader{

	PROD_NAME(1), PROD_ID(2), PROD_PRICE(3), PROD_QTY(4), TOTAL_AMOUNT(5);

	private int id;

	private SuperMarketHeader(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	
	}


