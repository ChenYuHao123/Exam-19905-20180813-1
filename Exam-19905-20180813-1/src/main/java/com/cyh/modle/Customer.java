package com.cyh.modle;

public class Customer {
	private String first_name;

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	@Override
	public String toString() {
		return "Customer [first_name=" + first_name + "]";
	}
	
}
