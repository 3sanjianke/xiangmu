package org.shop.service;

import java.util.List;

import org.shop.pojo.YuJin;

public interface YuJinService {

	public int insert(YuJin yujin);
	
	public List<YuJin> selectAll();
	
	public List<YuJin> selectOne(YuJin yujin);
	
	public int update(YuJin yujin);
	
	public int delete(int yujinId);
	
	public int selectByIdKey(YuJin yujin);
}
