package cn.wenli.yujiang.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.wenli.yujiang.biz.BookBiz;
import cn.wenli.yujiang.biz.ItemBiz;
import cn.wenli.yujiang.biz.impl.BookBizImpl;
import cn.wenli.yujiang.biz.impl.ItemBizImpl;
import cn.wenli.yujiang.dao.BookDao;
import cn.wenli.yujiang.entity.Books;



@WebServlet("/shopListServlet")
public class ShopListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BookBiz bookBiz = new BookBizImpl(); 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String[] bids = request.getParameterValues("bookId");
		List<Books> books_in_cart =(List<Books>) request.getSession().getAttribute("books_in_cart"); 
		if(books_in_cart==null)
			books_in_cart =new ArrayList<>();
		for(int i=0;i<bids.length;i++) {
			Books books =new Books();
			Boolean isNotExists = true;
			int bid = Integer.valueOf(bids[i]);
			try {
				books = bookBiz.selectBooksByBid(bid);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(int m=0;m<books_in_cart.size();m++) {
			Books exist_books =books_in_cart.get(m);
			if(exist_books.getBid()== bid) {
				books_in_cart.remove(m);
				String total_price_str =exist_books.getB_price();
				books_in_cart.add(exist_books);
				exist_books.setCount(exist_books.getCount()+1);
				isNotExists = false;
				System.out.println("bookscount:"+exist_books.getCount());
				try {
					bookBiz.updateStockByid(bid,1);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			}
			if(!isNotExists)
				continue;
			
		books.setBid(bid);
		books.setStock(books.getStock()-books.getCount());
		books.setCount(1);
		try {
			bookBiz.updateStockByid(bid,1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		books_in_cart.add(books);
		System.out.println("bid.length:"+bids.length);
		System.out.println("books:"+books);
		System.out.println("books_in_cart:"+books_in_cart);
		}
		request.getSession().setAttribute("books_in_cart", books_in_cart);
		request.getSession().setAttribute("books_in_cart_count", books_in_cart.size());
		request.getRequestDispatcher("shopping-success.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
