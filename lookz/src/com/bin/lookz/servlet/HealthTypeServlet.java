package com.bin.lookz.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bin.lookz.entity.Goods;
import com.bin.lookz.util.Factory;
import com.bin.lookz.util.StringUtilBin;

public class HealthTypeServlet extends HttpServlet {

	private static final long serialVersionUID = -8220169414593894412L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String healthType = StringUtilBin.filterHtml(request.getParameter("healthType"));
		String type = StringUtilBin.filterHtml(request.getParameter("type"));
		int pages;
		String page = StringUtilBin.filterHtml(request.getParameter("pages"));
		if(page==null){
			pages = 1;
		}else{
			pages = Integer.parseInt(page);
		}
		List<Goods> goodslist = new ArrayList<Goods>();
		
		goodslist = Factory.getGoodsServiceInstance().getGoodsByHealthType(type,healthType, pages);
		System.out.println(goodslist.size());
		if(goodslist.size()<1){
			response.sendRedirect("404.jsp");
		}else{
			int maxpages = Factory.getGoodsServiceInstance().getPageByTwoType(type, healthType);
			request.setAttribute("cutpage", pages);
			request.setAttribute("goodslist", goodslist);
			request.setAttribute("maxpages", maxpages);
			
			if(type.equals("����")){
				request.getRequestDispatcher("main.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("cake.jsp").forward(request, response);
			}
		}
	}

}
