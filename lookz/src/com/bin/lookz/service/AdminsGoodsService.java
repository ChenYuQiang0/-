package com.bin.lookz.service;

import java.util.ArrayList;
import java.util.List;

import com.bin.lookz.entity.Goods;

public interface AdminsGoodsService {

	//�����Ʒ
	public abstract int addGoods(Goods g);
	
	//�õ���ǰҳ����Ʒ����
	public abstract ArrayList<Goods> getAllGoods(int pages);
	
	//���ݹؼ��ֲ��������Ʒ��Ϣ
	public abstract List<Goods> getGoodsByKeyWord(String key,int pages);
	
	//�õ����ҳ��
	public abstract int getPage();
	
	/**
	 * ����IDɾ����Ʒ
	 * @return ����int
	 * */
	public abstract int delGoodsById(int id);
	
	/**
	 * ����ID������Ʒ
	 * @param ��Ʒ����
	 * @return ����Goods����
	 * */
	public abstract Goods getGoodsById(int id);
	
	/**
	 * ����goods���޸���Ʒ��Ϣ
	 * @param Goods ��Ʒ����
	 * @return int����
	 * */
	public abstract int updGoodsByGoods(Goods g); 
	
	/**
	 * �õ���ѯ�����ҳ��
	 * */
	public abstract int getPageBySearch(String keyword);
	
}
