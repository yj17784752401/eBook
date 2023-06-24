package cn.wenli.yujiang.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.wenli.yujiang.dao.BookDao;
import cn.wenli.yujiang.entity.Books;
public class BookDaoImpl implements BookDao {
	private String url="jdbc:mysql://localhost:3306/yujiang?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&createDatabaseIfNotExist=true";
	private String username1="root";
	private String password1="123456";
	@Override
	public List<Books> selectBookByCurrent(int currentPage,int pageSize) throws Exception {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username1, password1);
		String sql = "select * from books limit ?,?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, (currentPage-1)*pageSize);
		pstmt.setInt(2, pageSize);
		ResultSet rs = pstmt.executeQuery();
		List<Books> books= new ArrayList<>();
		while(rs.next()) {
			Books book =new Books();
			book.setBid(rs.getInt(1));
			book.setBookname(rs.getString(2));
			book.setB_price(rs.getString(3));
			book.setImage(rs.getString(4));
			book.setStock(rs.getInt(5));
			books.add(book);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return books;
	}
	@Override
	public int selectAllBooks() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username1, password1);
		String sql = "select * from books ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		int count=0;
		while(rs.next()) {
			count++;
		}
		rs.close();
		pstmt.close();
		conn.close();
		return count;
	}
	@Override
	public Books selectBooksByBid(int bid) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username1, password1);
		String sql = "select * from books where bid=? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bid);
		ResultSet rs = pstmt.executeQuery();
		Books book = new Books();
		while(rs.next()) {	
			book.setBid(rs.getInt(1));
			book.setBookname(rs.getString(2));
			book.setB_price(rs.getString(3));
			book.setImage(rs.getString(4));
			book.setStock(rs.getInt(5));
		}
		rs.close();
		pstmt.close();
		conn.close();
		return book;
	}
	@Override
	public void updateStockByid(int bid, int count) throws Exception {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username1, password1);
		String sql = "update books set Stock=Stock-? where bid= ?   ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, count);
		pstmt.setInt(2, bid);
		int stock = pstmt.executeUpdate();
		System.out.println("库存修改了"+stock);
		pstmt.close();
		conn.close();
	}
	@Override
	public List<Books> searchBookByname(String bookname) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username1, password1);
		String sql = "select * from books where BookName like '%" + bookname + "%'"; 
		System.out.println(sql);
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		List<Books> books =new ArrayList<>();
		while(rs.next()) {	
			Books book = new Books();
			book.setBid(rs.getInt(1));
			book.setBookname(rs.getString(2));
			book.setB_price(rs.getString(3));
			book.setImage(rs.getString(4));
			book.setStock(rs.getInt(5));
			books.add(book);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return books;
	}

}
