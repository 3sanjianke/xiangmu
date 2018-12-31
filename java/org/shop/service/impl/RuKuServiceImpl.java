package org.shop.service.impl;

import java.util.List;

import org.shop.dao.FenLeiMapper;
import org.shop.dao.KuCunMapper;
import org.shop.dao.RuKuMapper;
import org.shop.pojo.KuCun;
import org.shop.pojo.RuKu;
import org.shop.service.RuKuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("RuKuService")
public class RuKuServiceImpl implements RuKuService{

	@Autowired
	FenLeiMapper fenleiMapper;
	
	@Autowired
	KuCunMapper kucunMapper;
	
	@Autowired
	RuKuMapper rukuMapper;
	
	@Override
	public int insert(RuKu ruku) {
		// TODO Auto-generated method stub
		List<Integer> list = null;
		int shuliangyuan;
		int shuliangxian = 0;
		
		//���ȱ�����ⵥ��Ϣ�����ݿ�
		 int dept = rukuMapper.insert(ruku);
		 if(dept==1) {
			//Ȼ�󱣴�������Ϣ�������
			 //���Ȼ�ȡ������Ʒ����,������Ʒ���Ʋ�ѯ��Ʒ����
			 String str = ruku.getShopName();
			 try {
				 list = kucunMapper.selectShuliang(str);
				 shuliangyuan = list.get(0);
				 shuliangxian = ruku.getRukuShuliang()+shuliangyuan;
			 }catch(NullPointerException e) {
				 shuliangyuan = 0;
				 shuliangxian = ruku.getRukuShuliang()+shuliangyuan;
			 }
			 KuCun kucun = new KuCun();
			 kucun.setShopName(str);
			 kucun.setShopShuliang(shuliangxian);
			 //������Ʒ�����޸���Ʒ����
			 int t = kucunMapper.updateShuliang(kucun);
			 
			 if(t==1) {
				 System.out.println("----------------------------�������ɹ�");
				
			 }else {
				 System.out.println("----------------------------�������ʧ��");
				 
			 }
		 }
		return 0;
	}

	@Override
	public List<RuKu> select() {
		// TODO Auto-generated method stub
		return rukuMapper.selectByExample(null);
	}

	@Override
	public List<RuKu> selectByKey(RuKu ruku) {
		// TODO Auto-generated method stub
		return rukuMapper.selectByKey(ruku);
	}

	@Override
	public int selectByIdKey(RuKu ruku) {
		// TODO Auto-generated method stub
		return rukuMapper.selectByIdKey(ruku);
	}	
}
