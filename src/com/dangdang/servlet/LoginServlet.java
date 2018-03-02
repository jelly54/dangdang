package com.dangdang.servlet;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dangdang.bean.User;
import com.dangdang.dao.UserDao;

/**
 * 用于校验用户是否登录的servlet
 * 
 * @author Jelly
 */
public class LoginServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置页面编码集为 UTF-8
		request.setCharacterEncoding("UTF8");
		// 获取界面传来的用户名，密码
		String username = request.getParameter("username");
		String userpass = request.getParameter("userpass");
		//
		if (username != null && userpass != null) {
			UserDao userdao = new UserDao();
			// 判断登录用户是否存在
			User user = userdao.getUserByName(username);
			String dbpass = userdao.getPassByName(username);

			if (user == null) {// 登录用户不存在返回登录界面，提交错误信息
				request.setAttribute("error", "error");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} else if (userpass.equals(dbpass)) {// 登录名存在，判断密码是否和数据库中的一致
				request.getSession().setAttribute("username", username);
				response.sendRedirect("IndexServlet");
			}
		} else {// 登录名存在，但是密码错误
			request.setAttribute("error", "fail");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
