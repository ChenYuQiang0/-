package com.bin.lookz.dao;

import java.util.ArrayList;

import com.bin.lookz.entity.Contact;

public interface AdminMessageDao {

	//�������е���Ϣ
	public ArrayList<Contact> getAllContact();
	
	//����IDɾ����Ϣ
	public int delMsgById(int id);
}
