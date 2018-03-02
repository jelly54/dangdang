package com.dangdang.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dangdang.bean.Book;
import com.dangdang.bean.BookType;
import com.dangdang.dao.BookDao;
import com.dangdang.dao.TypeDao;

/**
 * 用于主页点击后展示相应产品的详细数据的servlet
 * 
 * @author Jelly
 */
public class DetilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取界面点击的产品的id
		int bookid = Integer.parseInt(request.getParameter("bookid"));
		// 根据id 获取该产品信息
		BookDao bd = new BookDao();
		Book book = bd.getBookByBookId(bookid);
		// 展示在侧边栏的类别栏
		TypeDao td = new TypeDao();
		List<BookType> tlist = td.getTypes();
		// 将产品对象和类别列表添加到request作用域中，用于接下来在detail界面的显示
		request.setAttribute("book", book);
		request.setAttribute("tlist", tlist);
		request.getRequestDispatcher("detil.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
