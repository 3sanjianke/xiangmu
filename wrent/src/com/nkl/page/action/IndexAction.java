package com.nkl.page.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nkl.admin.domain.Goods;
import com.nkl.admin.domain.GoodsType;
import com.nkl.admin.domain.Orders;
import com.nkl.admin.domain.OrdersDetail;
import com.nkl.admin.domain.User;
import com.nkl.common.util.JSONData;
import com.nkl.common.util.PaperUtil;
import com.nkl.page.manager.IndexManager;

@Controller
public class IndexAction {

	@Autowired
	IndexManager indexManager;
	String tip;
	
	public IndexManager getIndexManager() {
		return indexManager;
	}

	public void setIndexManager(IndexManager indexManager) {
		this.indexManager = indexManager;
	}

	/**
	 * @Title: index
	 * @Description: 展示首页信息
	 * @return String
	 */
	@RequestMapping(value="page_index.action",method=RequestMethod.GET)
	public String index(ModelMap model){
		try {
			//查询最新商品信息
			Goods goods = new Goods();
			goods.setStart(0);
			goods.setLimit(8);
			List<Goods> goodss1 = indexManager.listGoodss(goods,null);
			model.addAttribute("goodss1", goodss1);
			
			//查询热销商品信息
			List<Goods> goodss2 = indexManager.listGoodssTop(goods);
			model.addAttribute("goodss2", goodss2);
			
			//查询商品分类
			GoodsType goodsType = new GoodsType();
			goodsType.setStart(-1);
			List<GoodsType> goodsTypes1 = indexManager.listGoodsTypes(goodsType, null);
			model.addAttribute("goodsTypes", goodsTypes1);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
		return "default";
	}
	
	/**
	 * @Title: listGoodss
	 * @Description: 展示商品列表
	 * @return String
	 */
	@RequestMapping(value="page_listGoodss.action")
	public String listGoodss(Goods paramsGoods,PaperUtil paperUtil,
			ModelMap model,HttpServletRequest request,HttpServletResponse response,HttpSession httpSession){
		try {
			//查询商品信息集合
			if (paramsGoods==null) {
				paramsGoods = new Goods();
			}
			//分页信息设置
			paperUtil.setPagination(paramsGoods);
			int[] sum = {0};
			List<Goods> goodss = indexManager.listGoodss(paramsGoods,sum); 
			model.addAttribute("goodss", goodss);
			paperUtil.setTotalCount(sum[0]);
			model.addAttribute("paramsGoods", paramsGoods);
			
			
			//查询菜品类别
			GoodsType _goodsType1 = new GoodsType();
			_goodsType1.setStart(-1);
			List<GoodsType> goodsTypes1 = indexManager.listGoodsTypes(_goodsType1, null);
			if (goodsTypes1==null) {
				goodsTypes1 = new ArrayList<GoodsType>();
			}
			model.addAttribute("goodsTypes", goodsTypes1);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
		return "goods";
	}
	
	/**
	 * @Title: queryGoods
	 * @Description: 查询商品详情
	 * @return String
	 */
	@RequestMapping(value="page_queryGoods.action",method=RequestMethod.GET)
	public String queryGoods(Goods paramsGoods,
			ModelMap model,HttpServletRequest request,HttpServletResponse response,HttpSession httpSession){
		try {
			 //得到商品
			Goods goods = indexManager.queryGoods(paramsGoods);
			model.addAttribute("goods", goods);
			
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
		return "goodsDetail";
	}
	
	/**
	 * @Title: listCard
	 * @Description: 查询购物车
	 * @return String
	 */
	@RequestMapping(value="page_listCard.action")
	public String listCard(PaperUtil paperUtil,
			ModelMap model,HttpServletRequest request,HttpServletResponse response,HttpSession httpSession){
		try {
			//查询购物车
			List<OrdersDetail> ordersDetails = indexManager.listCard(httpSession);
			model.addAttribute("ordersDetails", ordersDetails);
			
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
		return "card";
	}
	
	/**
	 * @Title: addCard
	 * @Description: 添加到购物车
	 * @return String
	 */
	@RequestMapping(value="page_addCard.action")
	@ResponseBody
	public JSONData addCard(OrdersDetail paramsOrdersDetail,PaperUtil paperUtil,
			ModelMap model,HttpServletRequest request,HttpServletResponse response,HttpSession httpSession){
		JSONData jsonData = new JSONData();
		try {
			//添加到购物车
			String tip = indexManager.addCard(paramsOrdersDetail, httpSession);
			if(tip!=null){
				jsonData.setErrorReason(tip);
				return jsonData;
			}
			//查询购物车
			List<OrdersDetail> ordersDetails = indexManager.listCard(httpSession);
			model.addAttribute("ordersDetails", ordersDetails);
			
		} catch (Exception e) {
			e.printStackTrace();
			jsonData.setErrorReason("添加购物车失败！");
			return jsonData;
		}
		
		return jsonData;
	}
	
	/**
	 * @Title: modifyCard
	 * @Description: 修改购物车
	 * @return String
	 */
	@RequestMapping(value="page_modifyCard.action")
	@ResponseBody
	public JSONData modifyCard(OrdersDetail paramsOrdersDetail,PaperUtil paperUtil,
			ModelMap model,HttpServletRequest request,HttpServletResponse response,HttpSession httpSession){
		JSONData jsonData = new JSONData();
		try {
			//修改购物车
			indexManager.modifyCard(paramsOrdersDetail, httpSession);
			
		} catch (Exception e) {
			e.printStackTrace();
			jsonData.setErrorReason("修改数量失败！");
			return jsonData;
		}
		
		return jsonData;
	}
	
	/**
	 * @Title: delGoodsFromCard
	 * @Description: 从购物车删除
	 * @return String
	 */
	@RequestMapping(value="page_delGoodsFromCard.action")
	public String delGoodsFromCard(OrdersDetail paramsOrdersDetail,PaperUtil paperUtil,
			ModelMap model,HttpServletRequest request,HttpServletResponse response,HttpSession httpSession){
		try {
			//从购物车删除
			indexManager.delGoodsFromCard(paramsOrdersDetail.getGoods_id(), httpSession);
			
			//查询购物车
			List<OrdersDetail> ordersDetails = indexManager.listCard(httpSession);
			model.addAttribute("ordersDetails", ordersDetails);
			
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
		return "card";
	}
	
	/**
	 * @Title: clearCard
	 * @Description: 清空购物车
	 * @return String
	 */
	@RequestMapping(value="page_clearCard.action")
	public String clearCard(OrdersDetail paramsOrdersDetail,PaperUtil paperUtil,
			ModelMap model,HttpServletRequest request,HttpServletResponse response,HttpSession httpSession){
		try {
			//清空购物车
			indexManager.clearCard(httpSession);
			//查询购物车
			model.addAttribute("ordersDetails", null);
			
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
		return "card";
	}
	
	/**
	 * @Title: addOrdersShow
	 * @Description: 新增订单页面
	 * @return String
	 */
	@RequestMapping(value="page_addOrdersShow.action")
	public String addOrdersShow(OrdersDetail paramsOrdersDetail,PaperUtil paperUtil,
			ModelMap model,HttpServletRequest request,HttpServletResponse response,HttpSession httpSession){
		try {
			//查询购物车
			List<OrdersDetail> ordersDetails = indexManager.listCard(httpSession);
			model.addAttribute("ordersDetails", ordersDetails);
			
			//查询订单总额
			double orders_money=0;
			for (int i = 0; i < ordersDetails.size(); i++) {
				OrdersDetail ordersDetail = ordersDetails.get(i);
				orders_money+=ordersDetail.getGoods_money();//累计总金额
			}
			model.addAttribute("orders_money", Math.round(orders_money*10)/10.0);
			
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
		return "ordersAdd";
	}
	
	/**
	 * @Title: addOrders
	 * @Description: 新增订单
	 * @return String
	 */
	@RequestMapping(value="page_addOrders.action")
	@ResponseBody
	public JSONData addOrders(Orders paramsOrders,PaperUtil paperUtil,
			ModelMap model,HttpServletRequest request,HttpServletResponse response,HttpSession httpSession){
		JSONData jsonData = new JSONData();
		try {
			//新增订单
			String tip = indexManager.addOrders(paramsOrders,httpSession);
			if(tip!=null){
				jsonData.setErrorReason(tip);
				return jsonData;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			jsonData.setErrorReason("提交订单失败");
			return jsonData;
		}
		
		return jsonData;
	}
	
	 
	/**
	 * @Title: saveAdmin
	 * @Description: 保存修改个人信息
	 * @return String
	 */
	@RequestMapping(value="page_saveUserFront.action",method=RequestMethod.POST)
	@ResponseBody
	public JSONData saveUserFront(User paramsUser,
			ModelMap model,HttpServletRequest request,HttpServletResponse response,HttpSession httpSession){
		JSONData jsonData = new JSONData();
		try {
			 //保存修改个人信息
			indexManager.updateUser(paramsUser);
			//更新session
			User admin = new User();
			admin.setUser_id(paramsUser.getUser_id());
			admin = indexManager.getUser(admin);
			httpSession.setAttribute("userFront", admin);
		} catch (Exception e) {
			e.printStackTrace();
			jsonData.setErrorReason("后台服务器异常");
			return jsonData;
		}
		return jsonData;
	}
	
	/**
	 * @Title: saveUserFrontPass
	 * @Description: 保存修改个人密码
	 * @return String
	 */
	@RequestMapping(value="page_saveUserFrontPass.action",method=RequestMethod.POST)
	@ResponseBody
	public JSONData saveUserFrontPass(User paramsUser,
			ModelMap model,HttpServletRequest request,HttpServletResponse response,HttpSession httpSession){
		JSONData jsonData = new JSONData();
		try {
			 //保存修改个人信息
			indexManager.updateUser(paramsUser);
			//更新session
			User userFront = (User)httpSession.getAttribute("userFront");
			if (userFront!=null) {
				userFront.setUser_pass(paramsUser.getUser_pass());
				httpSession.setAttribute("userFront", userFront);
			}
		} catch (Exception e) {
			e.printStackTrace();
			jsonData.setErrorReason("后台服务器异常");
			return jsonData;
		}
		return jsonData;
	}
	
	/**
	 * @Title: listMyOrderss
	 * @Description: 查询我的商品订单
	 * @return String
	 */
	@RequestMapping(value="page_listMyOrderss.action")
	public String listMyOrderss(Orders paramsOrders,PaperUtil paperUtil,
			ModelMap model,HttpServletRequest request,HttpServletResponse response,HttpSession httpSession){
		try {
			if (paramsOrders==null) {
				paramsOrders = new Orders();
			}
			//获取用户,用户只能查询自己的订单
			User userFront = (User)httpSession.getAttribute("userFront");
			paramsOrders.setUser_id(userFront.getUser_id());
			//设置分页信息
			paperUtil.setPagination(paramsOrders);
			//总的条数
			int[] sum={0};
			//查询商品预约列表
			List<Orders> orderss = indexManager.listOrderss(paramsOrders,sum); 
			
			model.addAttribute("orderss", orderss);
			paperUtil.setTotalCount(sum[0]);
			
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
		return "ordersShow";
	}
	
	/**
	 * @Title: queryMyOrders
	 * @Description: 查询我的商品订单
	 * @return String
	 */
	@RequestMapping(value="page_queryMyOrders.action")
	public String queryMyOrders(Orders paramsOrders,
			ModelMap model,HttpServletRequest request,HttpServletResponse response,HttpSession httpSession){
		try {
			Orders orders = indexManager.queryOrders(paramsOrders);
			model.addAttribute("orders", orders);
			
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
		return "ordersDetail";
	}
	
	/**
	 * @Title: finishOrders
	 * @Description: 用户归还
	 * @return String
	 */
	@RequestMapping(value="page_finishOrders.action")
	@ResponseBody
	public JSONData finishOrders(Orders paramsOrders,PaperUtil paperUtil,
			ModelMap model,HttpServletRequest request,HttpServletResponse response,HttpSession httpSession){
		JSONData jsonData = new JSONData();
		try {
			//用户归还
			indexManager.finishOrders(paramsOrders);
			
		} catch (Exception e) {
			e.printStackTrace();
			jsonData.setErrorReason("用户归还失败！");
			return jsonData;
		}
		
		return jsonData;
	}
	
	
	/**
	 * @Title: reg
	 * @Description: 跳转注册页面
	 * @return String
	 */
	@RequestMapping(value="page_reg.action")
	public String reg(){
		return "reg";
	}
	
	/**
	 * @Title: myInfo
	 * @Description: 跳转个人信息页面
	 * @return String
	 */
	@RequestMapping(value="page_myInfo.action")
	public String myInfo(){
		return "myInfo";
	}
	
	/**
	 * @Title: myPwd
	 * @Description: 跳转个人密码页面
	 * @return String
	 */
	@RequestMapping(value="page_myPwd.action")
	public String myPwd(){
		return "myPwd";
	}
	
	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

}
