package cn.wenli.yujiang.biz.impl;

import java.util.List;

import cn.wenli.yujiang.biz.BookBiz;
import cn.wenli.yujiang.dao.BookDao;
import cn.wenli.yujiang.dao.impl.BookDaoImpl;
import cn.wenli.yujiang.entity.Books;

public class BookBizImpl implements BookBiz {
	BookDao bookDao =new BookDaoImpl();
	@Override
	public List<Books> selectBookByCurrent(int currentPage,int pageSize) throws Exception {	
		return bookDao.selectBookByCurrent(currentPage,pageSize);
	}
	@Override
	public int selectAllBooks() throws Exception {
		// TODO Auto-generated method stub
		return bookDao.selectAllBooks();
	}
	@Override
	public Books selectBooksByBid(int bid) throws Exception {
		// TODO Auto-generated method stub
		return bookDao.selectBooksByBid(bid);
	}
	@Override
	public void updateStockByid(int bid, int count) throws Exception {
		// TODO Auto-generated method stub
		bookDao.updateStockByid(bid, count);
	}
	@Override
	public List<Books> searchBookByname(String bookname) throws Exception {
		// TODO Auto-generated method stub
		return bookDao.searchBookByname(bookname);
	}

}
