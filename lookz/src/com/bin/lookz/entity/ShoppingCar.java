package com.bin.lookz.entity;

import java.io.Serializable;
import java.util.ArrayList;

public class ShoppingCar implements Serializable{

	private static final long serialVersionUID = -4406699576449954887L;
	//��Ʒ�ļ���
	private ArrayList<Goods> goodslist = new ArrayList<Goods>();
	//��Ʒ����
	private ArrayList<Integer> goodsNum = new ArrayList<Integer>();
	//���ﳵ�ܼ�
	private double sumPrice;
	//���ﳵ������
	private int sumCount;
	
	public ShoppingCar() {
	}

	public ShoppingCar(ArrayList<Goods> goodslist, ArrayList<Integer> goodsNum,
			double sumPrice, int sumCount) {
		super();
		this.goodslist = goodslist;
		this.goodsNum = goodsNum;
		this.sumPrice = sumPrice;
		this.sumCount = sumCount;
	}

	public ArrayList<Goods> getGoodslist() {
		return goodslist;
	}

	public void setGoodslist(ArrayList<Goods> goodslist) {
		this.goodslist = goodslist;
	}

	public ArrayList<Integer> getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(ArrayList<Integer> goodsNum) {
		this.goodsNum = goodsNum;
	}

	public double getSumPrice() {
		return sumPrice;
	}

	public void setSumPrice(double sumPrice) {
		this.sumPrice = sumPrice;
	}

	public int getSumCount() {
		return sumCount;
	}

	public void setSumCount(int sumCount) {
		this.sumCount = sumCount;
	}
	
	
	
}
