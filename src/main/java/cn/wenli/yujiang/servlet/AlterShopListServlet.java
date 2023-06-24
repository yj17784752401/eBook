package cn.wenli.yujiang.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.xdevapi.ModifyStatement;

import cn.wenli.yujiang.biz.BookBiz;
import cn.wenli.yujiang.biz.impl.BookBizImpl;
import cn.wenli.yujiang.entity.Books;


@WebServlet("/alterShopListServlet")
public class AlterShopListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

BookBiz bookBiz=new BookBizImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if (action.equals("remove")) 
			remove(request,response);
		else if(action.equals("modify"))
			modify(request,response);
	}
	private void remove(HttpServletRequest request,HttpServletResponse response) {
		String bid_str = request.getParameter("bid");
		Integer bid = Integer.valueOf(bid_str);
		List<Books> books_in_cart = (List<Books>)request.getSession().getAttribute("books_in_cart");
		for(int i=0;i<books_in_cart.size();i++) {
			Books book=books_in_cart.get(i);
			if(bid==book.getBid()) {
				books_in_cart.remove(i);
				try {
					bookBiz.updateStockByid(bid, book.getCount());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		}
		request.getSession().setAttribute("books_in_cart_count", books_in_cart.size());
	}
	private void modify(HttpServletRequest request,HttpServletResponse response) {
		String bid_str = request.getParameter("bid");
		String count_str = request.getParameter("count");
		Integer bid = Integer.valueOf(bid_str);
		Integer new_count = Integer.valueOf(count_str);
		List<Books> books_in_cart =(List<Books>) request.getSession().getAttribute("books_in_cart");
		for(int i=0;i<books_in_cart.size();i++) {
			Books book=books_in_cart.get(i);
			if(bid==book.getBid()) {
				int old_count = book.getCount();
				book.setCount(new_count);
				try {
					bookBiz.updateStockByid(bid, new_count-old_count);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
