package cn.wenli.yujiang.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wenli.yujiang.biz.LoginBiz;
import cn.wenli.yujiang.biz.impl.LoginBizImpl;
import cn.wenli.yujiang.entity.Userinfo;


@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginBiz loginBiz =new LoginBizImpl();
	Userinfo userinfo =new Userinfo();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		userinfo.setUsername(username);
		userinfo.setPassword(password);
		try {
			Userinfo userinfo = loginBiz.selectUser(username,password);
			if(userinfo!=null) {
			request.getSession().setAttribute("loginuser", userinfo.getUsername());	
			request.getRequestDispatcher("bookServlet").forward(request, response);
			}
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
