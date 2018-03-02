package com.dangdang.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * dao层的父类，用来获取和数据库的连接
 * @author Jelly
 */
public class BaseDao {
	
	private static String driver;
	private static String url;
	private static String dbusername;
	private static String dbpass;

	static {
		Properties properties = new Properties();
		try {
			properties.load(BaseDao.class.getClassLoader().getResourceAsStream(
					"db.properties"));

			driver = properties.getProperty("dbdriver");
			url = properties.getProperty("dburl");
			dbusername = properties.getProperty("dbusername");
			dbpass = properties.getProperty("dbpass");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 获取数据库连接
	 * @return
	 */
	public Connection getCon(){
		Connection connection = null;
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, dbusername, dbpass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return connection;
	}
	
	/**
	 * 关闭所有连接
	 * @param con
	 */
	public void closeCon(Connection con){
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
