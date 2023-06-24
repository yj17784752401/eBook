package cn.wenli.yujiang.biz.impl;

import cn.wenli.yujiang.biz.UserinfoBiz;
import cn.wenli.yujiang.dao.UserinfoDao;
import cn.wenli.yujiang.dao.impl.UserinfoDaoImpl;
import cn.wenli.yujiang.entity.Userinfo;

public class UserinfoBizImpl implements UserinfoBiz {
	UserinfoDao userinfoDao =new UserinfoDaoImpl();
	@Override
	public void add(Userinfo userinfo) throws Exception {
		// TODO Auto-generated method stub
		 userinfoDao.add(userinfo);
	}

	@Override
	public Userinfo selectUserByName(String username) throws Exception {
		// TODO Auto-generated method stub
		return userinfoDao.selectUserByName(username);
	}

}
