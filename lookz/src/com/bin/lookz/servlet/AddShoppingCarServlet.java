package com.bin.lookz.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bin.lookz.entity.Goods;
import com.bin.lookz.entity.ShoppingCar;
import com.bin.lookz.entity.Users;
import com.bin.lookz.util.Factory;

public class AddShoppingCarServlet extends HttpServlet {

	private static final long serialVersionUID = -4777331974158283204L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		//ͨ��ID������Ʒ��Ϣ
		Goods good = Factory.getGoodsServiceInstance().getGoodsById(id);
		System.out.println(good.getName());
		//��ȡ���ﳵ�û��Ķ���
		Users user = (Users)request.getSession().getAttribute("user");
		ShoppingCar car = user.getShoppingCar();
		
		boolean b = false;
		//�жϸ���Ʒ�Ƿ����
		for (int i = 0; i < car.getGoodslist().size(); i++) {
			if(car.getGoodslist().get(i).getId() == good.getId()){
				/**
				 * �������Ʒ��� ���޸ĸ���Ʒ��Ӧ������
				 * */
				int count = car.getGoodsNum().get(i); //�õ���ǰ�����Ʒ������
				car.getGoodsNum().set(i, count+1);
				//�޸�״̬
				b = true;
				break;
			}
		}
		//�������ǵ�һ�ι���
		if(!b){
			car.getGoodslist().add(good); //��Ʒ�ӽ�ȥ
			car.getGoodsNum().add(1);  //������1
		}
		
		//���ù��ﳵ�ܼ�
		car.setSumPrice(this.getSumPrice(car.getGoodslist(), car.getGoodsNum()));
		//���ù��ﳵ������
		car.setSumCount(this.getSumCounts(car.getGoodsNum()));
		//�õ���ǰ��ʱ��
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentTime =format.format(new Date());
		
		System.out.println(car.getSumCount());
		System.out.println(user.getCar_flag());
		//��ӵ����ﳵ��
		Factory.getShoppingCarServiceInstance().addShoppingCart(car.getSumCount(), car.getSumPrice(), currentTime, user.getCar_flag());
		//��תҳ����ʾ
		response.sendRedirect("cart.jsp");
	}
	
	//�õ����ﳵ�ܼ�
	public double getSumPrice(ArrayList<Goods> goods,ArrayList<Integer> counts){
		double d = 0;
		for (int i=0;i<goods.size();i++) {
			d+=goods.get(i).getPrice()*counts.get(i);
		}
		return d;
	}
	
	//�õ����ﳵ��������
	public int getSumCounts(ArrayList<Integer> counts){
		int c = 0;
		for (int i = 0; i < counts.size(); i++) {
			c += counts.get(i);
		}
		return c;
	}

}
