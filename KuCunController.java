package org.shop.controller;

import java.util.List;

import org.shop.pojo.KuCun;
import org.shop.pojo.YuJin;
import org.shop.service.KuCunService;
import org.shop.service.YuJinService;
import org.shop.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
@RequestMapping("/kucun")
@Controller
public class KuCunController {

	@Autowired
	KuCunService kucunService;
	
	@Autowired
	YuJinService yujinService;
	
	@RequestMapping("/main.do")
	public String kucun() {
		return "kucun/main";
	}
	
	@ResponseBody
	@RequestMapping("/selectAll.do")
	public Msg selectAll(int pn) {
		List<YuJin> listYujin = yujinService.selectAll();
		PageHelper.startPage(pn, 5);
		List<KuCun> list = kucunService.selectAll();
		//System.out.println("---------------------->:"+list.size());
		PageInfo pageInfo = new PageInfo(list,5);
	//	List<YuJin> listYujin = yujinService.selectAll();
		return Msg.success().add("pageInfo", pageInfo).add("listYujin", listYujin);
	}
	
	@ResponseBody
	@RequestMapping("/selectOne.do")
	public Msg selectOne(KuCun kucun) {
		System.out.println("---------------------------->:"+kucun);
		PageHelper.startPage(1, 5);
		List<KuCun> list = kucunService.selectOne(kucun);
		PageInfo pageInfo = new PageInfo(list,5);
		return Msg.success().add("pageInfo", pageInfo);
	}
	
	@ResponseBody
	@RequestMapping("/insert.do")
	public Msg insert(KuCun kucun) {
		System.out.println("---------------------------->:"+kucun);
		int deptId = kucunService.selectByKey(kucun);
		if(deptId!=0) {
			return Msg.idCFfile();
		}
		int deptName = kucunService.selectByNameKey(kucun);
		if(deptName!=0) {
			return Msg.nameCFfile();
		}
		int dept = kucunService.insert(kucun);
		if(dept==1) {
			return Msg.success();
		}else {
			return Msg.file();
		}
	}
	
	@ResponseBody
	@RequestMapping("/update.do")
	public Msg update(KuCun kucun) {
		int dept = kucunService.update(kucun);
		if(dept==1) {
			return Msg.success();
		}else {
			return Msg.file();
		}
	}
	
	@ResponseBody
	@RequestMapping("/delete.do")
	public Msg delete(int kucunId) {
		int dept = kucunService.delete(kucunId);
		if(dept==1) {
			return Msg.success();
		}else {
			return Msg.file();
		}
	}
	
	/*@ResponseBody
	@RequestMapping("/ddd")
	public Msg ddd() {
		List<String> list = kucunService.selectAllNamess();
		return Msg.success().add("list", list);
	}*/
	
	@ResponseBody
	@RequestMapping("/selectFenlei.do")
	public Msg selectFenlei(String shopName) {
		List<String> list = kucunService.selectFenlei(shopName);
		return Msg.success().add("list", list);
	}
}
