package com.bin.lookz.servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bin.lookz.entity.Order;
import com.bin.lookz.entity.ShoppingCar;
import com.bin.lookz.entity.Users;
import com.bin.lookz.util.Factory;

public class CheckoutServlet extends HttpServlet {

	private static final long serialVersionUID = 3719924134405568271L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��ȡ������
		long id = this.getOrderId();
		
		Date time = new Date(new java.util.Date().getTime()); 
		Users u = (Users)request.getSession().getAttribute("user");
		String payWay = "����֧��";
		String orderState = "��֧��";
		int order_flag = 1;
		
		Order o = new Order(id,payWay,time,orderState,order_flag);
		
		//��Ӷ�������
		Factory.getOrderServiceInstance().addAllOrder(u, o);
		
		//������ﳵ��¼
		u.setShoppingCar(new ShoppingCar());
		
		request.setAttribute("msg", "�ύ�����ɹ�!");
		request.getRequestDispatcher("successShopping.jsp?id="+id).forward(request, response);
		
	}
	
	//������ɶ�����
	public long getOrderId(){
		String t = new SimpleDateFormat("hhmmssSSS").format(new java.util.Date());
		int m = (int)((Math.random()*9+1) * 1000);
		return Long.parseLong(t+m);
	}

}
