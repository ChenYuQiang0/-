package com.bin.lookz.dao.impl;

import com.bin.lookz.dao.ShoppingCarDao;
import com.bin.lookz.util.C3P0Util;

public class ShoppingCarDaoImpl implements ShoppingCarDao{

	//��ӵ����ﳵ
	public int addShoppingCart(int number, double sumPrice, String time,
			int shoppingcarFlag) {
		return C3P0Util.update("insert into shoppingCar (number,sum_price,time,shoppingCar_flag) values (?,?,?,?)", new Object[]{number,sumPrice,time,shoppingcarFlag});
	}

}
