package org.shop.service;

import java.util.List;

import org.shop.pojo.ChuKu;
import org.shop.pojo.KuCun;

public interface ChuKuService {

	public int insert(ChuKu chuku);
	
	public KuCun selectByName(String shopName);
	
	public List<ChuKu> select();
	
	public List<ChuKu> selectOne(ChuKu chuku);
	
	public int selectByIdKey(ChuKu chuku);
}
