package com.lxj.Dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lxj.model.BookInfo;
import com.lxj.model.user;
import com.lxj.util.JDBC;

public class UserDao {

	public static int Updatepass(String password, String name) {//修改密码
		// TODO Auto-generated method stub
		int i=0;
		try {
			String sql="update tb_operator set password='"+password+"' where name='"+name+"'";
			System.out.println(sql);
			i=JDBC.executeUpdate(sql);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		JDBC.close();
		return i;
	}

	public static int Insertoperator(String username, String sex, int age, String icard, Date workdate, String tel,
			String password) {//添加用户
		// TODO Auto-generated method stub
		int i=0;
		try {
			String sql="insert into tb_operator(name,sex,age,workdate,tel,admin,password,identityCard)values('"+username+"','"+sex+"',"+age+","
					+ "'"+workdate+"','"+tel+"',1,'"+password+"','"+icard+"')";
			i=JDBC.executeUpdate(sql);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		JDBC.close();
		return i;
		
	}

	public static List selectuser() {//修改用户信息
		// TODO Auto-generated method stub
		List list=new ArrayList();
		String sql = "select *  from tb_operator";
		ResultSet rs = JDBC.executeQuery(sql);
		try {
			while (rs.next()) {
				user user1=new user();
				user1.setId(rs.getInt("id"));
				user1.setName(rs.getString("name"));
				user1.setAge(rs.getInt("age"));
				user1.setSex(rs.getString("sex"));
				user1.setTel(rs.getString("tel"));
				user1.setAdmin(rs.getInt("admin"));
				user1.setIdentityCard(rs.getString("identityCard"));
				user1.setPassword(rs.getString("password"));
				user1.setWorkdate(rs.getDate("workdate"));
				list.add(user1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JDBC.close();
		return list;
	
	}

	public static int Updateuser(int id, String name, String sex, int age, String card, Date valueOf, String tel,
			String password) {
		// TODO Auto-generated method stub
		int i=0;
		try {
			String sql="update tb_operator set id="+id+",name='"+name+"',sex='"+sex+"',age="+age+",identityCard='"+card+"',"
					+ "workdate='"+valueOf+"',tel='"+tel+"',password='"+password+"'where id="+id+"";
		i=JDBC.executeUpdate(sql);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		JDBC.close();
		return i;
		
		
	}

	public static int Deluser(int id) {
		// TODO Auto-generated method stub
		int i=0;
		try {
			String sql="delete from tb_operator where id="+id+"";
		i=JDBC.executeUpdate(sql);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		JDBC.close();
		return i;
	}

}
