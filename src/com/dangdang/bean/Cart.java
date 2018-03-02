package com.dangdang.bean;
/**
 * 购物车bean
 * @author Jelly
 */
public class Cart {

	private int id;//购物id
	private int bookId;//添加书籍的id
	private int bookSum;//要买的数量
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getBookSum() {
		return bookSum;
	}
	public void setBookSum(int bookSum) {
		this.bookSum = bookSum;
	}
	

}
