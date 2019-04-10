package com.lxj.Dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lxj.model.BookInfo;
import com.lxj.model.BookType;
import com.lxj.util.JDBC;

public class BookInfoDao {
	/*
	 * 图书信息表相关操作
	 */
	/*
	 * 插入图书信息方法
	 */
	public static int Insertbook(String ISBN,String typeId,String bookname,
			String writer,String translator,String publisher,Date date,Double price){
		int i=0;
		try{
			String sql="insert into tb_bookInfo(ISBN,typeId,bookname,writer,translator," +
					"publisher,date,price) values('"+ISBN+"','"+typeId+"','"+bookname+"'," +
					"'"+writer+"','"+translator+"','"+publisher+"','"+date+"',"+price+")";
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

	public static List selectBookInfo() {
		List list=new ArrayList();
		String sql = "select *  from tb_bookInfo";
		ResultSet rs = JDBC.executeQuery(sql);
		try {
			while (rs.next()) {
				BookInfo bookinfo=new BookInfo();
				bookinfo.setISBN(rs.getString("ISBN"));
				bookinfo.setTypeId(rs.getString("typeId"));
				bookinfo.setBookName(rs.getString("bookname"));
				bookinfo.setWriter(rs.getString("writer"));
				bookinfo.setTranslator(rs.getString("translator"));
				bookinfo.setPublisher(rs.getString("publisher"));
				bookinfo.setDate(rs.getDate("date"));
				bookinfo.setPrice(rs.getDouble("price"));
				list.add(bookinfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JDBC.close();
		return list;
	}
	public static List selectBookInfo(String ISBN) {//根据图书编号查询图书
		List list=new ArrayList();//保存所有查询到书籍信息
		String sql = "select *  from tb_bookInfo where ISBN='"+ISBN+"'";
		ResultSet rs = JDBC.executeQuery(sql);//执行查询
		try {
			while (rs.next()) {//遍历结果集
				BookInfo bookinfo=new BookInfo();//书籍信息对象
				bookinfo.setISBN(rs.getString("ISBN"));//设置书籍编号
				bookinfo.setTypeId(rs.getString("typeId"));//设置类别编号
				bookinfo.setBookName(rs.getString("bookname"));//设置书籍名称
				bookinfo.setWriter(rs.getString("writer"));//设置作者
				bookinfo.setTranslator(rs.getString("translator"));//设置译者
				bookinfo.setPublisher(rs.getString("publisher"));//设置出版社
				bookinfo.setDate(rs.getDate("date"));//设置出版日期
				bookinfo.setPrice(rs.getDouble("price"));//设置价格
				list.add(bookinfo);//添加书籍信息
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JDBC.close();//关闭连接对象
		return list;//返回查询结果集
	}
	/*
	 * 修改图书信息方法
	 */
	public static int Updatebook(String ISBN,String typeId,String bookname,
			String writer,String translator,String publisher,Date date,Double price){
		int i=0;//更新记录数
		try{
			String sql="update tb_bookInfo set ISBN='"+ISBN+"',typeId='"+typeId+"',bookname='"
					+bookname+"',writer='"+writer+"',translator='"+translator+"',publisher='"
					+publisher+"',date='"+date+"',price='"+price+"' where ISBN='"+ISBN+"'";
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
