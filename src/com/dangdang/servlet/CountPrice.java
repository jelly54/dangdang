package com.dangdang.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dangdang.dao.CartDao;
import com.dangdang.dao.UserDao;

/**
 * 计算购物车中所有的价钱
 * @author Jelly
 */
public class CountPrice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//获取界面传来的。select改变后的值，username，书的id
		int changesum = Integer.parseInt(request.getParameter("changesum"));
		String username = request.getParameter("username");
		int bookid = Integer.parseInt(request.getParameter("bookid"));
		//根据用户名查询用户id
		UserDao userDao = new UserDao();
		int userid = userDao.getIDByName(username);
		//更新购物车
		CartDao cartDao = new CartDao();
		cartDao.updeatBookSum(bookid, userid, changesum);
		//重新获取总价个
		float allPrice = cartDao.countPrice(userid);
		
		PrintWriter writer = response.getWriter();
		writer.print(allPrice);
		writer.flush();
		writer.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
