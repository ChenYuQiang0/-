package com.bin.lookz.dao;

import java.util.List;

import com.bin.lookz.entity.Address;

public interface AddressDao {

	//ͨ���û������Ҹ��û����ջ���ַ
	public abstract List<Address> findUserAddress(int users_id);
	
}
