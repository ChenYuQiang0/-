package com.bin.lookz.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bin.lookz.dao.AdminsDao;
import com.bin.lookz.entity.Admins;
import com.bin.lookz.entity.Users;
import com.bin.lookz.util.C3P0Util;

public class AdminsDaoImpl implements AdminsDao{

	//ͨ���˺ź�������Ҹù���Ա��Ϣ
	public Admins findAdminsByAdmins(String name,String password) {
		Admins a = null;
		ResultSet rs = C3P0Util.query("select * from admins where name=? and password=? and admins_flag=1", new Object[]{name,password});
		try {
			while(rs.next()){
				a = new Admins(rs.getInt("id"),rs.getString("name"),rs.getString("password"),rs.getInt("admins_rank"),rs.getInt("admins_flag"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			C3P0Util.closeAll(rs);
		}
		return a;
	}

	//����IDɾ����Ϣ
	public int delUsersById(int id) {
		return C3P0Util.update("update users set u_flag=0 where id=?", new Object[]{id});
	}

	//���������û�
	public ArrayList<Users> getAllUsers() {
		ArrayList<Users> userslist = new ArrayList<Users>();
		ResultSet rs = C3P0Util.query("select * from users where u_flag=1", null);
		try {
			while(rs.next()){
				Users a = new Users(rs.getInt(1),rs.getString("name"),rs.getString("password"),rs.getString(4),rs.getString(5),rs.getDouble(6));
				userslist.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			C3P0Util.closeAll(rs);
		}
		return userslist;
	}

	//��ӹ���Ա��Ϣ
	public int addAdmins(Admins a) {
		return C3P0Util.update("insert into admins (name,password,admins_rank,admins_flag) values (?,?,?,?,?)",new Object[]{a.getName(),a.getPassword(),a.getAdmins_rank(),a.getAdmins_flag()});
	}

	//�������й���Ա��Ϣ
	public ArrayList<Admins> getAllAdmins() {
		ArrayList<Admins> adminslist = new ArrayList<Admins>();
		ResultSet rs = C3P0Util.query("select * from Admins where admins_flag>0", null);
		try {
			while(rs.next()){
				Admins a = new Admins(rs.getInt("id"),rs.getString("name"),rs.getString("password"),rs.getInt("admins_rank"),rs.getInt("admins_flag"));
				adminslist.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			C3P0Util.closeAll(rs);
		}
		return adminslist;
	}

	//����IDɾ������Ա��Ϣ
	public int delAdminsById(int id) {
		return C3P0Util.update("update admins set admins_flag=0 where id=?", new Object[]{id});
	}
	
	

}
