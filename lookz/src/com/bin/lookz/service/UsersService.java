package com.bin.lookz.service;

import java.util.ArrayList;

import com.bin.lookz.entity.Contact;
import com.bin.lookz.entity.Pp;
import com.bin.lookz.entity.Purchase;
import com.bin.lookz.entity.Users;

public interface UsersService {

	//ע��
	public abstract int register(Users u);

	//��¼
	public abstract Users login(String name,String password);
	
	//�޸�����
	public int updPsdByUsers(Users u,String psd);
	
	//�����û����ҵ��û�������Ϣ
	public ArrayList<Purchase> getOrderByName(String name);
	
	//�����ϵ��Ϣ
	public int addContact(Contact c);
	
	//����ܱ�
	public abstract int addPp(Pp p);
	
	//�һ�����
	public abstract Pp findPp(String ppOne,String ppTwo,String ppThree);
	
	//�����û��Ƿ����
	public boolean checkName(String name);
	
}