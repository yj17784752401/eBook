package cn.wenli.yujiang.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wenli.yujiang.biz.UserinfoBiz;
import cn.wenli.yujiang.biz.impl.UserinfoBizImpl;
import cn.wenli.yujiang.entity.Userinfo;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserinfoBiz userinfoBiz =new UserinfoBizImpl();
	Userinfo userinfo =new Userinfo();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		userinfo.setUsername(username);
		userinfo.setPassword(password);
		userinfo.setEmail(email);
					try {
						userinfoBiz.add(userinfo);
						request.getRequestDispatcher("/register_success.html").forward(request, response);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
