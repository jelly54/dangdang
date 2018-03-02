package com.dangdang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dangdang.bean.User;

/**
 * 用户登录，检索
 * 
 * @author Jelly
 */
public class UserDao extends BaseDao {
	/**
	 * 根据用户名获取用户密码
	 * 
	 * @param username
	 * @return userpass
	 */
	public String getPassByName(String username) {
		String dbpass = null;
		Connection con = getCon();
		String sql = "select user_pass from user where user_name=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setObject(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				dbpass = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeCon(con);
		}
		return dbpass;
	}

	/**
	 * 根据用户名获取用户id
	 * 
	 * @param username
	 * @return userid
	 */
	public int getIDByName(String username) {
		int id = 0;
		Connection con = getCon();
		String sql = "select id from user where user_name=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setObject(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				id = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeCon(con);
		}
		return id;
	}

	/**
	 * 根据用户名获取用户
	 * 
	 * @param username
	 * @return userBean
	 */
	public User getUserByName(String username) {
		User user = new User();

		Connection con = getCon();
		String sql = "select id,user_name,user_pass,user_add from user where user_name=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setObject(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int uid = rs.getInt("id");
				String uname = rs.getString("user_name");
				String upass = rs.getString("user_pass");
				String uadd = rs.getString("user_add");
				user.setId(uid);
				user.setUsername(uname);
				user.setUserpass(upass);
				user.setUseradd(uadd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeCon(con);
		}

		return user;
	}
}
