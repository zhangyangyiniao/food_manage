package com.myweb.dao;

import com.myweb.entity.Userinfo;

public interface UserinfoDao {
	Userinfo selectByUsercodeAndUserpwd(Userinfo userinfo);
}
