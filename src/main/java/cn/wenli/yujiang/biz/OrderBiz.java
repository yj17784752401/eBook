package cn.wenli.yujiang.biz;

import java.util.List;

import cn.wenli.yujiang.entity.Items;

public interface OrderBiz {
public void addOrder(String username)throws Exception;
public List<Items> selectItemsByUsername(String username)throws Exception;
}
