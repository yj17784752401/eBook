package cn.wenli.yujiang.biz;

import cn.wenli.yujiang.entity.Userinfo;

public interface LoginBiz {
public Userinfo selectUser(String username,String password)throws Exception;
}
