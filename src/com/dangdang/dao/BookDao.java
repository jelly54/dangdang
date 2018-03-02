package com.dangdang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dangdang.bean.Book;

/**
 * 用于获取书籍列表，显示在详情界面，和按条件搜索后的界面
 * 
 * @author Jelly
 */
public class BookDao extends BaseDao {
	/**
	 * 获取所有书籍
	 * 
	 * @return list集合
	 */
	public List<Book> getBooks() {

		List<Book> list = new ArrayList<>();
		Connection conn = getCon();
		String sql = "select book_id,book_name,book_price,book_count,book_discount,book_author,book_bpublic,book_info,book_cover,type_id from book";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
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
				// 将book实例添加到list集合中
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
	 * 根据类型获取书籍列表
	 * 
	 * @param id
	 * @return
	 */
	public List<Book> getBooksByType(int id) {
		List<Book> list = new ArrayList<>();
		Connection conn = getCon();
		String sql = "select book_id,book_name,book_price,book_count,book_discount,book_author,book_bpublic,book_info,book_cover,type_id from book where type_id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
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
				// 将book实例添加到list集合中
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
	 * 根据书籍的id获取bookBean
	 * 
	 * @param bookid
	 * @return bookBean
	 */
	public Book getBookByBookId(int bookid) {
		Book book = null;
		Connection conn = getCon();
		String sql = "select book_id,book_name,book_price,book_count,book_discount,book_author,book_bpublic,book_info,book_cover,type_id from book where book_id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setObject(1, bookid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				book = new Book();
				book.setBookid(rs.getInt("book_id"));
				book.setBookName(rs.getString("book_name"));
				book.setPrice(rs.getDouble("book_price"));
				book.setCount(rs.getInt("book_count"));
				book.setDiscount(rs.getFloat("book_discount"));
				book.setAuthor(rs.getString("book_author"));
				book.setBpublic(rs.getString("book_bpublic"));
				book.setIntroduce(rs.getString("book_info"));
				book.setCover(rs.getString("book_cover"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeCon(conn);
		}
		return book;

	}

	/**
	 * 根据搜索获取书籍类表
	 * 
	 * @param name
	 * @return
	 */
	public List<Book> getBooksBySearch(String name) {
		List<Book> list = new ArrayList<>();
		Connection conn = getCon();
		String sql = "select book_id,book_name,book_price,book_count,book_discount,book_author,book_bpublic,book_info,book_cover,type_id from book where book_name like ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + name + "%");
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
				// 将bookbean添加到list中
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeCon(conn);
		}
		return list;
	}

}
