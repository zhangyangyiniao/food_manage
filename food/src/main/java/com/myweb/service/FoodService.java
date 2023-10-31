package com.myweb.service;

import java.util.List;

import com.myweb.entity.Food;

public interface FoodService {
	
	List<Food> getAllWithFtype();
	Food getByFid(int fid);
	
	List<Food> getFoodsByQus(String fname,String ftype,String fdesc);
	
	boolean add(Food food);
	
	boolean remove(int fid);
	void update(Food food);
	void insert(Food food);
	
}

