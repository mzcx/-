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
	 * ͼ����Ϣ����ز���
	 */
	/*
	 * ����ͼ����Ϣ����
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
		JDBC.close();	//�ر����Ӷ���	
		return i;		//���ظ��¼�¼��
	}
	/*
	 * ��ѯͼ�������Ϣ
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
	public static List selectBookInfo(String ISBN) {//����ͼ���Ų�ѯͼ��
		List list=new ArrayList();//�������в�ѯ���鼮��Ϣ
		String sql = "select *  from tb_bookInfo where ISBN='"+ISBN+"'";
		ResultSet rs = JDBC.executeQuery(sql);//ִ�в�ѯ
		try {
			while (rs.next()) {//���������
				BookInfo bookinfo=new BookInfo();//�鼮��Ϣ����
				bookinfo.setISBN(rs.getString("ISBN"));//�����鼮���
				bookinfo.setTypeId(rs.getString("typeId"));//���������
				bookinfo.setBookName(rs.getString("bookname"));//�����鼮����
				bookinfo.setWriter(rs.getString("writer"));//��������
				bookinfo.setTranslator(rs.getString("translator"));//��������
				bookinfo.setPublisher(rs.getString("publisher"));//���ó�����
				bookinfo.setDate(rs.getDate("date"));//���ó�������
				bookinfo.setPrice(rs.getDouble("price"));//���ü۸�
				list.add(bookinfo);//����鼮��Ϣ
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JDBC.close();//�ر����Ӷ���
		return list;//���ز�ѯ�����
	}
	/*
	 * �޸�ͼ����Ϣ����
	 */
	public static int Updatebook(String ISBN,String typeId,String bookname,
			String writer,String translator,String publisher,Date date,Double price){
		int i=0;//���¼�¼��
		try{
			String sql="update tb_bookInfo set ISBN='"+ISBN+"',typeId='"+typeId+"',bookname='"
					+bookname+"',writer='"+writer+"',translator='"+translator+"',publisher='"
					+publisher+"',date='"+date+"',price='"+price+"' where ISBN='"+ISBN+"'";
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
