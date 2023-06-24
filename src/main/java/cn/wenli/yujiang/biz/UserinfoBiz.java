package cn.wenli.yujiang.biz;

import cn.wenli.yujiang.entity.Userinfo;

public interface UserinfoBiz {
	public void add(Userinfo userinfo) throws Exception;
	public Userinfo selectUserByName(String username) throws Exception;
}
