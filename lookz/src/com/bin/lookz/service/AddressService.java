package com.bin.lookz.service;

import java.util.List;

import com.bin.lookz.entity.Address;

public interface AddressService {

	//ͨ���û������Ҹ��û����ջ���ַ
	public abstract List<Address> findUserAddress(int users_id);
	
}
