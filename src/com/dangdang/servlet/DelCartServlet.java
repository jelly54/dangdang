package com.dangdang.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dangdang.bean.Book;
import com.dangdang.dao.CartDao;
import com.dangdang.dao.UserDao;

/**
 * 用于购物车中删除相应的产品的servlet
 * 
 * @author Jelly
 */
public class DelCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取界面传来的bookid
		int bookid = Integer.parseInt(request.getParameter("bookid"));
		// 将该id在购物车对应的数据删除
		CartDao cartdao = new CartDao();
		cartdao.dellCart(bookid);
		// 在session作用域中获取当前登录用户的用户名
		String username = (String) request.getSession().getAttribute("username");
		UserDao userdao = new UserDao();
		int userid = userdao.getIDByName(username);
		// 获取当前用户购物车中的数据，返回list集合
		List<Book> blist = cartdao.getBooksForCarrt(userid);
		//重新获取总价个
		float allPrice = cartdao.countPrice(userid);
		// 将books集合添加到request作用域，用于接下来在cart界面展示
		request.setAttribute("books", blist);
		request.setAttribute("allPrice", allPrice);
		request.getRequestDispatcher("cart.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
