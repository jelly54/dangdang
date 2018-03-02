package com.dangdang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.dangdang.bean.BookType;

public class TypeDao extends BaseDao{

	public List<BookType> getTypes(){
		List<BookType> list = new ArrayList<BookType>();
		Connection conn = getCon();
		String sql = "select * from bookType";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				BookType bt = new BookType();
				bt.setId(rs.getInt(1));
				bt.setTypename(rs.getString(2));
				list.add(bt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeCon(conn);
		}
		return list;
	}
}
