package com.bin.lookz.service;

import com.bin.lookz.entity.Order;
import com.bin.lookz.entity.Users;

public interface OrderService {
	
	//�¶���
	public int addAllOrder(Users users,Order order);
	
	//��Ӷ���
	public int addOrder(Order o);
	
	//����û��Ͷ���
	public int addUserAndOrder(int u_id,long o_id);
	
	//�����û���ID�����Ҷ�����ID
	public int getOrderIdByUserId(int userid);
	
	//��Ӷ�������Ʒ����
	public int addOrderAndGoods(long o_id,int g_id,int num);
	//���ݶ�����ID�ȵ���Ʒ��ID
	public int getGoodIdByOrderId(int orderid);
}
