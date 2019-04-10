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
	 * ͼ����Ϣ����ز���
	 */
	/*
	 * ����ͼ����Ϣ����
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
//		JDBC.close();	//�ر����Ӷ���	
//		return i;		//���ظ��¼�¼��
//	}
	/*
	 * ��ѯͼ�������Ϣ
	 * 
	 */

	public static List selectBookBack(String readerISBNs) {//����ͼ���Ų�ѯͼ��
		List list=new ArrayList();//�������в�ѯ���鼮��Ϣ
		String sql = "select bookname,bookISBN,typeId,tb_reader.name,readerISBN,borrowDate,"
				+ "backDate  from tb_bookinfo,tb_reader,tb_borrow where readerISBN='"+readerISBNs+"' "
						+ "and tb_bookinfo.ISBN=tb_borrow.bookISBN and tb_borrow.readerISBN=tb_reader.ISBN";
		ResultSet rs = JDBC.executeQuery(sql);//ִ�в�ѯ
		try {
			while (rs.next()) {//���������
				Back back=new Back();//�鼮��Ϣ����
				back.setBookname(rs.getString("bookname"));//�����鼮���
				back.setBookISBN(rs.getString("bookISBN"));//���������
				back.setTypeId(rs.getInt("typeId"));//�����鼮����
				back.setReaderName(rs.getString("name"));//��������
				back.setReaderISBN(rs.getString("readerISBN"));//��������
				back.setBorrowDate(rs.getString("borrowDate"));//���ó�����
				back.setBackDate(rs.getString("backDate"));//���ó�������
				//back.setPrice(rs.getDouble("price"));//���ü۸�
				list.add(back);//����鼮��Ϣ
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JDBC.close();//�ر����Ӷ���
		return list;//���ز�ѯ�����
	}
//	public static List selectBookInfo(String readerISBNs) {//����ͼ���Ų�ѯͼ��
//		List list=new ArrayList();//�������в�ѯ���鼮��Ϣ
//		String sql = "select bookname,bookISBN,typeId,reader.name,readerISBN,borrowDate,"
//				+ "backDate  from tb_bookinfo,tb_reader,tb_borrow where readerISBNs='"+readerISBNs+"' "
//						+ "and tb_bookinfo.ISBN=tb_borrow.bookISBN and tb_borrow.readerISBN=tb_reader.ISBN";
//		ResultSet rs = JDBC.executeQuery(sql);//ִ�в�ѯ
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
//		JDBC.close();//�ر����Ӷ���
//		return list;//���ز�ѯ�����
//	}
	/*
	 * �޸�ͼ����Ϣ����
	 */
	public static int UpdateBookBack(String bookISBNs,String readerISBNs,int id){
		int i=0;//���¼�¼��
		try{
			String sql="update tb_borrow set isback=1 where bookISBN='"+bookISBNs+"' and readerISBN='"+readerISBNs+"'";
			i=JDBC.executeUpdate(sql);//ִ�и���
		}catch(Exception e){
			e.printStackTrace();
		}
		JDBC.close();//�ر����Ӷ���
		return i;//���ظ��¼�¼��
	}
	/*
	 * ��ѯ��𷽷�
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
