package com.lxj.Dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lxj.model.BookInfo;
import com.lxj.model.BookType;
import com.lxj.model.Reader;
import com.lxj.util.JDBC;

public class ReaderDao {
	/*
	 * ������Ϣ����ز���
	 */
	/*
	 * ���������Ϣ����
	 */
	public static int InsertReader(String name,String sex,String age,
			String identityCard,Date date,String maxNum,String tel,double keepMoney,String zj,String zy,Date bztime,String ISBN){
		int i=0;
		try{
			String sql="insert into tb_reader(name,sex,age,identityCard,date,maxNum,tel,"
					+ "keepMoney,zj,zy,ISBN,bztime)"
					+ " values('"+name+"','"+sex+"',"+age+",'"+identityCard+"','"
					+date+"','"+maxNum+"','"+tel+"',"+keepMoney+
					","+zj+",'"+zy+"','"+ISBN+"','"+bztime+"')";
			i=JDBC.executeUpdate(sql);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		JDBC.close();	//�ر����Ӷ���	
		return i;		//���ظ��¼�¼��
	}
	/*
	 * ��ѯ���������Ϣ
	 * 
	 */

	public static List selectReader() {
		List list=new ArrayList();
		String sql = "select *  from tb_reader";
		ResultSet rs = JDBC.executeQuery(sql);
		try {
			while (rs.next()) {
				Reader reader=new Reader();
				reader.setName(rs.getString("name"));
				reader.setSex(rs.getString("sex"));
				reader.setAge(rs.getString("age"));
				reader.setIdentityCard(rs.getString("identityCard"));
				reader.setDate(rs.getDate("date"));
				reader.setMaxNum(rs.getString("maxNum"));
				reader.setTel(rs.getString("tel"));
				reader.setKeepMoney(rs.getDouble("keepMoney"));
				reader.setZj(rs.getInt("zj"));
				reader.setZy(rs.getString("zy"));
				reader.setISBN(rs.getString("ISBN"));
				reader.setBztime(rs.getDate("bztime"));
				list.add(reader);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JDBC.close();
		return list;
	}
	public static List selectReader(String ISBN) {//����ͼ���Ų�ѯͼ��
		List list=new ArrayList();//�������в�ѯ��ͼ����Ϣ
		String sql = "select *  from tb_reader where ISBN='"+ISBN+"'";
		ResultSet rs = JDBC.executeQuery(sql);//ִ�в�ѯ
		try {
			while (rs.next()) {//���������
				Reader reader=new Reader();
				reader.setName(rs.getString("name"));//������Ϣ����
				reader.setSex(rs.getString("sex"));//���ö����Ա�
				reader.setAge(rs.getString("age"));//���ö�������
				reader.setIdentityCard(rs.getString("identityCard"));//����֤������
				reader.setDate(rs.getDate("date"));//���û�Ա֤��Ч����
				reader.setMaxNum(rs.getString("maxNum"));//������������
				reader.setTel(rs.getString("tel"));//���õ绰����
				reader.setKeepMoney(rs.getDouble("keepMoney"));//����Ѻ��
				reader.setZj(rs.getInt("zj"));//����֤������
				reader.setZy(rs.getString("zy"));//����ְҵ
				reader.setISBN(rs.getString("ISBN"));//���ö��߱��
				reader.setBztime(rs.getDate("bztime"));//���ð�֤����
				list.add(reader);//��Ӷ�����Ϣ
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JDBC.close();//�ر����Ӷ���
		return list;//���ز�ѯ�����
	}
	/*
	 * �޸Ķ�����Ϣ����
	 */
	public static int UpdateReader(String name,String sex,String age,
			String identityCard,Date date,String maxNum,String tel,double keepMoney,String zj,String zy,Date bztime,String ISBN){
		int i=0;
		try{
			String sql="update tb_reader set name='"+name+"',sex='"+sex+"',age="
					+age+",identityCard='"+identityCard+"',date='"+date+"',maxNum='"
					+maxNum+"',tel='"+tel+"',keepMoney='"+keepMoney+"',zj="+zj+",zy='"
					+zy+"',ISBN='"+ISBN+"',bztime='"+bztime+"' where ISBN='"+ISBN+"'";
			i=JDBC.executeUpdate(sql);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		JDBC.close();	//�ر����Ӷ���	
		return i;		//���ظ��¼�¼��
	}
//	/*
//	 * ��ѯ��𷽷�
//	 */
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

	public static int DelReader(String ISBN){
		int i=0;
		try{
			String sql="delete from tb_reader where ISBN='"+ISBN+"'";
			i=JDBC.executeUpdate(sql);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		JDBC.close();	//�ر����Ӷ���	
		return i;		//���ظ��¼�¼��
	}

}
