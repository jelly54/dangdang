package com.dangdang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dangdang.bean.Book;

public class CartDao extends BaseDao {
	/**
	 * 想购物车添加书籍ﳵ
	 * @param bookid
	 * @param booksum
	 * @param userid
	 * @return
	 */
	public int addCart(int bookid, int booksum, int userid) {
		int msg = 0;
		Connection conn = getCon();
		try {
			String sql = "insert into cart(user_id,book_id,book_sum)value(?,?,?)";
			PreparedStatement ps;
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userid);
			ps.setInt(2, bookid);
			ps.setInt(3, booksum);
			msg = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeCon(conn);
		}
		return msg;
	}

	/**
	 * 从购物车删除书ﳵ
	 * @param bookid
	 * @return
	 */
	public int dellCart(int bookid) {
		int msg = 0;
		Connection conn = getCon();
		try {
			String sql = "delete from cart where book_id=?";
			PreparedStatement ps;
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bookid);
			msg = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeCon(conn);
		}
		return msg;
	}

	/**
	 * 为购物车获取书的列表
	 * @param userid
	 * @return
	 */
	public List<Book> getBooksForCarrt(int userid) {
		List<Book> list = new ArrayList<>();
		Connection conn = getCon();
		String sql = "select b.book_id,book_name,book_price,book_count,book_discount,book_author,book_bpublic,book_info,book_cover,c.book_sum from book as b,cart as c where b.book_id=c.book_id and c.user_id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setObject(1, userid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Book b = new Book();
				b.setBookid(rs.getInt("book_id"));
				b.setBookName(rs.getString("book_name"));
				b.setPrice(rs.getDouble("book_price"));
				b.setCount(rs.getInt("book_count"));
				b.setDiscount(rs.getFloat("book_discount"));
				b.setAuthor(rs.getString("book_author"));
				b.setBpublic(rs.getString("book_bpublic"));
				b.setIntroduce(rs.getString("book_info"));
				b.setCover(rs.getString("book_cover"));
				b.setBookbuysum(Integer.parseInt(rs.getString("book_sum")));
				// ��book������뼯��
				list.add(b);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeCon(conn);
		}
		return list;
	}

	/**
	 * 获得已经有的书的数量
	 * @param userid
	 * @param bookid
	 * @return
	 */
	public int getHaveBook(int userid,int bookid){
		int booksum=0;
		Connection conn = getCon();
		String sql = "select book_sum from cart,book where book.book_id=cart.book_id and cart.user_id=? and cart.book_id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setObject(1, userid);
			ps.setObject(2, bookid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				booksum = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeCon(conn);
		}
		return booksum;
	}
	/**
	 * 更新书的数量
	 * @param bookid
	 * @param userid
	 * @param booksum
	 */
	public void updeatBookSum(int bookid,int userid,int booksum){
		Connection conn = getCon();
		try {
			String sql = "update cart set book_sum=? where user_id=? and book_id=?";
			PreparedStatement ps;
			ps = conn.prepareStatement(sql);
			ps.setInt(1, booksum);
			ps.setInt(2, userid);
			ps.setInt(3, bookid);
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeCon(conn);
		}
	}
	/**
	 * 计算购物车中所有商品的价钱
	 * @return
	 */
	public float countPrice(int userID) {
		float allPrice = (float) 0.00;
		Connection conn = getCon();
		try {
			String sql = "SELECT SUM(ROUND(b.book_price*(b.book_discount/100)*c.book_sum,2))"+
					" FROM cart AS c ,book AS b ,user AS u" +
					" WHERE c.user_id = ? AND c.book_Id = b.book_id AND c.user_id=u.id ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				allPrice = rs.getFloat(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeCon(conn);
		}
		return allPrice;
	}
}
