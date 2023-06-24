package cn.wenli.yujiang.biz.impl;

import cn.wenli.yujiang.biz.ItemBiz;
import cn.wenli.yujiang.dao.ItemDao;
import cn.wenli.yujiang.dao.impl.ItemDaoImpl;
import cn.wenli.yujiang.entity.Items;
import cn.wenli.yujiang.entity.Orders;

public class ItemBizImpl implements ItemBiz {
	ItemDao itemDao =new ItemDaoImpl();

	@Override
	public void addItemByBid(Items item) throws Exception {
		// TODO Auto-generated method stub
		itemDao.addItemByBid(item);
	}


}
