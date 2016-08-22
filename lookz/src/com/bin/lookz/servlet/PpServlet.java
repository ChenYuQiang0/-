package com.bin.lookz.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bin.lookz.entity.Pp;
import com.bin.lookz.util.Factory;
import com.bin.lookz.util.StringUtilBin;

public class PpServlet extends HttpServlet {

	private static final long serialVersionUID = -9196487655668892335L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ppOne = StringUtilBin.filterHtml(request.getParameter("ppone"));
		String ppTwo = StringUtilBin.filterHtml(request.getParameter("pptwo"));
		String ppThree = StringUtilBin.filterHtml(request.getParameter("ppthree"));
		//System.out.println(ppOne);
		Pp p = Factory.getUsersServiceInstance().findPp(ppOne, ppTwo, ppThree);
		//System.out.println(p);
		if(p!=null){
			System.out.println("�һ�����ɹ�!");
			request.setAttribute("msg", "������Ϣ�ѷ����������䣬����գ�");
			request.getRequestDispatcher("pp.jsp").forward(request, response);
		}else{
			System.out.println("�һ�����ʧ��!");
			request.getRequestDispatcher("pp.jsp").forward(request, response);
		}
	}

}
