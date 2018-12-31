package org.shop.service;

import java.util.List;

import org.shop.pojo.FenLei;

public interface FenLeiService {
    //界面展示所有数据
	List<FenLei> selectAll();
	//按条件查询数据
	List<FenLei> selectOne(FenLei fenlei);
	
	int insert(FenLei fenlei);
	
	int update(FenLei fenlei);
	
	int delete(int sortId);
	
	int selectByKey(FenLei fenlei);
	
	int selectByNameKey(FenLei fenlei);
}
