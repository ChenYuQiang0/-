package com.bin.lookz.service.impl;

import java.util.List;

import com.bin.lookz.dao.GoodsDao;
import com.bin.lookz.entity.Address;
import com.bin.lookz.entity.Goods;
import com.bin.lookz.service.GoodsService;
import com.bin.lookz.util.Factory;

public class GoodsServiceImpl implements GoodsService {

	private GoodsDao goodsdao = Factory.getGoodsDaoInstance();
	
	//����Type������Ʒ��Ϣ
	public List<Goods> getAllGoodsByType(String type,int pages) {
		return goodsdao.getAllGoodsByType(type,pages);
	}

	//����ȫ����Ʒ��Ϣ
	public List<Goods> getAllGoods() {
		return goodsdao.getAllGoods();
	}

	//�õ����ҳ��
	public int getPage(String type) {
		return goodsdao.getPage(type);
	}
	//�õ�type�����͵����ҳ��
	public int getPageByTwoType(String type1, String type2) {
		return goodsdao.getPageByTwoType(type1, type2);
	}
	//�õ�keyword��ѯ�����ҳ��
	public int getPageBySearch(String keyword) {
		return goodsdao.getPageBySearch(keyword);
	}

	//����tasteType���� ��Ʒ��Ϣ
	public List<Goods> getGoodsByTasteType(String type,String tasteType, int pages) {
		return goodsdao.getGoodsByTasteType(type,tasteType, pages);
	}

	//����healthType������Ʒ��Ϣ
	public List<Goods> getGoodsByHealthType(String type, String healthType,
			int pages) {
		return goodsdao.getGoodsByHealthType(type, healthType, pages);
	}
	//����manufacturer������Ʒ��Ϣ
	public List<Goods> getGoodsByManufacturer(String type,
			String manufacturer, int pages) {
		return goodsdao.getGoodsByManufacturer(type, manufacturer, pages);
	}

	//���ݹؼ��ֲ��������Ʒ��Ϣ
	public List<Goods> getGoodsByKeyWord(String keyword, int pages) {
		return goodsdao.getGoodsByKeyWord(keyword, pages);
	}

	/**
	 * ����ID������Ʒ��Ϣ
	 * @param id ��ƷID
	 * @return Goods
	 * */
	public Goods getGoodsById(int id) {
		return goodsdao.getGoodsById(id);
	}

	/**
	 * ����ջ���ַ��Ϣ
	 * @return int����
	 * */
	public int addAddress(Address a) {
		return goodsdao.addAddress(a);
	}

	

	
	
}
