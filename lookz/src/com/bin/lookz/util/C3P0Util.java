package com.bin.lookz.util;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.mchange.v2.c3p0.ComboPooledDataSource;
/**
 * ���ݿ⹤����
 * 	����Դ = ���ӳ� + ����ʽ
 * 		���� JDBC �д������� �Լ��ر����ӱȽϺ�ʱ , ���Կ���ͨ������Դ���� �����Ч��
 * 		����Դ�����ڴ�����ʱ���Ĭ������N������ , ���Ե�һ�δ�����ʱ������. ���Ǻ���ʹ�ù���ʱ���ٴ�������
 * 		����ʹ�ù���ʱ���ٶȿ� , ����ʹ�����֮���ǹر� , ���ǹ黹 . ���ַ�ʽ�������Ч��
 */
public class C3P0Util {
	
	//���ݿ���������
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	private static ComboPooledDataSource cpds;
	
	static{
		try {
			//���������ļ���Ϣ
			ResourceBundle rb = ResourceBundle.getBundle("jdbc");
			//��ֵ
			driver = rb.getString("driver");
			url = rb.getString("url");
			username = rb.getString("username");
			password = rb.getString("password");
			//����C3P0����Դ����
			cpds = new ComboPooledDataSource();
			//ע������
			cpds.setDriverClass(driver);
			//����������Ϣ
			cpds.setJdbcUrl(url);
			cpds.setUser(username);
			cpds.setPassword(password);
			//���ó�ʼ���Ӹ���
			cpds.setInitialPoolSize(50);
			//����������Ӹ���
			cpds.setMaxPoolSize(100);
			//���ó�ʱʱ��
			cpds.setCheckoutTimeout(5000);
			
		} catch (PropertyVetoException e) {
			System.out.println("ע������ʧ�� !");
			e.printStackTrace();
		}
	}
	
	//��ȡ����
	public static Connection getConnection(){
		Connection conn = null;
		try {
			conn = cpds.getConnection();
		} catch (SQLException e) {
			System.out.println("���ӻ�ȡʧ�� !");
			e.printStackTrace();
		}
		return conn;
	}
	
	//�ر���Դ , ���ʹ������Դ�������ӳصȼ��� .���Ӷ�Ӧ�� close ���������ǹر� , ���ǹ黹 .
	public static void closeAll(ResultSet rs){
		try {
			if( rs != null ){
				//�Ȼ�ȡ�������
				Statement s = rs.getStatement();
				Connection conn = s.getConnection();
				closeAll( rs,s,conn );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void closeAll(Statement s,Connection conn){
		try {
			if( s != null ){
				s.close();
			}
			
			if( conn != null ){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void closeAll(ResultSet rs,Statement s,Connection conn){
		try {
			if( rs != null ){
				rs.close();
			}
		
			if( s != null ){
				s.close();
			}
			
			if( conn != null ){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ͨ�õĲ�ѯ��䷽��
	 * @param sql ָ����SQL���
	 * @param obj ��SQL����Ӧ�Ĳ����� , ���û����Ϊ null
	 * @return ResultSet ���ض�Ӧ�Ľ�������� . 
	 */
	public static ResultSet query(String sql,Object[] obj){
		//��ȡ����
		Connection conn = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			//����Ԥ�����������
			ps = conn.prepareStatement(sql);
			//�ж��Ƿ��в���
			if( obj != null ){
				//��ռλ����ֵ
				for(int i=0;i<obj.length;i++){
					ps.setObject(i+1,obj[i]);
				}
			}
			//ִ��
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//���ؽ����
		return rs;
	}
	
	/**
	 * ͨ�õ���ɾ����䷽��
	 * @param sql ָ����SQL���
	 * @param obj ��SQL����Ӧ�Ĳ����� , ���û����Ϊ null
	 * @return ������Ӱ������ , ���Ϊ DDL �����Ϊ 0. 
	 */
	public static int update(String sql,Object[] obj){
		//��ȡ����
		Connection conn = getConnection();
		PreparedStatement ps = null;
		int rows = 0;
		
		try {
			//����Ԥ�����������
			ps = conn.prepareStatement(sql);
			//�ж��Ƿ��в���
			if( obj != null ){
				//��ռλ����ֵ
				for(int i=0;i<obj.length;i++){
					ps.setObject(i+1,obj[i]);
				}
			}
			//ִ��
			rows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//�ر���Դ
			closeAll(ps,conn);
		}
		//������Ӱ������
		return rows;
	}
	
	
}
