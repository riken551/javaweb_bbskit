package com.icss.bbs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.icss.bbs.common.Pager;
import com.icss.bbs.pojo.Message;
import com.icss.bbs.service.MessageService;

/**
 * ��ҳ��ѯ���ݷ��ʽӿ�
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
@WebServlet("/QueryMsgServlet")
public class QueryMsgServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
				
		// �����������Ӧ����
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		PrintWriter out = response.getWriter();

		// ���ҳ��
		String pageNumStr = request.getParameter("pageNum");
		// ���ÿҳ������
		String pageSizeStr = request.getParameter("pageSize");

		int pageNum = 1;

		try {
			pageNum = Integer.parseInt(pageNumStr);
		} catch (Exception e) {

		}

		int pageSize = 10;

		try {
			pageSize = Integer.parseInt(pageSizeStr);
		} catch (Exception e) {

		}

		MessageService service = new MessageService();

		try {
			//��ҳ����
			Pager pager = new Pager(service.getCount(), pageSize, pageNum);
			//��ҳ���� 
			ArrayList<Message> list = service.query(pager);
			
			Gson gson = new GsonBuilder()  
			  .setDateFormat("yyyy-MM-dd HH:mm:ss")  
			  .create();
			
			HashMap<String, Object> map = new HashMap<String,Object>();
			map.put("pager", pager);
			map.put("list", list);
			
			out.write(gson.toJson(map));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//ģ�������ӳ�
		/*try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}*/

	}

}