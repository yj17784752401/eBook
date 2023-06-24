package cn.wenli.yujiang.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import cn.wenli.yujiang.dao.UserinfoDao;
import cn.wenli.yujiang.entity.Userinfo;

public class UserinfoDaoImpl implements UserinfoDao {
	private String url="jdbc:mysql://localhost:3306/yujiang?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&createDatabaseIfNotExist=true";
	private String username="root";
	private String password="123456";
	@Override
	public void add(Userinfo userinfo) throws Exception {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = "insert into userinfo values(?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userinfo.getUsername());
		pstmt.setString(2, userinfo.getPassword());
		pstmt.setString(3, userinfo.getEmail());
		int count = pstmt.executeUpdate();
		System.out.println("注册成功:"+count);
		pstmt.close();
		conn.close();
	}
	@Override
	public Userinfo selectUserByName(String userName) throws Exception {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = "select * from userinfo where Username=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userName);
		ResultSet rs = pstmt.executeQuery();
		Userinfo userinfo = new Userinfo();
		while(rs.next()) {
			userinfo.setUsername(rs.getString(1));
			userinfo.setPassword(rs.getString(2));
			userinfo.setEmail(rs.getString(3));
		}
		rs.close();
		pstmt.close();
		conn.close();
		return userinfo;
	}
	

}
