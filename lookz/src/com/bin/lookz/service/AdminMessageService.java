package com.bin.lookz.service;

import java.util.ArrayList;

import com.bin.lookz.entity.Contact;

public interface AdminMessageService {

	//�������е���Ϣ
	public ArrayList<Contact> getAllContact();
	
	//����IDɾ����Ϣ
	public int delMsgById(int id);
	
}
