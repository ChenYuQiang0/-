package com.bin.lookz.dao;

import java.util.ArrayList;
import java.util.List;

import com.bin.lookz.entity.Goods;

public interface AdminsGoodsDao {

	//�����Ʒ
	public abstract int addGoods(Goods g);
	
	//�õ���ǰҳ����Ʒ����
	public abstract ArrayList<Goods> getAllGoods(int pages);
	
	//���ݹؼ��ֲ��������Ʒ��Ϣ
	public abstract List<Goods> getGoodsByKeyWord(String key,int pages);
	
	//�õ����ҳ��
	public abstract int getPage();
	
	//����IDɾ����Ϣ
	public abstract int delGoodsById(int id);
	
	/**
	 * ����Id������Ϣ
	 * */
	public abstract Goods getGoodsById(int id);
	
	/**
	 * ����goods���޸���Ϣ
	 * */
	public abstract int updGoodsByGoods(Goods g);
	
	/**
	 * �õ���ѯ�����ҳ��
	 * */
	public abstract int getPageBySearch(String keyword);
}
