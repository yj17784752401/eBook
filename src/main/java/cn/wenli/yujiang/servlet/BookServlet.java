package cn.wenli.yujiang.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.Document;

import cn.wenli.yujiang.biz.BookBiz;
import cn.wenli.yujiang.biz.impl.BookBizImpl;
import cn.wenli.yujiang.entity.Books;
import cn.wenli.yujiang.util.PageTools;

@WebServlet("/bookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BookBiz bookBiz =new BookBizImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			String current_page = request.getParameter("current_page");
			int currentPage = current_page==null?1:Integer.valueOf(current_page);
//			获取图书信息	
			try {
				List<Books> books = bookBiz.selectBookByCurrent(currentPage, PageTools.pageSize);
				int count = bookBiz.selectAllBooks();
				request.setAttribute("books", books);
				int totalPage = (int) Math.ceil(count/PageTools.pageSize) ;
				request.setAttribute("current_page", currentPage);
				request.setAttribute("totalPage", totalPage);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		request.getRequestDispatcher("main.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
