package com.myweb.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.myweb.dao.UserinfoDao;
import com.myweb.entity.Userinfo;
import com.myweb.util.BaseDao;

public class UserinfoDaoImpl implements UserinfoDao{

	@Override
	public Userinfo selectByUsercodeAndUserpwd(Userinfo userinfo) {
		
		String sql = "select * from userinfo where usercode=? and userpwd=?";
		
		Userinfo getUser = null;
		
		BaseDao baseDao = new BaseDao();
		
		baseDao.open();
		
		ResultSet rs = baseDao.execDQL(sql, userinfo.getUsercode(),userinfo.getUserpwd());
		
		try {
			if(rs.next()) {
				getUser = new Userinfo(rs.getInt("userid"),
						userinfo.getUsercode(),"******",
						rs.getString("nickname"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		baseDao.close();
		
		return getUser;
		
		
	}
	
}
