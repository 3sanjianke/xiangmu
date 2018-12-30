package org.shop.service.impl;

import java.util.List;

import org.shop.dao.FenLeiMapper;
import org.shop.pojo.FenLei;
import org.shop.service.FenLeiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("FenLeiService")
public class FenLeiServiceImpl implements FenLeiService{

	@Autowired
	FenLeiMapper fenLeiMapper;

	@Override
	public List<FenLei> selectAll() {
		// TODO Auto-generated method stub
		return fenLeiMapper.selectByExample(null);
	}

	@Override
	public List<FenLei> selectOne(FenLei fenlei) {
		// TODO Auto-generated method stub
		return fenLeiMapper.selectOne(fenlei);
	}

	@Override
	public int insert(FenLei fenlei) {
		// TODO Auto-generated method stub
		return fenLeiMapper.insert(fenlei);
	}

	@Override
	public int update(FenLei fenlei) {
		// TODO Auto-generated method stub
		return fenLeiMapper.updateByPrimaryKey(fenlei);
	}

	@Override
	public int delete(int sortId) {
		// TODO Auto-generated method stub
		return fenLeiMapper.deleteByPrimaryKey(sortId);
	}

	@Override
	public int selectByKey(FenLei fenlei) {
		// TODO Auto-generated method stub
		return fenLeiMapper.selectByKey(fenlei);
	}

	@Override
	public int selectByNameKey(FenLei fenlei) {
		// TODO Auto-generated method stub
		return fenLeiMapper.selectByNameKey(fenlei);
	}
}
