package com.myweb.dao;

import java.util.List;

import com.myweb.entity.Food;



public interface FoodDao {
	List<Food> selectAll();
	List<Food> selectByTid(int tid);
	Food selectByFid(int fid);
	int insert(Food food);
	int delete(int fid);
	int update(Food food);
	int getNum();
	List<Food> getFoodsByQus(String fname,String ftype,String fdesc);
	
}
