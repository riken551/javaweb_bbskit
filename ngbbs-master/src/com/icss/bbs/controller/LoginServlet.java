package com.icss.bbs.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icss.bbs.pojo.Admin;
import com.icss.bbs.service.AdminService;

/**
 * ��¼�ӿ�
 */
@SuppressWarnings("serial")
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();

//		����������
		String username = request.getParameter("username");
		String userpwd = request.getParameter("userpwd");
		
		System.out.println("username=" + username);
		System.out.println("userpwd=" + userpwd);
		
//		��װΪ����
		Admin admin = new Admin(username,userpwd);
		
//		����ҵ�����
		AdminService service = new AdminService();
		
		try {
			int result = service.checkUser(admin);
			
			if (result == 3) {
//				��session�����õ�¼��ʶ���洢�û������룩
				HttpSession session = request.getSession();
				session.setAttribute("admin", admin);
			}
			
			out.print(result);
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
