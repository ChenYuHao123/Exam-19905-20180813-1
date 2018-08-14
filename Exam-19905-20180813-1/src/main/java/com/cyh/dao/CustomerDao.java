package com.cyh.dao;

import java.util.List;

import com.cyh.modle.Customer;

public interface CustomerDao {

	public Customer login(String first_name);

	public List<String> getLanguageList();
	
}
