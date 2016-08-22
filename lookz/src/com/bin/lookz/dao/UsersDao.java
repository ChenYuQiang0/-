package com.bin.lookz.dao;

import java.util.ArrayList;

import com.bin.lookz.entity.Contact;
import com.bin.lookz.entity.Pp;
import com.bin.lookz.entity.Purchase;
import com.bin.lookz.entity.Users;

public interface UsersDao {

	//����û��˺�������ֶ�
	public abstract int addUsers(Users u);
	
	//����ܱ�
	public abstract int addPp(Pp p);

	//ͨ���˺ź�������Ҹ��û���Ϣ
	public abstract Users findUsersByUsers(String name,String password);
	
	//ͨ�������޸�����
	public int updPsdByUsers(Users u,String psd);
	
	//�����û����ҵ��û�������Ϣ
	public ArrayList<Purchase> getOrderByName(String name);
	
	//�����ϵ��Ϣ
	public int addContact(Contact c);
	
	//�һ�����
	public abstract Pp findPp(String ppOne,String ppTwo,String ppThree);
	
	//�����û��Ƿ����
	public boolean checkName(String name);
}