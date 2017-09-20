package com.icss.bbs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.bbs.pojo.Message;
import com.icss.bbs.service.MessageService;

/**
 * Servlet�������ݵĺ�̨�ӿ�
 */
@SuppressWarnings("serial")
@WebServlet("/InsertMessageServlet")
public class InsertMessageServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		//�����������Ӧ����
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		//����������
		String username = request.getParameter("username");
		String content = request.getParameter("content");
		
		//��װpojo����
		Message msg = new Message(username,content,new Date(),request.getRemoteAddr(),0);
		
		//��������
		MessageService service = new MessageService();
		
		try {
			service.insert(msg);
			out.write("���۷���ɹ���");
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		//ģ�������ӳ�
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}