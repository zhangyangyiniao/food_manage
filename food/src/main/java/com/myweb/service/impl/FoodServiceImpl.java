package com.myweb.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.myweb.dao.FoodDao;
import com.myweb.dao.FtypeDao;
import com.myweb.dao.impl.FoodDaoImpl;
import com.myweb.dao.impl.FtypeDaoImpl;
import com.myweb.entity.Food;
import com.myweb.entity.Ftype;
import com.myweb.service.FoodService;



public class FoodServiceImpl implements FoodService{
	
	private FoodDao foodDao = new FoodDaoImpl();
	private FtypeDao ftypeDao = new FtypeDaoImpl();

	@Override
	public List<Food> getAllWithFtype() {
		
		List<Food> list = foodDao.selectAll();
		Map<Integer,Ftype> map = new HashMap<Integer, Ftype>();
		
		int count = 0;
		
		for(int i=0;i<list.size();i++) {
			Food f = list.get(i);
			int tid = f.getTid();
			
			Ftype ftype = map.get(tid);
			
			if(ftype == null) {
				count++;
				ftype = ftypeDao.selectByTid(tid);
				map.put(tid,ftype);
			}
			
			f.setFtype(ftype);
			
			
		}
		
		System.out.println(count);
				
		return list;
	}

	@Override
	public boolean add(Food food) {
		int a = foodDao.getNum();
		food.setFid(a + 1);
		int count = foodDao.insert(food);
		if(count>0)
			return true;
		return false;
	}

	@Override
	public boolean remove(int fid) {
		int count = foodDao.delete(fid);
		if(count>0)
			return true;
		return false;
	}

	@Override
	public Food getByFid(int fid) {
		return foodDao.selectByFid(fid);
	}

	@Override
	public void update(Food food) {
		// TODO Auto-generated method stub
		foodDao.update(food);
	}

	@Override
	public void insert(Food food) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Food> getFoodsByQus(String fname, String ftype, String fdesc) {
		// TODO Auto-generated method stub
		List<Food> answer = foodDao.getFoodsByQus(fname, ftype, fdesc);
		

		
		return answer;
	}
	
}
