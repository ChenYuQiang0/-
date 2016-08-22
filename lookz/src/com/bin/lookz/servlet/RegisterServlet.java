package com.bin.lookz.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bin.lookz.entity.Pp;
import com.bin.lookz.entity.Users;
import com.bin.lookz.util.Factory;
import com.bin.lookz.util.StringUtilBin;

public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 4829489784075251862L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = StringUtilBin.filterHtml(request.getParameter("name"));
		String password = StringUtilBin.filterHtml(request.getParameter("password"));
		String sex = StringUtilBin.filterHtml(request.getParameter("sex"));
		String email = StringUtilBin.filterHtml(request.getParameter("email"));
		int car_flag = getCarFlag();
		
		String ppone = StringUtilBin.filterHtml(request.getParameter("ppone"));
		String pptwo = StringUtilBin.filterHtml(request.getParameter("pptwo"));
		String ppthree = StringUtilBin.filterHtml(request.getParameter("ppthree"));
		
		Users u = new Users(name,password,sex,email,car_flag);
		Pp p = new Pp(email,ppone,pptwo,ppthree,1);
		int i = Factory.getUsersServiceInstance().register(u);
		int n = Factory.getUsersServiceInstance().addPp(p);
		if(i>0&&n>0){
			System.out.println("ע��ɹ�!");
			request.setAttribute("msg", "ע��ɹ�!");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else{
			System.out.println("ע��ʧ��!");
			request.setAttribute("msg", "ע��ʧ��!");
			request.getRequestDispatcher("404.jsp").forward(request, response);
		}
		
	}

	//�������carFlag
	public int getCarFlag(){
		int m;
		m = (int)((Math.random()*9+1) * 10000);
		return m;
	}
	
}
