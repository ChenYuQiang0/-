package com.bin.lookz.service.impl;

import com.bin.lookz.dao.ShoppingCarDao;
import com.bin.lookz.service.ShoppingCarService;
import com.bin.lookz.util.Factory;

public class ShoppingCarServiceImpl implements ShoppingCarService{
	private ShoppingCarDao shoppingcardao = Factory.getShoppingCarDaoInstance();
	/**
	 * ��ӵ����ﳵ
	 * */
	public int addShoppingCart(int number, double sumPrice, String time,
			int shoppingcarFlag) {
		return shoppingcardao.addShoppingCart(number, sumPrice, time, shoppingcarFlag);
	}

}
