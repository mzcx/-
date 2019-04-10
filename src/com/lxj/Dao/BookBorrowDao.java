package com.lxj.Dao;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.ResultSet;
import com.lxj.model.Back;
import com.lxj.model.BookInfo;
import com.lxj.model.BookType;
import com.lxj.model.Reader;
import com.lxj.util.JDBC;



public class BookBorrowDao {

	public static List selectbookserch() {//search
		// TODO Auto-generated method stub
		List list=new ArrayList();
		String sql="select * from tb_bookinfo";
		ResultSet rs=(ResultSet) JDBC.executeQuery(sql);
		try {
			while(rs.next()) {
				BookInfo bookinfo=new BookInfo();
				bookinfo.setISBN(rs.getString("ISBN"));//设置书籍编号
				bookinfo.setTypeId(rs.getString("typeid"));//设置类别编号
				bookinfo.setBookName(rs.getString("bookname"));//设置书籍名称
				bookinfo.setWriter(rs.getString("writer"));//设置作者
				bookinfo.setTranslator(rs.getString("translator"));//设置译者
				bookinfo.setPublisher(rs.getString("publisher"));//设置出版社
				bookinfo.setDate(rs.getDate("date"));//设置出版日期
				bookinfo.setPrice(rs.getDouble("price"));//设置价格
				list.add(bookinfo);//添加书籍信息
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		JDBC.close();
		return list;
	}

	public static List selectbookmohu(String name) {//search
		// TODO Auto-generated method stub
		List list=new ArrayList();
		String sql="select * from tb_bookinfo where bookname='"+name+"'";
		ResultSet rs=(ResultSet) JDBC.executeQuery(sql);
		try {
			while(rs.next()) {
				BookInfo bookinfo=new BookInfo();
				bookinfo.setISBN(rs.getString("ISBN"));//设置书籍编号
				bookinfo.setTypeId(rs.getString("typeid"));//设置类别编号
				bookinfo.setBookName(rs.getString("bookname"));//设置书籍名称
				bookinfo.setWriter(rs.getString("writer"));//设置作者
				bookinfo.setTranslator(rs.getString("translator"));//设置译者
				bookinfo.setPublisher(rs.getString("publisher"));//设置出版社
				bookinfo.setDate(rs.getDate("date"));//设置出版日期
				bookinfo.setPrice(rs.getDouble("price"));//设置价格
				list.add(bookinfo);//添加书籍信息
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		JDBC.close();
		return list;
	}

	public static List selectbookmohuwriter(String writer) {//search
		// TODO Auto-generated method stub
		List list=new ArrayList();
		String sql="select * from tb_bookinfo where writer='"+writer+"'";
		ResultSet rs=(ResultSet) JDBC.executeQuery(sql);
		try {
			while(rs.next()) {
				BookInfo bookinfo=new BookInfo();
				bookinfo.setISBN(rs.getString("ISBN"));//设置书籍编号
				bookinfo.setTypeId(rs.getString("typeid"));//设置类别编号
				bookinfo.setBookName(rs.getString("bookname"));//设置书籍名称
				bookinfo.setWriter(rs.getString("writer"));//设置作者
				bookinfo.setTranslator(rs.getString("translator"));//设置译者
				bookinfo.setPublisher(rs.getString("publisher"));//设置出版社
				bookinfo.setDate(rs.getDate("date"));//设置出版日期
				bookinfo.setPrice(rs.getDouble("price"));//设置价格
				list.add(bookinfo);//添加书籍信息
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		JDBC.close();
		return list;
	}

	public static List selectBookBack(String readerISBNs) {//back
		// TODO Auto-generated method stub
		List list=new ArrayList();
		String sql="select backDate,bookISBN,bookname,borrowDate,readerISBN,tb_borrow.id,operatorId,name,tb_bookinfo.typeId from tb_borrow,tb_bookinfo,"
				+ "tb_reader where readerISBN='"+readerISBNs+"' AND tb_borrow.readerISBN=tb_reader.ISBN AND tb_borrow.bookISBN=tb_bookinfo.ISBN";
		ResultSet rs=(ResultSet) JDBC.executeQuery(sql);
		try {
			while(rs.next()) {
				Back back=new Back();
				back.setBackDate(rs.getString("backDate"));
				back.setBookISBN(rs.getString("bookISBN"));
				back.setBookname(rs.getString("bookName"));
				back.setBorrowDate(rs.getString("borrowDate"));
				back.setId(rs.getConcurrency());
				back.setOperatorId(rs.getString("operatorId"));
				back.setReaderName(rs.getString("name"));
				back.setReaderISBN(rs.getString("readerISBN"));
				back.setTypeId(rs.getInt("typeId"));
				list.add(back);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		JDBC.close();
		return list;
	}

	public static List selectBookTypeFk(String typeName) {//back
		// TODO Auto-generated method stub
		List list=new ArrayList();
		String sql="select * from tb_booktype where typeName='"+typeName+"'";
		
		//System.out.println(sql);
		ResultSet rs=(ResultSet) JDBC.executeQuery(sql);
		try {
			while(rs.next()) {
				BookType booktype=new BookType();
				booktype.setTypeName(rs.getString("typename"));
				booktype.setDays(rs.getString("days"));
				booktype.setFk(rs.getString("fk"));
				list.add(booktype);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		JDBC.close();
		return list;
		
	}

	public static int UpdateBookBack(String bookISBNs, String readerISBNs,int id) {//back
		// TODO Auto-generated method stub
		int i=0;//更新记录数
		try{
			String sql="update tb_borrow set isback=1 where bookISBN='"+bookISBNs+"' AND readerISBN='"+readerISBNs+"'";
			//System.out.println(sql);
			i=JDBC.executeUpdate(sql);//执行更新
			
		}catch(Exception e){
			e.printStackTrace();
		}
		JDBC.close();//关闭连接对象
		return i;//返回更新记录数
		
	}

	public static List selectBookCategory(String booktype) {
		// TODO Auto-generated method stub
		List list=new ArrayList();
		String sql = "select typeName,days,fk,tb_booktype.id from tb_booktype,tb_bookinfo,tb_borrow where tb_booktype.id=tb_bookinfo.typeId and tb_bookinfo.ISBN=tb_borrow.bookISBN";
		ResultSet rs = (ResultSet) JDBC.executeQuery(sql);
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

	public static List selectBookInfo(String iSBNs) {//borrow
		// TODO Auto-generated method stub
		List list=new ArrayList();
		String sql="select typeId,bookname,writer,translator,publisher,date,price from tb_bookinfo where ISBN='"+iSBNs+"'";
		//System.out.println(sql);
		ResultSet rs=(ResultSet) JDBC.executeQuery(sql);
		try {
			while(rs.next()) {
				BookInfo bookinfo=new BookInfo();
				//bookinfo.setISBN(rs.getString("ISBN"));//设置书籍编号
				bookinfo.setTypeId(rs.getString("typeid"));//设置类别编号
				bookinfo.setBookName(rs.getString("bookname"));//设置书籍名称
				bookinfo.setWriter(rs.getString("writer"));//设置作者
				bookinfo.setTranslator(rs.getString("translator"));//设置译者
				bookinfo.setPublisher(rs.getString("publisher"));//设置出版社
				bookinfo.setDate(rs.getDate("date"));//设置出版日期
				bookinfo.setPrice(rs.getDouble("price"));//设置价格
				list.add(bookinfo);//添加书籍信息
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		JDBC.close();
		return list;
		 
	}

	public static List selectReader(String readerISBNs) {
		// TODO Auto-generated method stub
		List list=new ArrayList();
		String sql="select * from tb_reader where ISBN='"+readerISBNs+"'";
		java.sql.ResultSet rs=JDBC.executeQuery(sql);
		try {
			while(rs.next()) {
				Reader reader=new Reader();
				reader.setName(rs.getString("name"));
				reader.setSex(rs.getString("sex"));
				reader.setAge(rs.getString("age"));
				reader.setIdentityCard(rs.getString("identitycard"));
				reader.setDate(rs.getDate("date"));
				reader.setMaxNum(rs.getString("maxnum"));
				reader.setTel(rs.getString("tel"));
				reader.setKeepMoney(rs.getDouble("keepmoney"));
				reader.setZj(rs.getInt("zj"));
				reader.setZy(rs.getString("zy"));
				reader.setISBN(rs.getString("ISBN"));
				reader.setBztime(rs.getDate("Bztime"));
				list.add(reader);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		JDBC.close();
		return list;
	}

	public static int InsertBookBorrow(String bookISBNs, String readerISBNs, String operatorId, Timestamp borrowDate,
			Timestamp backDate) {
		// TODO Auto-generated method stub
		int i=0;
		try {
			String sql="insert into tb_borrow(bookISBN,readerISBN,opertorId,borrowDate,backDate)values('"+bookISBNs+"',"
					+ "'"+readerISBNs+"',"+operatorId+",'"+borrowDate+"','"+backDate+"')";
			System.out.println(sql);
			i=JDBC.executeUpdate(sql);
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		JDBC.close();
		return i;
	}

}
