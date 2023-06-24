package cn.wenli.yujiang.test;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import cn.wenli.yujiang.biz.BookBiz;
import cn.wenli.yujiang.biz.OrderBiz;
import cn.wenli.yujiang.biz.UserinfoBiz;
import cn.wenli.yujiang.biz.impl.BookBizImpl;
import cn.wenli.yujiang.biz.impl.OrderBizImpl;
import cn.wenli.yujiang.biz.impl.UserinfoBizImpl;
import cn.wenli.yujiang.dao.BookDao;
import cn.wenli.yujiang.dao.OrderDao;
import cn.wenli.yujiang.dao.UserinfoDao;
import cn.wenli.yujiang.dao.impl.BookDaoImpl;
import cn.wenli.yujiang.dao.impl.OrderDaoImpl;
import cn.wenli.yujiang.dao.impl.UserinfoDaoImpl;
import cn.wenli.yujiang.entity.Books;
import cn.wenli.yujiang.entity.Items;
import cn.wenli.yujiang.entity.Userinfo;
import cn.wenli.yujiang.util.PageTools;

public class UnitTest {
	UserinfoDao userinfoDao =new UserinfoDaoImpl();
	Userinfo userinfo=new Userinfo();
	//测试添加用户
@Test
public void Test() throws Exception {
	userinfo.setUsername("余江");
	userinfo.setPassword("123456");
	userinfo.setEmail("1306879592@qq.com");
	userinfoDao.add(userinfo);
}
//测试查询用户
@Test
public void Test2() throws Exception {
	Userinfo user1 = userinfoDao.selectUserByName("王艳红");
	System.out.println(user1);

}
@Test
public void Test3() throws Exception {
UserinfoBiz userinfoBiz =new UserinfoBizImpl();
System.out.println(userinfoBiz.selectUserByName("余江"));
if (userinfoBiz.selectUserByName("余江")!=null) {
	System.out.println(1);
}
else {
	System.out.println(2);
}
}
@Test
public void Test4() throws Exception {
	BookBiz bookBiz =new BookBizImpl();
	List<Books> seletAllBook = bookBiz.selectBookByCurrent(2,4);
	System.out.println(seletAllBook);
}
@Test
public void Test5() throws Exception {
		BookDao bookDao =new BookDaoImpl();
		System.out.println("分页"+bookDao.selectBookByCurrent(1, PageTools.pageSize));
		System.out.println(bookDao.selectAllBooks());
}
@Test
public void Test6() {
	Date date = new Date();
	 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    System.out.println(dateFormat.format(date.getTime()));
}
@Test
public void Test7() throws Exception {
	OrderBiz orderBiz=new OrderBizImpl();
	List selectItemsByUsername = orderBiz.selectItemsByUsername("余江");
	System.out.println(selectItemsByUsername.size());
	System.out.println(selectItemsByUsername);
}
@Test
public void Test8() throws Exception {
	BookDao bookDao =new BookDaoImpl();
	List<Books> searchBookByname = bookDao.searchBookByname("泰");
	System.out.println(searchBookByname);
}
}
