package cn.wenli.yujiang.biz.impl;

import cn.wenli.yujiang.biz.LoginBiz;
import cn.wenli.yujiang.dao.LoginDao;
import cn.wenli.yujiang.dao.impl.LoginDaoImpl;
import cn.wenli.yujiang.entity.Userinfo;

public class LoginBizImpl implements LoginBiz {

	@Override
	public Userinfo selectUser(String username,String password) throws Exception {
		// TODO Auto-generated method stub
		LoginDao loginDao =new LoginDaoImpl();
		return loginDao.selectUser(username,password);
	}

}
