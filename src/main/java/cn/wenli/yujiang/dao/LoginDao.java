package cn.wenli.yujiang.dao;

import cn.wenli.yujiang.entity.Userinfo;

public interface LoginDao {
public Userinfo selectUser(String username,String password) throws Exception;
}
