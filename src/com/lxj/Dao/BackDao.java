package com.lxj.Dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lxj.model.Back;
import com.lxj.model.BookInfo;
import com.lxj.model.BookType;
import com.lxj.util.JDBC;

public class BackDao {
	/*
	 * 图书信息表相关操作
	 */
	/*
	 * 插入图书信息方法
	 */
//	public static int Insertbook(String ISBN,String typeId,String bookname,
//			String writer,String translator,String publisher,Date date,Double price){
//		int i=0;
//		try{
//			String sql="insert into tb_bookInfo(ISBN,typeId,bookname,writer,translator," +
//					"publisher,date,price) values('"+ISBN+"','"+typeId+"','"+bookname+"'," +
//					"'"+writer+"','"+translator+"','"+publisher+"','"+date+"',"+price+")";
//			i=JDBC.executeUpdate(sql);
//		}catch(Exception e){
//			System.out.println(e.getMessage());
//		}
//		JDBC.close();	//关闭连接对象	
//		return i;		//返回更新记录数
//	}
	/*
	 * 查询图书相关信息
	 * 
	 */

	public static List selectBookBack(String readerISBNs) {//根据图书编号查询图书
		List list=new ArrayList();//保存所有查询到书籍信息
		String sql = "select bookname,bookISBN,typeId,tb_reader.name,readerISBN,borrowDate,"
				+ "backDate  from tb_bookinfo,tb_reader,tb_borrow where readerISBN='"+readerISBNs+"' "
						+ "and tb_bookinfo.ISBN=tb_borrow.bookISBN and tb_borrow.readerISBN=tb_reader.ISBN";
		ResultSet rs = JDBC.executeQuery(sql);//执行查询
		try {
			while (rs.next()) {//遍历结果集
				Back back=new Back();//书籍信息对象
				back.setBookname(rs.getString("bookname"));//设置书籍编号
				back.setBookISBN(rs.getString("bookISBN"));//设置类别编号
				back.setTypeId(rs.getInt("typeId"));//设置书籍名称
				back.setReaderName(rs.getString("name"));//设置作者
				back.setReaderISBN(rs.getString("readerISBN"));//设置译者
				back.setBorrowDate(rs.getString("borrowDate"));//设置出版社
				back.setBackDate(rs.getString("backDate"));//设置出版日期
				//back.setPrice(rs.getDouble("price"));//设置价格
				list.add(back);//添加书籍信息
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JDBC.close();//关闭连接对象
		return list;//返回查询结果集
	}
//	public static List selectBookInfo(String readerISBNs) {//根据图书编号查询图书
//		List list=new ArrayList();//保存所有查询到书籍信息
//		String sql = "select bookname,bookISBN,typeId,reader.name,readerISBN,borrowDate,"
//				+ "backDate  from tb_bookinfo,tb_reader,tb_borrow where readerISBNs='"+readerISBNs+"' "
//						+ "and tb_bookinfo.ISBN=tb_borrow.bookISBN and tb_borrow.readerISBN=tb_reader.ISBN";
//		ResultSet rs = JDBC.executeQuery(sql);//执行查询
//		try {
//			while (rs.next()) {
//				Back back=new Back();
//				back.setBookISBN(rs.getString("bookISBN"));
//				back.setOperatorId(rs.getString("operatorId"));
//				back.setBookname(rs.getString("bookname"));
//				back.setBorrowDate(rs.getString("borrowDate"));
//				back.setBackDate(rs.getString("backDate"));
//				back.setReaderName(rs.getString("readerName"));
//				back.setReaderISBN(rs.getString("readerISBN"));
//				back.setTypeId(rs.getInt("typeId"));
//				back.setId(rs.getInt("id"));
//				list.add(back);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		JDBC.close();//关闭连接对象
//		return list;//返回查询结果集
//	}
	/*
	 * 修改图书信息方法
	 */
	public static int UpdateBookBack(String bookISBNs,String readerISBNs,int id){
		int i=0;//更新记录数
		try{
			String sql="update tb_borrow set isback=1 where bookISBN='"+bookISBNs+"' and readerISBN='"+readerISBNs+"'";
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
//	public static List selectBookCategory() {
//		List list=new ArrayList();
//		String sql = "select *  from tb_bookType";
//		ResultSet rs = JDBC.executeQuery(sql);
//		try {
//			while (rs.next()) {
//				BookType bookType=new BookType();
//				bookType.setId(rs.getString("id"));
//				bookType.setTypeName(rs.getString("typeName"));
//				bookType.setDays(rs.getString("days"));
//				bookType.setFk(rs.getString("fk"));
//				list.add(bookType);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		JDBC.close();
//		return list;
//		
//	}
	public static List selectBookTypeFk(String typeName) {//back
		// TODO Auto-generated method stub
		List list=new ArrayList();
		String sql="select * from tb_booktype where typeName='"+typeName+"'";
		
		//System.out.println(sql);
		ResultSet rs=(ResultSet) JDBC.executeQuery(sql);
		try {
			while(rs.next()) {
				BookType booktype=new BookType();
				booktype.setTypeName(rs.getString("typeName"));
				booktype.setDays(rs.getString("days"));
				booktype.setId(rs.getString("id"));
				booktype.setFk(rs.getString("fk"));
				list.add(booktype);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		JDBC.close();
		return list;
		
	}
}
