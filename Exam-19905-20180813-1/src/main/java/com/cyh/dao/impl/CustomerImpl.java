package com.cyh.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cyh.dao.BaseDao;
import com.cyh.dao.CustomerDao;
import com.cyh.modle.Customer;

public class CustomerImpl extends BaseDao implements CustomerDao {

	public Customer login(String first_name) {
		String sql = "select * from customer where first_name = ?";
		Customer customer = new Customer();
		try {
			PreparedStatement prstmt = con.prepareStatement(sql);
			prstmt.setString(1, first_name);
			ResultSet rs = prstmt.executeQuery();
			if(rs.next()){
				customer.setFirst_name(rs.getString("first_name"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return customer;
	}

	public List<String> getLanguageList() {
		List<String> list_l = new ArrayList<String>();
		String sql = "select name from language";
		try {
			PreparedStatement prstmt = con.prepareStatement(sql);
			ResultSet rs = prstmt.executeQuery();
			while(rs.next()){
				String name = rs.getString("name");
				list_l.add(name);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list_l;
	}
	
}
