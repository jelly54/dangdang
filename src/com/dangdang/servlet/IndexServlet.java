package com.dangdang.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dangdang.bean.Book;
import com.dangdang.bean.BookType;
import com.dangdang.dao.BookDao;
import com.dangdang.dao.TypeDao;

/**
 * 用于在主页显示各项数据的servlet
 * 
 * @author Jelly
 */
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取所有的书籍，返回list集合
		BookDao bd = new BookDao();
		List<Book> blist = bd.getBooks();
		// 获取侧边栏类别列表，返回list集合
		TypeDao td = new TypeDao();
		List<BookType> tlist = td.getTypes();
		// 将产品对象和类别列表添加到request作用域中，用于接下来在index界面的显示
		request.setAttribute("blist", blist);
		request.setAttribute("tlist", tlist);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
