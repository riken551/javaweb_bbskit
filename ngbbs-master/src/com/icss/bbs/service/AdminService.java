package com.icss.bbs.service;

import com.icss.bbs.dao.AdminDao;
import com.icss.bbs.pojo.Admin;

/**
 * �û���¼ҵ��
 * @author Administrator
 *
 */
public class AdminService {
	
	private AdminDao dao = new AdminDao();
	
	/**
	 * 
	 * @param admin �����û�����
	 * @return 
	 * 	����û��������� ����1
	 * 	���������� ����2
	 *  �����¼�ɹ� ����3
	 * @throws Exception 
	 */
	public int checkUser(Admin ad) throws Exception {
		
		Admin admin = dao.queryByUsername(ad.getUsername());
		
		if (admin == null) {
			return 1;
		} else if (!ad.getUserpwd().equals(admin.getUserpwd())) {
			return 2;
		} else {
			return 3;
		}
		
	}

}
