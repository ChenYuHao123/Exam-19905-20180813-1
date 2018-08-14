package com.cyh.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbUtil {
	/**
	 * 数据库连接工具
	 */
//	private String dbURL = "jdbc:mysql://localhost:3306/sakila"
//			+ "?useUnicode=true&characterEncoding=utf8";//数据库连接地址
//	private String dbUserName = "root";//用户名
//	private String dbPassWord = "123123";//密码
//	private String jdbcName = "com.mysql.jdbc.Driver";//驱动名称
	
	private static String dbURL;
	private static String dbUserName;
	private static String dbPassWord;
	private static String jdbcName;	
	
	static {
		Properties prop = new Properties();
		try {
			prop.load(DbUtil.class.getClassLoader().getResourceAsStream("conn.properties"));
			dbURL = prop.getProperty("dbURL");
			dbUserName = prop.getProperty("dbUserName");
			dbPassWord = prop.getProperty("dbPassWord");
			jdbcName = prop.getProperty("jdbcName");
			Class.forName(jdbcName);
			System.out.println(dbURL);
			System.out.println(dbUserName);
			System.out.println(dbPassWord);
			System.out.println(jdbcName);
			System.out.println("-----------------");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	/**
	 * 获取数据库连接
	 * @return
	 */
	public Connection getCon(){
//		try {
//			Class.forName(jdbcName);
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
		Connection con = null;
		try {
			con = DriverManager.getConnection(dbURL, dbUserName, dbPassWord);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	/**
	 * 关闭数据库连接
	 * @param con
	 */
	public void closeCon(Connection con){
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 数据库连接测试
	 * @param args
	 */
	public static void main(String[] args) {
		DbUtil dbUtil = new DbUtil();
		try{
			dbUtil.getCon();
			System.out.println("数据库连接成功");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("连接失败");
		}
	}
}
