package com.bin.lookz.service.impl;

import java.util.ArrayList;

import com.bin.lookz.dao.AdminMessageDao;
import com.bin.lookz.entity.Contact;
import com.bin.lookz.service.AdminMessageService;
import com.bin.lookz.util.Factory;

public class AdminMessageServiceImpl implements AdminMessageService{
	private AdminMessageDao adminmessagedao = Factory.getAdminMessageDaoInstance();
	//����IDɾ����Ϣ
	public int delMsgById(int id) {
		return adminmessagedao.delMsgById(id);
	}

	//�������е���Ϣ
	public ArrayList<Contact> getAllContact() {
		return adminmessagedao.getAllContact();
	}

}
