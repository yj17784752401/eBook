package cn.wenli.yujiang.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wenli.yujiang.biz.OrderBiz;
import cn.wenli.yujiang.biz.impl.OrderBizImpl;
import cn.wenli.yujiang.entity.Items;


@WebServlet("/showOrderServlet")
public class ShowOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	OrderBiz orderBiz =new OrderBizImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username =(String) request.getSession().getAttribute("loginuser");
		System.out.println(username);
		try {
			List orders = orderBiz.selectItemsByUsername(username);
			System.out.println("orders:"+orders);
			request.setAttribute("orders", orders);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("orderlist.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
