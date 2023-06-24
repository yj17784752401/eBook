package cn.wenli.yujiang.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.wenli.yujiang.dao.OrderDao;
import cn.wenli.yujiang.entity.Items;

public class OrderDaoImpl implements OrderDao {
	private String url="jdbc:mysql://localhost:3306/yujiang?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&createDatabaseIfNotExist=true";
	private String username1="root";
	private String password1="123456";
	@Override
	public void addOrder(String username) throws Exception {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username1, password1);
			String sql = "insert into orders values(null,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			int count = pstmt.executeUpdate();
			System.out.println("用户插入成功:"+count);
			pstmt.close();
			conn.close();
	}
	@Override
	public List<Items> selectAllItemByUsername(String username,String[] columns) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username1, password1);
			String sql = "select * from books,items,orders where books.Bid=items.Bid and orders.Oid=items.Oid order by items.oid";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			System.err.println(sql);
			ResultSet rs = pstmt.executeQuery();
			List items =new ArrayList<>();
			while(rs.next()) {
			 Map map=new HashMap<>();
				for(int i=0;i<columns.length;i++) {
				map.put(columns[i], rs.getObject(columns[i]));
				}
				items.add(map);
			}
			System.out.println("items:"+items);
			pstmt.close();
			conn.close();
		return items;
	}

}
