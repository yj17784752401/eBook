package cn.wenli.yujiang.dao;

import java.util.List;

import cn.wenli.yujiang.entity.Items;

public interface OrderDao {
public void addOrder(String username)throws Exception;
public List<Items> selectAllItemByUsername(String username,String[] columns)throws Exception;
}
