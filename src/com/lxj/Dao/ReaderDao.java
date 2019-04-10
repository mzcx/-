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
	 * 读者信息表相关操作
	 */
	/*
	 * 插入读者信息方法
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
		JDBC.close();	//关闭连接对象	
		return i;		//返回更新记录数
	}
	/*
	 * 查询读者相关信息
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
	public static List selectReader(String ISBN) {//根据图书编号查询图书
		List list=new ArrayList();//保存所有查询到图书信息
		String sql = "select *  from tb_reader where ISBN='"+ISBN+"'";
		ResultSet rs = JDBC.executeQuery(sql);//执行查询
		try {
			while (rs.next()) {//遍历结果集
				Reader reader=new Reader();
				reader.setName(rs.getString("name"));//读者信息对象
				reader.setSex(rs.getString("sex"));//设置读者性别
				reader.setAge(rs.getString("age"));//设置读者年龄
				reader.setIdentityCard(rs.getString("identityCard"));//设置证件号码
				reader.setDate(rs.getDate("date"));//设置会员证有效日期
				reader.setMaxNum(rs.getString("maxNum"));//设置最大借书量
				reader.setTel(rs.getString("tel"));//设置电话号码
				reader.setKeepMoney(rs.getDouble("keepMoney"));//设置押金
				reader.setZj(rs.getInt("zj"));//设置证件类型
				reader.setZy(rs.getString("zy"));//设置职业
				reader.setISBN(rs.getString("ISBN"));//设置读者编号
				reader.setBztime(rs.getDate("bztime"));//设置办证日期
				list.add(reader);//添加读者信息
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JDBC.close();//关闭连接对象
		return list;//返回查询结果集
	}
	/*
	 * 修改读者信息方法
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
		JDBC.close();	//关闭连接对象	
		return i;		//返回更新记录数
	}
//	/*
//	 * 查询类别方法
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
		JDBC.close();	//关闭连接对象	
		return i;		//返回更新记录数
	}

}
