package com.myweb.service;

import java.util.List;

import com.myweb.entity.Ftype;

public interface FtypeService {
	List<Ftype> getAllWithFood();
	List<Ftype> getAll();
}
