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
 * 添加购物车的servlet
 * 
 * @author Jelly
 */
public class CartSerevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 从界面获取加入购物车产品的数量和id
		 */
		int booksum = Integer.parseInt(request.getParameter("buysum"));
		int bookid = Integer.parseInt(request.getParameter("bookid"));
		// 从session域中获取当前登录的用户名
		String username = (String) request.getSession().getAttribute("username");
		// 根据用户名获取id
		UserDao userdao = new UserDao();
		int userid = userdao.getIDByName(username);
		// 在购物车中检查该用户是否已经添加过该种商品
		CartDao cartdao = new CartDao();
		int bsum = cartdao.getHaveBook(userid, bookid);
		if (bsum == 0) {
			// 未添加过，向购物车中添加用户id及购买的书
			cartdao.addCart(bookid, booksum, userid);
		} else {
			// 之前添加过该商品，只更新添加的数量
			cartdao.updeatBookSum(bookid, userid, booksum + bsum);
		}
		//计算商品总价
		int userID = userdao.getIDByName(username);
		CartDao cartDao = new CartDao();
		float allPrice = cartDao.countPrice(userID);
		// 获取当前用户购物车中的数据，返回list集合
		List<Book> blist = cartdao.getBooksForCarrt(userid);
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
