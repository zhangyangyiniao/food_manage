package com.myweb.service.impl;

import java.util.List;

import com.myweb.dao.FoodDao;
import com.myweb.dao.FtypeDao;
import com.myweb.dao.impl.FoodDaoImpl;
import com.myweb.dao.impl.FtypeDaoImpl;
import com.myweb.entity.Ftype;
import com.myweb.service.FtypeService;


public class FtypeServiceImpl implements FtypeService{
	
	private FoodDao foodDao = new FoodDaoImpl();
	private FtypeDao ftypeDao = new FtypeDaoImpl();

	@Override
	public List<Ftype> getAllWithFood() {
		
		List<Ftype> list = ftypeDao.selectAll();
		
		for(int i=0;i<list.size();i++) {
			Ftype ftype = list.get(i);
			ftype.setFoodList(foodDao.selectByTid(ftype.getTid()));
		}
		
		
		
		return list;
	}

	@Override
	public List<Ftype> getAll() {
		return ftypeDao.selectAll();
	}
	
}