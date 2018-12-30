package org.shop.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.shop.pojo.ChuKu;
import org.shop.pojo.KuCun;
import org.shop.service.ChuKuService;
import org.shop.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/chuku")
public class ChuKuController {

	@Autowired
	ChuKuService chukuService;
	
	@RequestMapping("/main.do")
	public String main() {
		return "/chuku/main";
	}
	
	//查出当前库存数量
	@ResponseBody
	@RequestMapping("/selectByName.do")
	public Msg selectByName(String shopName) {
		System.out.println("----------------------->:"+shopName);
		KuCun kucun = chukuService.selectByName(shopName);
		String fenlei = kucun.getShopFenlei();
		String shuliang = kucun.getShopShuliang()+"";
		System.out.println("----------------------->:"+fenlei+"||"+shuliang);
		Map<String,String> map = new HashMap<String,String>();
		map.put("fenlei", fenlei);
		map.put("shuliang", shuliang);
		return Msg.success().add("map", map);
	}
	
	@ResponseBody
	@RequestMapping("/insert.do")
	public Msg insert(ChuKu chuku) {
		System.out.println(chuku);
		
		int deptId = chukuService.selectByIdKey(chuku);
		if(deptId!=0) {
			return Msg.idCFfile();
		}
	     int i = chukuService.insert(chuku);
	     if(i==1) {
	    	 return Msg.success();
	     }else {
	    	 return Msg.file();
	     }
	}
	
	@ResponseBody
	@RequestMapping("/select.do")
	public Msg select(int pn) {
		
		PageHelper.startPage(pn, 5);
		List<ChuKu> list = chukuService.select();
		PageInfo pageInfo = new PageInfo(list,5);
		return Msg.success().add("pageInfo", pageInfo);
	}
	
	@ResponseBody
	@RequestMapping("/selectOne.do")
	public Msg selectOne(ChuKu chuku) {
		System.out.println("----------------->:"+chuku);
		PageHelper.startPage(1, 5);
		List<ChuKu> list = chukuService.selectOne(chuku);
		PageInfo pageInfo = new PageInfo(list,5);
		return Msg.success().add("pageInfo", pageInfo);
	}
}
