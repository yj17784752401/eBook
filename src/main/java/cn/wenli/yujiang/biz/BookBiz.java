package cn.wenli.yujiang.biz;

import java.util.List;

import cn.wenli.yujiang.entity.Books;

public interface BookBiz {
public List<Books> selectBookByCurrent(int currentPage,int pageSize)throws Exception;
public int selectAllBooks() throws Exception;
public Books selectBooksByBid(int bid) throws Exception;
public void updateStockByid(int bid, int count)throws Exception;
public List<Books> searchBookByname(String bookname)throws Exception;
}
