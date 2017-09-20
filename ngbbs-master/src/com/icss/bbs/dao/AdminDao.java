package com.icss.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.icss.bbs.common.DbUtil;
import com.icss.bbs.pojo.Admin;


/**
 * ����Ա��¼DAO
 * @author Administrator
 *
 */
public class AdminDao {
	
	/**
	 * �����û�����ѯ���û�����
	 * @param username
	 * @return
	 * @throws Exception
	 */
	public Admin queryByUsername(String username) throws Exception {
		
		Admin admin = null;
		
		Connection conn = DbUtil.getConnection();
		
		String sql = "select * from admin where username=?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, username);
		
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			admin = new Admin(rs.getInt(1),rs.getString(2),rs.getString(3));			
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return admin;
	}

}
