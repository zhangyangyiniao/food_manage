package com.myweb.dao.impl;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.myweb.dao.FoodDao;
import com.myweb.entity.Food;
import com.myweb.util.BaseDao;
import com.myweb.dao.*;

public class FoodDaoImpl implements FoodDao{
	
	@Override
	public Food selectByFid(int fid) {
		String sql = "select * from food where fid=?";
		
		Food food = null;
		
		BaseDao baseDao = new BaseDao();
		
		baseDao.open();
		
		ResultSet rs = baseDao.execDQL(sql,fid);
		
		try {
			if(rs.next()) {
				food = new Food(
						rs.getInt("fid"),
						rs.getInt("tid"),
						rs.getString("fname"),
						rs.getString("fpic"),
						rs.getDouble("fprice"),
						rs.getInt("forder"),
						rs.getString("fdesc"),
						rs.getString("fregtime"),null
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		baseDao.close();
		
		return food;
	}
	
	
	@Override
	public List<Food> selectAll() {
		String sql = "select * from food";
		
		List<Food> list = new ArrayList<Food>();
		
		BaseDao baseDao = new BaseDao();
		
		baseDao.open();
		
		ResultSet rs = baseDao.execDQL(sql);
		
		
		try {
			while(rs.next()) {
				list.add(new Food(
						rs.getInt("fid"),
						rs.getInt("tid"),
						rs.getString("fname"),
						rs.getString("fpic"),
						rs.getDouble("fprice"),
						rs.getInt("forder"),
						rs.getString("fdesc"),
						rs.getString("fregtime"),null
						));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		baseDao.close();
		
		return list;
		
	}

	@Override
	public int getNum() {
		String sql = "select * from food";
		
		BaseDao baseDao = new BaseDao();
		
		baseDao.open();
		
		ResultSet rs = baseDao.execDQL(sql);
		
		int a = 0;
		
		try {
			while(rs.next()) {
				a ++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		baseDao.close();
		
		return a;
		
	}
	
	@Override
	public List<Food> selectByTid(int tid) {
		String sql = "select * from food where tid=?";
		
		List<Food> list = new ArrayList<Food>();
		
		BaseDao baseDao = new BaseDao();
		
		baseDao.open();
		
		ResultSet rs = baseDao.execDQL(sql,tid);
		
		try {
			while(rs.next()) {
				list.add(new Food(
						rs.getInt("fid"),
						rs.getInt("tid"),
						rs.getString("fname"),
						rs.getString("fpic"),
						rs.getDouble("fprice"),
						rs.getInt("forder"),
						rs.getString("fdesc"),
						rs.getString("fregtime"),null
						));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		baseDao.close();
		
		return list;
	}

	@Override
	public int insert(Food food) {
		 LocalDateTime currentDateTime = LocalDateTime.now();
		
		String sql = "insert into food(fid,tid,fname,fpic,fprice, fdesc,fregtime) values(?,?,?,?,?,?,?)";
		
		int count = -1;
		
		BaseDao baseDao = new BaseDao();
		
		baseDao.open();
		
		count = baseDao.execDML(sql,food.getFid(),food.getTid(),food.getFname(),food.getFpic(),food.getFprice(),food.getFdesc(),currentDateTime);
			
		baseDao.close();
		
		return count;
	}

	@Override
	public int delete(int fid) {
		
		String sql = "delete from food where fid=?";
		
		int count = -1;
		
		BaseDao baseDao = new BaseDao();
		
		baseDao.open();
		
		count = baseDao.execDML(sql,fid);
			
		baseDao.close();
		
		return count;
	}


	@Override
	public int update(Food food) {
		//1��4�����޸ĵ�ֵ��1����û��--service
		//2:��̬����װsql
		//tid=?,fpic=?,fprice=? where fid=?
		
//		StringBuilder sql = new StringBuilder("update food set ");
//		
//		Integer fid = food.getFid();
//		
//		Integer tid = food.getTid();
//		String fname = food.getFname();
//		String fpic = food.getFpic();
//		Double fprice = food.getFprice();
//		
//		if(tid!=null) {
//			sql.append("tid=?,");
//		}
//		if(fname!=null) {
//			sql.append("fname=?,");
//		}
//		if(fpic!=null) {
//			sql.append("fpic=?,");
//		}
//		if(fprice!=null) {
//			sql.append("fprice=?,");
//		}
//		
//		String tsql = sql.toString().substring(0,sql.toString().length()-1)+" where fid=?";
//		
//		
//		int count = -1;
//		
//		BaseDao baseDao = new BaseDao();
//		
//		baseDao.open();
//		
//		count = baseDao.execDML(tsql);
//			
//		baseDao.close();
//		
//		return count;
		
        String sql = "update food set tid=?, fname=?, fpic=?, fprice=?, forder=?, fdesc=?, fregtime=NOW() where fid=?";
        
        int count = -1;
        
        BaseDao baseDao = new BaseDao();
        
        baseDao.open();
        
        
        count = baseDao.execDML(sql, food.getTid(), food.getFname(), food.getFpic(), food.getFprice(), 
                                1, food.getFdesc(),  food.getFid());
            
        baseDao.close();
        
        return count;
	}


	@Override
	public List<Food> getFoodsByQus(String fname, String ftype, String fdesc) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		
		if(fname!=null && !fname.equals("")) {
			sb.append("select * from food where fname like '%"+fname+"%' union ");
		}
		if(ftype!=null && !ftype.equals("")) {
			sb.append("select * from food where tid in (select tid from ftype where tname like '%"+ftype+"%') union ");
		}
		if(fdesc!=null && !fdesc.equals("")) {
			sb.append("select * from food where fdesc like '%"+fdesc+"%' union ");
		}
		
		sb.delete(sb.lastIndexOf("union"), sb.length());
		
		System.out.println(sb.toString());
		
		List<Food> list = new ArrayList<Food>();
		
		BaseDao baseDao = new BaseDao();
		
		FtypeDao tdi = new FtypeDaoImpl();
		
		baseDao.open();
		
		ResultSet rs = baseDao.execDQL(sb.toString());
		
		try {
			while(rs.next()) {
				list.add(new Food(
						rs.getInt("fid"),
						rs.getInt("tid"),
						rs.getString("fname"),
						rs.getString("fpic"),
						rs.getDouble("fprice"),
						rs.getInt("forder"),
						rs.getString("fdesc"),
						rs.getString("fregtime"),tdi.selectByTid(rs.getInt("tid"))
						));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("List:"+list.toString());
		
		baseDao.close();
		return list;
	}
	
}
