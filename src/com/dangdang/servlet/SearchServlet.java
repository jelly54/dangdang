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
 * 用于界面搜索框的servlet
 * 
 * @author Jelly
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取界面要搜索的产品名字
		String name = request.getParameter("name");
		// 调用bookdao中的方法进行模糊查询
		BookDao bookdao = new BookDao();
		List<Book> blist = bookdao.getBooksBySearch(name);
		// 查询侧边栏，产品分类列表的数据
		TypeDao typedao = new TypeDao();
		List<BookType> tlist = typedao.getTypes();
		// 将符合查询的列表，侧边栏的数据 添加到request作用域，用于在index界面展示
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
