package com.bin.lookz.service.impl;

import java.util.ArrayList;

import com.bin.lookz.dao.AdminsDao;
import com.bin.lookz.entity.Admins;
import com.bin.lookz.entity.Users;
import com.bin.lookz.service.AdminsService;
import com.bin.lookz.util.Factory;

public class AdminsServiceImpl implements AdminsService{

	private AdminsDao adminsdao = Factory.getAmindsDaoInstance();
	
	//��¼
	public Admins login(String name, String password) {
		return adminsdao.findAdminsByAdmins(name, password);
	}

	//����IDɾ����Ϣ
	public int delUsersById(int id) {
		return adminsdao.delUsersById(id);
	}

	//���������û�
	public ArrayList<Users> getAllUsers() {
		return adminsdao.getAllUsers();
	}

	//��ӹ���Ա��Ϣ
	public int addAdmins(Admins a) {
		return adminsdao.addAdmins(a);
	}

	//�������й���Ա��Ϣ
	public ArrayList<Admins> getAllAdmins() {
		return adminsdao.getAllAdmins();
	}

	//����IDɾ������Ա��Ϣ
	public int delAdminsById(int id) {
		return adminsdao.delAdminsById(id);
	}

}
