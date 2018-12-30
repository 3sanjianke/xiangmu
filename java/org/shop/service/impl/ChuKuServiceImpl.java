package org.shop.service.impl;

import java.util.List;

import org.shop.dao.ChuKuMapper;
import org.shop.dao.FenLeiMapper;
import org.shop.dao.KuCunMapper;
import org.shop.pojo.ChuKu;
import org.shop.pojo.KuCun;
import org.shop.service.ChuKuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ChuKuService")
public class ChuKuServiceImpl implements ChuKuService{

	@Autowired
	FenLeiMapper fenleiMapper;
	
	@Autowired
	KuCunMapper kucunMapper;
	
	@Autowired
	ChuKuMapper chukuMapper;
	
	@Override
	public int insert(ChuKu chuku) {
		// TODO Auto-generated method stub
		//����˼·
		//1.������shuliang
		//2.����ó�����������浽���ݱ���
		//3.��������¼
		int shuliangyuan;
		int shuliangxian;
		int shuliangchu;
		
		KuCun kucun = kucunMapper.selectByName(chuku.getShopName());
		shuliangyuan = kucun.getShopShuliang();
		shuliangchu = chuku.getChukuShuliang();
		if(shuliangyuan>shuliangchu||shuliangyuan==shuliangchu) {
			shuliangxian = shuliangyuan-chuku.getChukuShuliang();
			//���浽���ݱ���ȥ
			kucun.setShopShuliang(shuliangxian);
			int t = kucunMapper.updateShuliang(kucun);
			if(t == 1) {
				int dept = chukuMapper.insert(chuku);//��ʱ���ж�
				return 1;
			}else {
				return 0;
			}
		}else {
			return 0;
		}
		//shuliangxian = shuliangyuan-chuku.getChukuShuliang();
		//������Ʒ���ư����ݱ��浽���ݱ���
		
	//	System.out.println("------------------->:"+shuliangxian);
		
	}

	@Override
	public KuCun selectByName(String shopName) {
		// TODO Auto-generated method stub
		KuCun kucun = kucunMapper.selectByName(shopName);
		return kucun;
	}

	@Override
	public List<ChuKu> select() {
		// TODO Auto-generated method stub
		return chukuMapper.selectByExample(null);
	}

	@Override
	public List<ChuKu> selectOne(ChuKu chuku) {
		// TODO Auto-generated method stub
		return chukuMapper.selectOne(chuku);
	}

	@Override
	public int selectByIdKey(ChuKu chuku) {
		// TODO Auto-generated method stub
		return chukuMapper.selectByIdKey(chuku);
	}
}
