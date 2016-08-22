package com.bin.lookz.service.impl;

import java.util.ArrayList;

import com.bin.lookz.dao.OrderDao;
import com.bin.lookz.entity.Goods;
import com.bin.lookz.entity.Order;
import com.bin.lookz.entity.Users;
import com.bin.lookz.service.OrderService;
import com.bin.lookz.util.Factory;

public class OrderServiceImpl implements OrderService{
	private OrderDao orderdao = Factory.getOrderDaoInstance();
	//��Ӷ���
	public int addOrder(Order o) {
		return orderdao.addOrder(o);
	}

	//��Ӷ�������Ʒ����
	public int addOrderAndGoods(long oId, int gId, int num) {
		return orderdao.addOrderAndGoods(oId, gId, num);
	}

	//����û��Ͷ���
	public int addUserAndOrder(int uId, long oId) {
		return orderdao.addUserAndOrder(uId, oId);
	}

	//���ݶ�����ID�ȵ���Ʒ��ID
	public int getGoodIdByOrderId(int orderid) {
		return orderdao.getGoodIdByOrderId(orderid);
	}

	//�����û���ID�����Ҷ�����ID
	public int getOrderIdByUserId(int userid) {
		return orderdao.getOrderIdByUserId(userid);
	}

	//�¶���
	public int addAllOrder(Users users, Order order) {
		//��ȡ��Ʒ����
		ArrayList<Goods> goodslist = users.getShoppingCar().getGoodslist();
		//��ȡ���ﳵ������
		ArrayList<Integer> numlist = users.getShoppingCar().getGoodsNum();
		//��Ӷ���
		orderdao.addOrder(order);
		//����û��Ͷ���
		orderdao.addUserAndOrder(users.getId(), order.getOrderid());
		//��Ӷ�������Ʒ
		for(int i=0;i<goodslist.size();i++){
			orderdao.addOrderAndGoods(order.getOrderid(), goodslist.get(i).getId(), numlist.get(i));
		}
		return 1;
	}

}
