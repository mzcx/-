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
	 * ͼ��������ز���
	 */
	/*
	 * ����ͼ����𷽷�
	 */
	public static int InsertBookType(String typeName,String days,double fk){
		int i=0;
		try{
			
			String sql="insert into tb_booktype(typeName,days,fk) values('"+typeName+"',"+days+","+fk+")";
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
	public static List selectBookType(String id) {//����ͼ���Ų�ѯͼ��
		List list=new ArrayList();//�������в�ѯ���鼮��Ϣ
		String sql = "select *  from tb_booktype where id='"+id+"'";
		ResultSet rs = JDBC.executeQuery(sql);//ִ�в�ѯ
		try {
			while (rs.next()) {//���������
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
		JDBC.close();//�ر����Ӷ���
		return list;//���ز�ѯ�����
	}
	/*
	 * �޸�ͼ����𷽷�
	 */
	public static int Updatebooktype(String id,String typeName,String days, String fk){
		int i=0;//���¼�¼��
		try{
			String sql="update tb_booktype set typeName='"+typeName+"',days='"+days+"',fk="+fk+" where id="+id+"";
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