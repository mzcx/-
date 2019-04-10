package com.lxj.Dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lxj.model.BookInfo;
import com.lxj.model.BookType;
import com.lxj.util.JDBC;

public class BookTypeDao {
	private static final String String = null;
	/*
	 * 图书类别表相关操作
	 */
	/*
	 * 插入图书类别方法
	 */
	public static int InsertBookType(String typeName,String days,double fk){
		int i=0;
		try{
			
			String sql="insert into tb_booktype(typeName,days,fk) values('"+typeName+"',"+days+","+fk+")";
		    i=JDBC.executeUpdate(sql);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		JDBC.close();	//关闭连接对象	
		return i;		//返回更新记录数
	}
	/*
	 * 查询图书相关信息
	 * 
	 */

	public static List selectBookType() {
		List list=new ArrayList();
		String sql = "select *  from tb_booktype";
		ResultSet rs = JDBC.executeQuery(sql);
		try {
			while (rs.next()) {
				BookType booktype=new BookType();
				booktype.setId(rs.getString("id"));
				booktype.setTypeName(rs.getString("typeName"));
				booktype.setDays(rs.getString("days"));
				booktype.setFk(rs.getString("fk"));
				list.add(booktype);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JDBC.close();
		return list;
	}
	public static List selectBookType(String id) {//根据图书编号查询图书
		List list=new ArrayList();//保存所有查询到书籍信息
		String sql = "select *  from tb_booktype where id='"+id+"'";
		ResultSet rs = JDBC.executeQuery(sql);//执行查询
		try {
			while (rs.next()) {//遍历结果集
				BookType booktype=new BookType();
				booktype.setId(rs.getString("id"));
				booktype.setTypeName(rs.getString("typeName"));
				booktype.setDays(rs.getString("days"));
				booktype.setFk(rs.getString("fk"));
				list.add(booktype);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JDBC.close();//关闭连接对象
		return list;//返回查询结果集
	}
	/*
	 * 修改图书类别方法
	 */
	public static int Updatebooktype(String id,String typeName,String days, String fk){
		int i=0;//更新记录数
		try{
			String sql="update tb_booktype set typeName='"+typeName+"',days='"+days+"',fk="+fk+" where id="+id+"";
			i=JDBC.executeUpdate(sql);//执行更新
		}catch(Exception e){
			e.printStackTrace();
		}
		JDBC.close();//关闭连接对象
		return i;//返回更新记录数
	}

	/*
	 * 查询类别方法
	 */
	public static List selectBookCategory() {
		List list=new ArrayList();
		String sql = "select *  from tb_bookType";
		ResultSet rs = JDBC.executeQuery(sql);
		try {
			while (rs.next()) {
				BookType bookType=new BookType();
				bookType.setId(rs.getString("id"));
				bookType.setTypeName(rs.getString("typeName"));
				bookType.setDays(rs.getString("days"));
				bookType.setFk(rs.getString("fk"));
				list.add(bookType);
			}
	     } catch (Exception e) {
			e.printStackTrace();
		}
		JDBC.close();
		return list;
		
	}
}