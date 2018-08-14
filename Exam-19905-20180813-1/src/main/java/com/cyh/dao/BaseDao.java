package com.cyh.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.cyh.util.DbUtil;


/**
 * 创建数据库连接对象
 * @author 1612143222
 *
 */
public class BaseDao {
	public Connection con = new DbUtil().getCon();
	public void closeDao(){
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
