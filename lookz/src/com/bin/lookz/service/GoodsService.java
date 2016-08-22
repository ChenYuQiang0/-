package com.bin.lookz.service;

import java.util.List;

import com.bin.lookz.entity.Address;
import com.bin.lookz.entity.Goods;

public interface GoodsService {

	//����ȫ����Ʒ��Ϣ
	public abstract List<Goods> getAllGoods();
	
	//����Type������Ʒ��Ϣ
	public abstract List<Goods> getAllGoodsByType(String type,int pages);
	//�õ����ҳ��
	public abstract int getPage(String type);
	//�õ�type�����͵����ҳ��
	public abstract int getPageByTwoType(String type1,String type2);
	//�õ�keyword��ѯ�����ҳ��
	public abstract int getPageBySearch(String keyword);
	
	//����tasteType������Ʒ��Ϣ
	public abstract List<Goods> getGoodsByTasteType(String type,String tasteType,int pages);
	//����healthType������Ʒ��Ϣ
	public abstract List<Goods> getGoodsByHealthType(String type,String healthType,int pages);
	//����manufacturer������Ʒ��Ϣ
	public abstract List<Goods> getGoodsByManufacturer(String type,String manufacturer,int pages);

	//���ݹؼ��ֲ��������Ʒ��Ϣ
	public abstract List<Goods> getGoodsByKeyWord(String keyword,int pages);
	
	/**
	 * ����ID������Ʒ��Ϣ
	 * @param id ��ƷID
	 * @return Goods
	 * */
	public abstract Goods getGoodsById(int id);
	
	/**
	 * ����ջ���ַ��Ϣ
	 * @return int����
	 * */
	public abstract int addAddress(Address a);
}
