package org.shop.controller;

import java.util.List;

import org.shop.pojo.FenLei;
import org.shop.service.FenLeiService;
import org.shop.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/fenlei")
public class FenLeiController {
	
	@Autowired
	FenLeiService fenLeiService;

	@RequestMapping("/top.do")
	public String top() {
		return "/fenlei/top";
	}
	
	@RequestMapping("/base.do")
	public String base() {
		return "/fenlei/base";
	}
	
	@RequestMapping("/seebase.do")
	public String seebase() {
		return "/fenlei/seebase";
	}
	
	@RequestMapping("/addbase.do")
	public String addbase() {
		return "/fenlei/addbase";
	}
	
	@ResponseBody
	@RequestMapping("/getFenleiXinXi.do")
	public Msg getFenleiXinXi(int pn) {
		//开启分页
		PageHelper.startPage(pn, 5);
		List<FenLei> list = fenLeiService.selectAll();
		PageInfo pageInfo = new PageInfo(list,5);
		return Msg.success().add("pageInfo", pageInfo);
	}
	
	@ResponseBody
	@RequestMapping("/select.do")
	public Msg getselect(FenLei fenlei) {
		System.out.println("---------------------------------->:"+fenlei);
		PageHelper.startPage(1, 5);
		List<FenLei> list = fenLeiService.selectOne(fenlei);
		System.out.println(list.size());
		PageInfo pageInfo = new PageInfo(list,5);
		if(list.size()!=0) {
			return Msg.success().add("pageInfo", pageInfo);
		}else {
			return Msg.file();
		}
	//	PageInfo pageInfo = new PageInfo(list,5);
	//	return Msg.success().add("pageInfo", pageInfo);
	}
	
	//添加数据
	@ResponseBody
	@RequestMapping("/insert.do")
	public Msg getinsert(FenLei fenlei) {
		System.out.println("---------------------------->:"+fenlei);
		//首先要查询数据库中是否已经有改编号的数据了
		int deptId = fenLeiService.selectByKey(fenlei);
	//	System.out.println("++++++++++++++++"+deptest);
		if(deptId!=0) {
			return Msg.idCFfile();
		}
		int deptName = fenLeiService.selectByNameKey(fenlei);
		if(deptName!=0) {
			return Msg.nameCFfile();
		}
		int dept = fenLeiService.insert(fenlei);
		if(dept==1) {
			return Msg.success();
		}else {
			return Msg.file();
		}
	}
	//修改数据
	@ResponseBody
	@RequestMapping("/update.do")
	public Msg getupdate(FenLei fenlei) {
		System.out.println("------------------------->:"+fenlei);
		int dept = fenLeiService.update(fenlei);
		if(dept==1) {
			return Msg.success();
		}else {
			return Msg.file();
		}
	}
	//删除数据
	@ResponseBody
	@RequestMapping("/delete.do")
	public Msg getdelete(int sortId) {
		System.out.println("-------------------------->:"+sortId);
		int dept = fenLeiService.delete(sortId);
		if(dept==1) {
			return Msg.success();
		}else {
			return Msg.file();
		}
	}
}
