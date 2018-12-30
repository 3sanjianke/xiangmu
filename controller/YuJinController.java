package org.shop.controller;

import java.util.List;

import org.shop.pojo.YuJin;
import org.shop.service.YuJinService;
import org.shop.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/yujin")
public class YuJinController {

	@Autowired
	YuJinService yujinService;
	
	@RequestMapping("/main.do")
	public String main() {
		return "yujin/main";
	}
	
	@ResponseBody
	@RequestMapping("/insert.do")
	public Msg insert(YuJin yujin) {
		int deptId = yujinService.selectByIdKey(yujin);
		System.out.println("=====================================>:"+deptId);
		if(deptId!=0) {
			return Msg.idCFfile();
		}
		int dept = yujinService.insert(yujin);
		if(dept==1) {
			return Msg.success();
		}else {
			return Msg.file();
		}
	}
	
	@ResponseBody
	@RequestMapping("/selectAll.do")
	public Msg selectAll(int pn) {
		PageHelper.startPage(pn, 5);
		List<YuJin> list = yujinService.selectAll();
		PageInfo pageInfo = new PageInfo(list,5);
		return Msg.success().add("pageInfo", pageInfo);
	}
	
	@ResponseBody
	@RequestMapping("/selectOne.do")
	public Msg selectAll(YuJin yujin) {
		PageHelper.startPage(1, 5);
		List<YuJin> list = yujinService.selectOne(yujin);
		PageInfo pageInfo = new PageInfo(list,5);
		return Msg.success().add("pageInfo", pageInfo);
	}
	
	@ResponseBody
	@RequestMapping("/update.do")
	public Msg update(YuJin yujin) {
		System.out.println("------------------>:"+yujin);
		int dept = yujinService.update(yujin);
		if(dept==1) {
			return Msg.success();
		}else {
			return Msg.file();
		}
	}
	
	@ResponseBody
	@RequestMapping("/delete.do")
	public Msg delete(int yujinId) {
		int dept = yujinService.delete(yujinId);
		if(dept==1) {
			return Msg.success();
		}else {
			return Msg.file();
		}
	}
}
