package org.shop.service.impl;

import java.util.List;

import org.shop.dao.YuJinMapper;
import org.shop.pojo.YuJin;
import org.shop.service.YuJinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("YuJinService")
public class YuJinServiceImpl implements YuJinService{

	@Autowired
	YuJinMapper yujinMapper;
	
	@Override
	public int insert(YuJin yujin) {
		// TODO Auto-generated method stub
		return yujinMapper.insert(yujin);
	}

	@Override
	public List<YuJin> selectAll() {
		// TODO Auto-generated method stub
		return yujinMapper.selectByExample(null);
	}

	@Override
	public List<YuJin> selectOne(YuJin yujin) {
		
		return yujinMapper.selectOne(yujin);
	}

	@Override
	public int update(YuJin yujin) {
		// TODO Auto-generated method stub
		return yujinMapper.updateByKey(yujin);
	}

	@Override
	public int delete(int yujinId) {
		// TODO Auto-generated method stub
		return yujinMapper.deleteByPrimaryKey(yujinId);
	}

	@Override
	public int selectByIdKey(YuJin yujin) {
		// TODO Auto-generated method stub
		return yujinMapper.selectByIdKey(yujin);
	}
}
