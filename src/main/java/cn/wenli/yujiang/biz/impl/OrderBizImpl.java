package cn.wenli.yujiang.biz.impl;

import java.util.List;

import cn.wenli.yujiang.biz.OrderBiz;
import cn.wenli.yujiang.dao.OrderDao;
import cn.wenli.yujiang.dao.impl.OrderDaoImpl;
import cn.wenli.yujiang.entity.Items;

public class OrderBizImpl implements OrderBiz {
	OrderDao orderDao =new OrderDaoImpl();
	@Override
	public void addOrder(String username) throws Exception {
		// TODO Auto-generated method stub
		orderDao.addOrder(username);
	}
	@Override
	public List<Items> selectItemsByUsername(String username) throws Exception {
		// TODO Auto-generated method stub
		String[] columns= {"oid","username","bid","createdate","image","bookname","price","total_price","count"};
		return orderDao.selectAllItemByUsername(username, columns);
	}

}
