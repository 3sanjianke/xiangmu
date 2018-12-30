package org.shop.service;

import java.util.List;

import org.shop.pojo.FenLei;

public interface FenLeiService {
    //����չʾ��������
	List<FenLei> selectAll();
	//��������ѯ����
	List<FenLei> selectOne(FenLei fenlei);
	
	int insert(FenLei fenlei);
	
	int update(FenLei fenlei);
	
	int delete(int sortId);
	
	int selectByKey(FenLei fenlei);
	
	int selectByNameKey(FenLei fenlei);
}
