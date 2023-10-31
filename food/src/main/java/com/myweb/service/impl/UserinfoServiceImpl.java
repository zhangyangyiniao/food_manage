package com.myweb.service.impl;

import com.myweb.dao.UserinfoDao;
import com.myweb.dao.impl.UserinfoDaoImpl;
import com.myweb.entity.Userinfo;
import com.myweb.service.UserinfoService;

public class UserinfoServiceImpl implements UserinfoService{
	
	private UserinfoDao userinfoDao = new UserinfoDaoImpl();
	
	@Override
	public Userinfo login(Userinfo userinfo) {
		return userinfoDao.selectByUsercodeAndUserpwd(userinfo);
	}
	
	

}
