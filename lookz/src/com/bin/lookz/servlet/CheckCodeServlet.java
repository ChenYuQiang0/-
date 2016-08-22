package com.bin.lookz.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *������֤��ͼƬ
 */
public class CheckCodeServlet extends HttpServlet {

	private static final long serialVersionUID = 650758864976379528L;

	/**
	 * ��֤��ͼƬ�Ŀ�ȡ�
	 */
	private int width = 80;

	/**
	 * ��֤��ͼƬ�ĸ߶ȡ�
	 */
	private int height = 30;

	/**
	 * ��֤���ַ�����
	 */
	private int codeCount = 4;

	/**
	 * xx
	 */
	private int xx = 0;

	/**
	 * ����߶�
	 */
	private int fontHeight;

	/**
	 * codeY
	 */
	private int codeY;

	/**
	 * codeSequence
	 */
	char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J',
			'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
			'X', 'Y', 'Z', '2', '3', '4', '5', '6', '7', '8', '9' };

	/**
	 * ��ʼ����֤ͼƬ����
	 */
	public void init() throws ServletException {
		// ��web.xml�л�ȡ��ʼ��Ϣ
		// ���
		String strWidth = this.getInitParameter("width");
		// �߶�
		String strHeight = this.getInitParameter("height");
		// �ַ�����
		String strCodeCount = this.getInitParameter("codeCount");

		// �����õ���Ϣת������ֵ
		try {
			if (strWidth != null && strWidth.length() != 0) {
				width = Integer.parseInt(strWidth);
			}
			if (strHeight != null && strHeight.length() != 0) {
				height = Integer.parseInt(strHeight);
			}
			if (strCodeCount != null && strCodeCount.length() != 0) {
				codeCount = Integer.parseInt(strCodeCount);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		//����������
		xx = (width + 60) / (codeCount + 5);
		//��������߶�
		fontHeight = height - 10;
		codeY = height - 6;
	}

	/**
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws java.io.IOException
	 */
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, java.io.IOException {

		// ����ͼ��buffer
		BufferedImage buffImg = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		Graphics2D gd = buffImg.createGraphics();

		// ����һ���������������
		Random random = new Random();

		// ��ͼ�����Ϊ��ɫ
		gd.setColor(Color.WHITE);
		gd.fillRect(0, 0, width, height);

		// �������壬����Ĵ�СӦ�ø���ͼƬ�ĸ߶�������
		Font font = new Font("΢���ź�", Font.PLAIN, fontHeight);
		// �������塣
		gd.setFont(font);

		// ���߿�
		gd.setColor(Color.WHITE);
		gd.drawRect(0, 0, width - 1, height - 1);

		// �������16�������ߣ�ʹͼ���е���֤�벻�ױ���������̽�⵽��
		gd.setColor( Color.GRAY );
		for (int i = 0; i < 120; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(3);
			int yl = random.nextInt(3);
			gd.drawLine(x, y, x + xl, y + yl);
		}

		// randomCode���ڱ��������������֤�룬�Ա��û���¼�������֤��
		StringBuffer randomCode = new StringBuffer();
		int red = 0, green = 0, blue = 0;

		// �������codeCount���ֵ���֤�롣
		for (int i = 0; i < codeCount; i++) {
			// �õ������������֤�����֡�
			String strRand = String.valueOf(codeSequence[random.nextInt(32)]);
			// �����������ɫ������������ɫֵ�����������ÿλ���ֵ���ɫֵ������ͬ��
			red = random.nextInt(200);
			green = random.nextInt(200);
			blue = random.nextInt(200);

			// �������������ɫ����֤����Ƶ�ͼ���С�
			//gd.setColor(Color.BLACK);
			gd.setColor(new Color(red,green,blue));
			gd.drawString(strRand, (i + 1) * xx, codeY);

			// ���������ĸ�����������һ��
			randomCode.append(strRand);
		}

		// ����λ���ֵ���֤�뱣�浽Session�С�
		HttpSession session = req.getSession();
		session.setAttribute("checkCode", randomCode.toString());

		// ��ֹͼ�񻺴档
		resp.setHeader("Pragma", "no-cache");
		resp.setHeader("Cache-Control", "no-cache");
		resp.setDateHeader("Expires", 0);
		
		//��Ӧ����Ϊ ͼƬ����
		resp.setContentType("image/jpeg");

		// ��ͼ�������Servlet������С�
		ServletOutputStream sos = resp.getOutputStream();
		ImageIO.write(buffImg, "jpeg", sos);
		sos.close();

		System.out.println("��֤��Ϊ: " + randomCode.toString());
	}

}