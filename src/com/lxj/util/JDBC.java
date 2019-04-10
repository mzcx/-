package com.lxj.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC {
	protected static String dbClassName = 
			"com.mysql.jdbc.Driver";//���ݿ�����������
	protected static String dbUrl = "jdbc:mysql://localhost/library";//���ݿ�����URL
	protected static String dbUser = "root";				//���ݿ��û���
	protected static String dbPwd = "1234";			//���ݿ�����
	private static Connection conn = null;				//���ݿ����Ӷ���
	private JDBC() {										//Ĭ�Ϲ��캯��
		try {
			if (conn == null) {							//������Ӷ���Ϊ��
				Class.forName(dbClassName);				//����������
				conn = DriverManager.getConnection(dbUrl, dbUser, dbPwd);//������Ӷ���
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		}
	}
	public static ResultSet executeQuery(String sql) {	//��ѯ����
		try {
			if(conn==null)  new JDBC();  //������Ӷ���Ϊ�գ������µ��ù��췽��
			return conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE).executeQuery(sql);//ִ�в�ѯ
		} catch (SQLException e) {
			e.printStackTrace();
			return null;				//����nullֵ
		} finally {
		}
	}
	public static int executeUpdate(String sql) {		//���·���
		try {
			if(conn==null)  new JDBC();	//������Ӷ���Ϊ�գ������µ��ù��췽��
			return conn.createStatement().executeUpdate(sql);//ִ�и���
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
		}
	}
	public static void close() {//�رշ���
		try {
			conn.close();//�ر����Ӷ���		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			conn = null;	//�������Ӷ���Ϊnullֵ
		}
	}
}
	