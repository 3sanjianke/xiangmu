package org.shop.service.impl;

import java.util.List;

import org.shop.dao.FenLeiMapper;
import org.shop.dao.KuCunMapper;
import org.shop.pojo.KuCun;
import org.shop.service.KuCunService;
import org.shop.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("KuCunService")
public class KuCunServiceImpl implements KuCunService{

	@Autowired
	KuCunMapper kucunMapper;
	
	@Autowired
	FenLeiMapper fenleiMapper;
	
	@Override
	public List<KuCun> selectAll() {
		// TODO Auto-generated method stub
		return kucunMapper.selectByExample(null);
	}

	@Override
	public List<KuCun> selectOne(KuCun kucun) {
		// TODO Auto-generated method stub
		return kucunMapper.selectOne(kucun);
	}

	@Override
	public int update(KuCun kucun) {
		// TODO Auto-generated method stub
		return kucunMapper.updateByPrimaryKey(kucun);
	}

	@Override
	public int delete(int kucunId) {
		// TODO Auto-generated method stub
		return kucunMapper.deleteByPrimaryKey(kucunId);
	}

	@Override
	public int insert(KuCun kucun) {
		// TODO Auto-generated method stub
		return kucunMapper.insert(kucun);
	}

	@Override
	public List<String> selectAllNames() {
		// TODO Auto-generated method stub
		List<String> list = fenleiMapper.selectAllNames();
		return list;
	}

	@Override
	public List<String> selectAllNamess() {
		// TODO Auto-generated method stub
		List<String> list = kucunMapper.selectAllNames();
 		return list;
	}

	@Override
	public List<String> selectFenlei(String shopName) {
		// TODO Auto-generated method stub
		return kucunMapper.selectFenlei(shopName);
	}

	@Override
	public List<Integer> selectShuliang(String shopName) {
		// TODO Auto-generated method stub
		return kucunMapper.selectShuliang(shopName);
	}

	@Override
	public int selectByKey(KuCun kucun) {
		// TODO Auto-generated method stub
		return kucunMapper.selectByKey(kucun);
	}

	@Override
	public int selectByNameKey(KuCun kucun) {
		// TODO Auto-generated method stub
		return kucunMapper.selectByNameKey(kucun);
	}
}
