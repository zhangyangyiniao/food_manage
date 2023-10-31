package com.myweb.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.myweb.dao.FtypeDao;
import com.myweb.entity.Ftype;
import com.myweb.util.BaseDao;


public class FtypeDaoImpl implements FtypeDao{

	@Override
	public Ftype selectByTid(int tid) {
		String sql = "select * from ftype where tid=?";
		
		Ftype ftype = null;
		
		BaseDao baseDao = new BaseDao();
		
		baseDao.open();
		
		ResultSet rs = baseDao.execDQL(sql, tid);
		
		try {
			if(rs.next()) {
				ftype = new Ftype(rs.getInt("tid"),
							rs.getString("tname"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		baseDao.close();
		
		return ftype;
	}
	
	@Override
	public int selectByType(String tname) {
		String sql = "select * from ftype where tname=?";
		
		Ftype ftype = null;
		
		BaseDao baseDao = new BaseDao();
		
		baseDao.open();
		
		int a = 0;
		
		ResultSet rs = baseDao.execDQL(sql, tname);
		
		try {
			if(rs.next()) {
				a = rs.getInt("tid");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		baseDao.close();
		
		return a;
	}
	

	@Override
	public List<Ftype> selectAll() {
		String sql = "select * from ftype";
		
		List<Ftype> list = new ArrayList<Ftype>();
		
		BaseDao baseDao = new BaseDao();
		
		baseDao.open();
		
		ResultSet rs = baseDao.execDQL(sql);
		
		try {
			while(rs.next()) {
				list.add(new Ftype(
						rs.getInt("tid"),
						rs.getString("tname")
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
	public int selectByType(int tid) {
		// TODO Auto-generated method stub
		return 0;
	}

}
