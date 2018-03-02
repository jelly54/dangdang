package com.dangdang.bean;
/**
 * 书籍的bean
 * @author Jelly
 */
public class Book {
	//书籍的id
	private int bookid;
	//书籍的名字
	private String bookName;
	//书籍的价格
	private double price;
	//书籍的折扣
	private float discount;
	//书籍的作者
	private String author;
	//书籍的出版社
	private String bpublic;
	//书籍现有的数量
	private int count;
	//书籍封面存放的地址
	private String cover;
	//书籍的类型
	private int booktype;
	//书籍的介绍
	private String introduce;
	//书籍要购买的数量
	private int bookbuysum;
	
	public int getBookbuysum() {
		return bookbuysum;
	}
	public void setBookbuysum(int bookbuysum) {
		this.bookbuysum = bookbuysum;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getBpublic() {
		return bpublic;
	}
	public void setBpublic(String bpublic) {
		this.bpublic = bpublic;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public int getBooktype() {
		return booktype;
	}
	public void setBooktype(int booktype) {
		this.booktype = booktype;
	}
	@Override
	public String toString() {
		return "Book [bookid=" + bookid + ", bookName=" + bookName + ", price=" + price + ", discount=" + discount
				+ ", author=" + author + ", bpublic=" + bpublic + ", count=" + count + ", cover=" + cover
				+ ", booktype=" + booktype + ", introduce=" + introduce + ", bookbuysum=" + bookbuysum + "]";
	}
	
}
