package com.icss.bbs.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.bbs.pojo.Message;
import com.icss.bbs.service.MessageService;

/**
 * �������ݹ��ܽӿ�
 */
@SuppressWarnings("serial")
@WebServlet("/UpdateMsgServlet")
public class UpdateMsgServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// �����������Ӧ����
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		PrintWriter out = response.getWriter();

		// �������� ��
		String id = request.getParameter("id");
		String username = request.getParameter("username");
		String content = request.getParameter("content");

		// ��װpojo����
		Message msg = new Message();
		msg.setId(Integer.parseInt(id));
		msg.setUsername(username);
		msg.setContent(content);

		// ��������
		MessageService service = new MessageService();

		try {
			service.update(msg);
			out.write("�����޸ĳɹ���");
		} catch (Exception e) {
			e.printStackTrace();
		}

		// ģ�������ӳ�
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}