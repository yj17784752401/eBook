package cn.wenli.yujiang.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;



import cn.wenli.yujiang.dao.ItemDao;


import cn.wenli.yujiang.entity.Items;



public class ItemDaoImpl implements ItemDao {
	private String url="jdbc:mysql://localhost:3306/yujiang?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&createDatabaseIfNotExist=true";
	private String username1="root";
	private String password1="123456";
	@Override
	public void addItemByBid(Items item) throws Exception {
		// TODO Auto-generated method stub
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection(url, username1, password1);
					String sql = "insert into items values(null,?,?,?,?,?,?)";
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, item.getOid());
					pstmt.setInt(2, item.getBid());
					pstmt.setString(3, item.getCreatedate());
					pstmt.setInt(4, item.getCount());
					pstmt.setString(5, item.getPrice());
					pstmt.setString(6, item.getTotal_price());
					int executeUpdate = pstmt.executeUpdate();
					System.out.println("Item中加入了:"+executeUpdate+"条订单");
					pstmt.close();
					conn.close();
				
	}
}
