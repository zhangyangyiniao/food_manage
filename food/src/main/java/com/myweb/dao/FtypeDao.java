package com.myweb.dao;

import java.util.List;

import com.myweb.entity.Ftype;

public interface FtypeDao {
	Ftype selectByTid(int tid);
	
	List<Ftype> selectAll();


	int selectByType(String tname);
	
}

