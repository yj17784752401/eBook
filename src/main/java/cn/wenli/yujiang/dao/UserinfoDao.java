package cn.wenli.yujiang.dao;

import cn.wenli.yujiang.entity.Userinfo;

public interface UserinfoDao {
public void add(Userinfo userinfo) throws Exception;
public Userinfo selectUserByName(String username) throws Exception;
}
