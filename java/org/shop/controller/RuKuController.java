package org.shop.controller;

import java.util.List;

import org.shop.pojo.RuKu;
import org.shop.service.RuKuService;
import org.shop.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/ruku")
public class RuKuController {

	@Autowired
	RuKuService rukuService;
	
	@RequestMapping("/main.do")
	public String main() {
		return "ruku/main";
	}
	
	@ResponseBody
	@RequestMapping("/insert.do")
	public Msg insert(RuKu ruku) {
		
		int deptId = rukuService.selectByIdKey(ruku);
		if(deptId!=0) {
			return Msg.idCFfile();
		}
		int dept = rukuService.insert(ruku);
		if(dept==1) {
			return Msg.success();
		}else {
			return Msg.file();
		}
	}
	
	@ResponseBody
	@RequestMapping("/select.do")
	public Msg select(int pn) {
		PageHelper.startPage(pn, 5);
		List<RuKu> list = rukuService.select();
		PageInfo pageInfo = new PageInfo(list,5);
		return Msg.success().add("pageInfo",pageInfo);
	}
	
	@ResponseBody
	@RequestMapping("/selectByKey.do")
	public Msg selectByKey(RuKu ruku) {
		System.out.println("--------------------->:"+ruku);
		PageHelper.startPage(1, 5);
		List<RuKu> list = rukuService.selectByKey(ruku);
		PageInfo pageInfo = new PageInfo(list,5);
		return Msg.success().add("pageInfo", pageInfo);
	}
}
