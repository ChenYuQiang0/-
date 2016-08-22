package com.bin.lookz.service.impl;

import java.util.ArrayList;

import com.bin.lookz.dao.UsersDao;
import com.bin.lookz.entity.Contact;
import com.bin.lookz.entity.Pp;
import com.bin.lookz.entity.Purchase;
import com.bin.lookz.entity.Users;
import com.bin.lookz.service.UsersService;
import com.bin.lookz.util.Factory;

public class UsersServiceImpl implements UsersService{
	
	private UsersDao usersdao = Factory.getUsersDaoInstance();
	
	//ע��
	public int register(Users u){
		return usersdao.addUsers(u);
	}

	//��¼
	public Users login(String name, String password) {
		return usersdao.findUsersByUsers(name, password);
	}

	//�޸�����
	public int updPsdByUsers(Users u, String psd) {
		return usersdao.updPsdByUsers(u, psd);
	}

	//�����û����ҵ��û�������Ϣ
	public ArrayList<Purchase> getOrderByName(String name) {
		return usersdao.getOrderByName(name);
	}

	//�����ϵ��Ϣ
	public int addContact(Contact c) {
		return usersdao.addContact(c);
	}

	//����ܱ�
	public int addPp(Pp p) {
		return usersdao.addPp(p);
	}

	//�һ�����
	public Pp findPp(String ppOne,String ppTwo,String ppThree) {
		return usersdao.findPp(ppOne,ppTwo,ppThree);
	}

	//�����û��Ƿ����
	public boolean checkName(String name) {
		return usersdao.checkName(name);
	}
	
	
	
}
