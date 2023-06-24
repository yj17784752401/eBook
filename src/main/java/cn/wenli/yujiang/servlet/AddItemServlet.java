package cn.wenli.yujiang.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wenli.yujiang.biz.ItemBiz;
import cn.wenli.yujiang.biz.OrderBiz;
import cn.wenli.yujiang.biz.impl.ItemBizImpl;
import cn.wenli.yujiang.biz.impl.OrderBizImpl;
import cn.wenli.yujiang.entity.Items;
import cn.wenli.yujiang.entity.Orders;


@WebServlet("/addItemServlet")
public class AddItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ItemBiz itemBiz =new ItemBizImpl();
    OrderBiz orderBiz =new OrderBizImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取当前用户：
		String username =(String) request.getSession().getAttribute("loginuser");
		Orders orders =new Orders();
		orders.setUsername(username);
		try {
			orderBiz.addOrder(username);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String count_str = request.getParameter("count");
		Integer count = Integer.valueOf(count_str);
		for(int i = 1;i<count;i++) {
			String bid_str = request.getParameter("hidden_bid_"+i);
			String book_count = request.getParameter("nums_"+i);
			String book_total_price = request.getParameter("hidden_book_total_price_"+i);
			String hidden_total_price = request.getParameter("hidden_total_price");
			Items item =new Items();
			item.setOid(i);
			item.setBid(Integer.valueOf(bid_str));
			Date date =new Date();
			SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
			item.setCreatedate(dateFormat.format(date.getTime()));
			item.setCount(Integer.valueOf(book_count));
			item.setPrice(book_total_price);
			item.setTotal_price(hidden_total_price);
			try {
				itemBiz.addItemByBid(item);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		request.getSession().removeAttribute("books_in_cart");
		request.getSession().removeAttribute("books_in_cart_count");
		response.sendRedirect("/yujiang/showOrderServlet");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
