package org.shop.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;

import org.shop.service.KuCunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SystemController {

	@Autowired
	KuCunService kucunService;
	
	@Autowired
	ServletContext application;
	
	
	@PostConstruct
	public void init() {
		
		//把分类信息和商品信息当做系统参数
		
		List<String> listFenlei = kucunService.selectAllNames();	
		
		List<String> listShop = kucunService.selectAllNamess();
		
		application.setAttribute("listFenlei", listFenlei);
		
		application.setAttribute("listShop", listShop);
		
		System.out.println("====================================="+"系统参数加载完毕===============================");
	}
}
