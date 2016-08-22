package com.bin.lookz.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bin.lookz.entity.Goods;
import com.bin.lookz.util.Factory;
import com.bin.lookz.util.StringUtilBin;
import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class AdminsAddGoodsServlet extends HttpServlet {

	private static final long serialVersionUID = 322724367722043383L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ׼���ļ����յĸ�Ŀ¼
		@SuppressWarnings("unused")
		String rootDir=this.getInitParameter("rootDir");
		String allowlist=this.getInitParameter("allowlist");
		//System.out.println(rootDir);
		rootDir = this.getServletContext().getRealPath("//file");
		String filename=null;
		//System.out.println(rootDir);
		try {
			// ����smartUpload����
			SmartUpload su = new SmartUpload();
			// ��ʼ��
			su.initialize(this.getServletConfig(), request, response);
			// ����
			// ���������ϴ�����
			su.setAllowedFilesList(allowlist);
			// ���������ϴ��ĵ����ļ���С
			su.setMaxFileSize(1024 * 1024 * 5);
			// ���������ϴ������ļ���С
			su.setTotalMaxFileSize(1024 * 1024 * 20);
			// �ϴ�(ֵ�������)
			su.upload();
			// ��ȡ�����ļ�
			Files files = su.getFiles();
			//System.out.println(files);
			// ��ȡ�ļ�����
			int count = files.getCount();
			//System.out.println(count);
			// ������ȡÿ���ļ�
			for (int i = 0; i < count; i++) {
				// ��ȡ��ǰ�������ļ�
				File file = files.getFile(i);
				//System.out.println(filename);
				// �ж��ļ����Ƿ�Ϊ��
				if (file.getSize() > 0) {
					filename = file.getFileName();

					// �����ļ��ľ���·��
					String path="D:\\MyEclipse 8.5\\Workspaces2\\lookz\\WebRoot\\images\\updFile\\"+filename;
					//String path = rootDir + java.io.File.separator + filename;
					//System.out.print("�ļ��ľ���·��:"+path);
					// ����ǰ�ļ�������������ָ��Ŀ¼
					file.saveAs(path);
					
				}
			}
			//�ϴ��ļ�ͬʱ�ϴ�������
			Request req=su.getRequest();

			String name = StringUtilBin.filterHtml(req.getParameter("name"));
			String introduce = StringUtilBin.filterHtml(req.getParameter("introduce"));
			String type = StringUtilBin.filterHtml(req.getParameter("type"));
			String tasteType = StringUtilBin.filterHtml(req.getParameter("tasteType"));
			String healthType = StringUtilBin.filterHtml(req.getParameter("healthType"));
			String manufacturer = StringUtilBin.filterHtml(req.getParameter("manufacturer"));
			double price = Double.parseDouble(StringUtilBin.filterHtml(req.getParameter("price")));
			int evaluate = getEvaluate();
			int num = Integer.parseInt(StringUtilBin.filterHtml(req.getParameter("num")));
			double dicount = Double.parseDouble(StringUtilBin.filterHtml(req.getParameter("dicount")));
			
			Goods g = new Goods(name,introduce,type,tasteType,healthType,manufacturer,price,filename,evaluate,num,dicount);
			
			int i = Factory.getAdminsGoodsServiceInstance().addGoods(g);
			if(i>0){
				System.out.println("��ӳɹ�!");
				request.setAttribute("msg", "��ӳɹ�!");
				request.getRequestDispatcher("admin/addGoods.jsp").forward(request, response);
				//response.sendRedirect("ShowGoodsServlet");
			}else{
				System.out.println("���ʧ��!");
				request.setAttribute("msg", "���ʧ��!");
				request.getRequestDispatcher("admin/addGoods.jsp").forward(request, response);
			}
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}
		
	}
	
	//�������Ʒ����
	public int getEvaluate(){
		int m = (int)((Math.random()*9+1) * 1000);
		return m;
	}

}
