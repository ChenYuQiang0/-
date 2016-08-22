package com.bin.lookz.dao;

import com.bin.lookz.entity.Order;

public interface OrderDao {

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
