package org.shop.service;

import java.util.List;

import org.shop.pojo.FenLei;
import org.shop.pojo.KuCun;

public interface KuCunService {

	public List<KuCun> selectAll();
	
	public List<KuCun> selectOne(KuCun kucun);
	
	public int update(KuCun kucun);
	
	public int delete(int kucunId);
	
	public int insert(KuCun kucun);
	
	public List<String> selectAllNames(); //������
	
	public List<String> selectAllNamess();  //��Ʒ��
	
	public List<String> selectFenlei(String shopName);//�������ֲ��ҷ���
	
	public List<Integer> selectShuliang(String shopName);//�������ֲ�������
	
	public int selectByKey(KuCun kucun);
	
	public int selectByNameKey(KuCun kucun);
}
