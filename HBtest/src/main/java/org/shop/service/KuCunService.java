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
	
	public List<String> selectAllNames(); //分类名
	
	public List<String> selectAllNamess();  //商品名
	
	public List<String> selectFenlei(String shopName);//根据名字查找分类
	
	public List<Integer> selectShuliang(String shopName);//根据名字查找数量
	
	public int selectByKey(KuCun kucun);
	
	public int selectByNameKey(KuCun kucun);
}
