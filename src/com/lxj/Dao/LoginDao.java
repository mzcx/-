package com.lxj.Dao;

import java.sql.ResultSet;

import com.lxj.model.Operater;
import com.lxj.util.JDBC;

public class LoginDao {
	/**
	 * ����Ա��¼����
	 */
	public static Operater check(String name,String password) {
		Operater operater=new Operater();//����Ա��Ϣ����
		String sql="select*from tb_operator where name='"+name+"'and password='"+password+"'and admin=1";///��ѯ�ַ���
		ResultSet rs=JDBC.executeQuery(sql);//ִ�в�ѯ
		try {
			while(rs.next()) {//�����ѯ���˼�¼
				operater.setId(rs.getString("id"));//���ò���Ա���
				operater.setName(rs.getString("name"));//���ò���Ա�û���
				operater.setGrade(rs.getString("admin"));//���ò���Ա�ȼ�
				operater.setPassword(rs.getString("password"));//���ù���Ա����
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		JDBC.close();//�ر����Ӷ���
		return operater;//���ز���Ա��Ϣ����
	}

}
