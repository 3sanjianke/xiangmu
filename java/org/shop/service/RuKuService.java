package org.shop.service;

import java.util.List;

import org.shop.pojo.RuKu;

public interface RuKuService {

	public int insert(RuKu ruku);
	
	public List<RuKu> select();
	
	public List<RuKu> selectByKey(RuKu ruku);
	
	public int selectByIdKey(RuKu ruku);
}
