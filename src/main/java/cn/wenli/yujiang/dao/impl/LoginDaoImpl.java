package cn.wenli.yujiang.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.wenli.yujiang.dao.LoginDao;
import cn.wenli.yujiang.entity.Userinfo;

public class LoginDaoImpl implements LoginDao {
	private String url="jdbc:mysql://localhost:3306/yujiang?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&createDatabaseIfNotExist=true";
	private String username1="root";
	private String password1="123456";
	@Override
	public Userinfo selectUser(String username,String password) throws Exception {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username1, password1);
		String sql = "select * from userinfo where Username=? and Password=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, username);
		pstmt.setString(2, password);
		ResultSet rs = pstmt.executeQuery();
		Userinfo userinfo2 =new Userinfo();
		while(rs.next()) {
			userinfo2.setUsername(rs.getString(1));
			userinfo2.setPassword(rs.getString(2));
		}
		rs.close();
		pstmt.close();
		conn.close();
		return userinfo2;
	}

}
