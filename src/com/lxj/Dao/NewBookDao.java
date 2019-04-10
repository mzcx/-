package com.lxj.Dao;

import java.util.List;
import java.sql.Date;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSet;
import com.lxj.model.BookInfo;
import com.lxj.model.Order;
import com.lxj.model.OrderAndBookInfo;
import com.lxj.util.JDBC;

public class NewBookDao {
	//InsertBookOrder(ISBN.getText().trim(), java.sql.Date.valueOf(orderDate.getText().trim()), orderNumber.getText().trim(), operator.getText().trim(), checkAndAccept,zks)
	//selectBookOrder()
	//UpdateCheckBookOrder(ISBNs)
	//selectBookOrder(ISBN.getText().trim()).isEmpty())
	//
	/*
	 * 订购图书相关操作
	 */
	/*
	 * 插入新购图书方法
	 */
	public static int InsertBookOrder(String ISBN,Date date,String number,String operator,String checkAndAccept,Double zks) {
		int i=0;
		try {
			String sql="insert into tb_order(ISBN,orderdate,number,operator,checkAndAccept,zk) values ('"+ISBN+"',"
					+ "'"+date+"',"+number+",'"+operator+"',"+checkAndAccept+",'"+zks+"')";
			i=JDBC.executeUpdate(sql);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		JDBC.close();
		return i;
	}
	/*
	 * 查询新购图书相关信息
	 */
	public static List selectBookOrder() {
		List list=new ArrayList();
		String sql="select * from tb_order,tb_bookinfo where tb_order.ISBN=tb_bookinfo.ISBN";
		java.sql.ResultSet rs=JDBC.executeQuery(sql);
		try {
			while(rs.next()) {
				OrderAndBookInfo order=new OrderAndBookInfo();
				order.setISBN(rs.getString("ISBN"));
				order.setDate(rs.getDate("date"));
				order.setNumber(rs.getString("number"));
				order.setOperator(rs.getString("operator"));
				order.setBookname(rs.getString("bookname"));
				order.setWriter(rs.getString("writer"));
				order.setTraslator(rs.getString("translator"));
				order.setPublisher(rs.getString("publisher"));
				order.setOrderdate(rs.getDate("orderdate"));
				order.setTypeId(rs.getString("typeId"));
				order.setPrice(rs.getDouble("price"));
				order.setCheckAndAccept(rs.getString("checkAndAccept"));
				order.setZk(rs.getDouble("zk"));
				list.add(order);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		JDBC.close();
		return list;
	}
	public static List selectBookOrder(String ISBN) {//根据图书编号查询图书
		List list=new ArrayList();//保存所有查询到书籍信息
		String sql = "select *  from tb_order where ISBN='"+ISBN+"'";
		java.sql.ResultSet rs = JDBC.executeQuery(sql);//执行查询
		try {
			while (rs.next()) {//遍历结果集
				OrderAndBookInfo order=new OrderAndBookInfo();
				order.setISBN(rs.getString("ISBN"));
				order.setDate(rs.getDate("orderdate"));
				order.setNumber(rs.getString("number"));
				order.setOperator(rs.getString("operator"));
                order.setBookname(rs.getString("bookname"));
				order.setWriter(rs.getString("writer"));
				order.setTraslator(rs.getString("translator"));
				order.setPublisher(rs.getString("publisher"));
				order.setOrderdate(rs.getDate("date"));
				order.setPrice(rs.getDouble("price"));
				order.setCheckAndAccept(rs.getString("checkAndAccept"));
				order.setZk(rs.getDouble("zk"));
				list.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JDBC.close();//关闭连接对象
		return list;//返回查询结果集
	}
	/*
	 * 修改验证信息
	 */
	public static int UpdateCheckBookOrder(String ISBN) {
		int i=0;
		try {
			String sql="update tb_order set checkAndAccept=0 where ISBN='"+ISBN+"'";
		i=JDBC.executeUpdate(sql);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		JDBC.close();
		return i;
		
	}

}
