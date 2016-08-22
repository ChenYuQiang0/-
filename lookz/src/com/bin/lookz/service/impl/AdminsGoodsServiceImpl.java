package com.bin.lookz.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.bin.lookz.dao.AdminsGoodsDao;
import com.bin.lookz.entity.Goods;
import com.bin.lookz.service.AdminsGoodsService;
import com.bin.lookz.util.Factory;

public class AdminsGoodsServiceImpl implements AdminsGoodsService{

	private AdminsGoodsDao adminsgoodsdao = Factory.getAdminsGoodsDaoInstance();
	
	//�����Ʒ
	public int addGoods(Goods g) {
		return adminsgoodsdao.addGoods(g);
	}

	//�õ���ǰҳ����Ʒ����
	public ArrayList<Goods> getAllGoods(int pages) {
		return adminsgoodsdao.getAllGoods(pages);
	}

	//���ݹؼ��ֲ��������Ʒ��Ϣ
	public List<Goods> getGoodsByKeyWord(String keyword,int pages) {
		return adminsgoodsdao.getGoodsByKeyWord(keyword,pages);
	}

	//�õ��������ҳ��
	public int getPage() {
		return adminsgoodsdao.getPage();
	}

	
	/**
	 * ����IDɾ����Ʒ
	 * @return ����int
	 * */
	public int delGoodsById(int id) {
		return adminsgoodsdao.delGoodsById(id);
	}

	/**
	 * ����ID������Ʒ
	 * @param ��Ʒ����
	 * @return ����Goods����
	 * */
	public Goods getGoodsById(int id) {
		return adminsgoodsdao.getGoodsById(id);
	}

	/**
	 * ����goods���޸���Ʒ��Ϣ
	 * @param Goods ��Ʒ����
	 * @return int����
	 * */
	public int updGoodsByGoods(Goods g) {
		return adminsgoodsdao.updGoodsByGoods(g);
	}

	/**
	 * �õ���ѯ�����ҳ��
	 * @return int 
	 * */
	public int getPageBySearch(String keyword) {
		return adminsgoodsdao.getPageBySearch(keyword);
	}

}
