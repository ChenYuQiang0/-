package com.bin.lookz.dao;

import java.util.ArrayList;

import com.bin.lookz.entity.Admins;
import com.bin.lookz.entity.Users;

public interface AdminsDao {

	//ͨ���˺ź�������Ҹù���Ա��Ϣ
	public abstract Admins findAdminsByAdmins(String name,String password);
	//���������û�
	public ArrayList<Users> getAllUsers();
	//����IDɾ����Ϣ
	public int delUsersById(int id);
	//��ӹ���Ա��Ϣ
	public abstract int addAdmins(Admins a);
	//�������й���Ա��Ϣ
	public ArrayList<Admins> getAllAdmins();
	//����IDɾ������Ա��Ϣ
	public int delAdminsById(int id);
}
