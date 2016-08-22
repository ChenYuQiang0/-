package com.bin.lookz.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bin.lookz.entity.Goods;
import com.bin.lookz.entity.ShoppingCar;
import com.bin.lookz.entity.Users;

public class DelShopGoodsServlet extends HttpServlet {

	private static final long serialVersionUID = -44637804858862656L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��ȡ����
		String[] index = request.getParameterValues("index");
		
		Users u = (Users) request.getSession().getAttribute("user");
		ShoppingCar car = u.getShoppingCar();
		
		//ͨ������ɾ����Ϣ
		for (int i = index.length-1; i>=0; i--) {
			int in = Integer.parseInt(index[i]);
			car.getGoodslist().remove(in);
			car.getGoodsNum().remove(in);
		}
		
		//���ù��ﳵ�ܼ�
		car.setSumPrice(this.getSumPrice(car.getGoodslist(), car.getGoodsNum()));
		//���ù��ﳵ������
		car.setSumCount(this.getSumCount(car.getGoodsNum()));
		response.sendRedirect("cart.jsp");
	}
	
	//���ﳵ�ܼ�
	public double getSumPrice(ArrayList<Goods> goods,ArrayList<Integer> counts){
		double d = 0;
		for(int i=0;i<goods.size();i++){
			d+=goods.get(i).getPrice()*counts.get(i);
		}
		return d;
	}

	//���ﳵ������
	public int getSumCount(ArrayList<Integer> counts){
		int c = 0;
		for(int i=0;i<counts.size();i++){
			c+=counts.get(i);
		}
		return c;
	}

}
