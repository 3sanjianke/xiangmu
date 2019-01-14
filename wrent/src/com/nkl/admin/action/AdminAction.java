package com.nkl.admin.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nkl.admin.domain.Goods;
import com.nkl.admin.domain.GoodsType;
import com.nkl.admin.domain.Orders;
import com.nkl.admin.domain.User;
import com.nkl.admin.manager.AdminManager;
import com.nkl.common.util.DateUtil;
import com.nkl.common.util.PaperUtil;

@Controller
public class AdminAction {

	@Autowired
	AdminManager adminManager;
	public AdminManager getAdminManager() {
		return adminManager;
	}
	public void setAdminManager(AdminManager adminManager) {
		this.adminManager = adminManager;
	}

	String tip;

	/**
	 * @Title: saveAdmin
	 * @Description: 保存修改个人信息
	 * @return String
	 */
	@RequestMapping(value="admin/Admin_saveAdmin.action")
	public String saveAdmin(User paramsUser,
			ModelMap model,HttpServletRequest request,HttpServletResponse response,HttpSession httpSession){
		try {
			//验证用户会话是否失效
			if (!validateAdmin(httpSession)) {
				return "loginTip";
			}
			 //保存修改个人信息
			adminManager.updateUser(paramsUser);
			//更新session
			User admin = new User();
			admin.setUser_id(paramsUser.getUser_id());
			admin = adminManager.getUser(admin);
			httpSession.setAttribute("admin", admin);

			setSuccessTip("编辑成功", "modifyInfo.jsp", model);
		} catch (Exception e) {
			e.printStackTrace();
			setErrorTip("编辑异常", "modifyInfo.jsp", model);
		}
		return "infoTip";
	}
	
	/**
	 * @Title: saveAdminPass
	 * @Description: 保存修改个人密码
	 * @return String
	 */
	@RequestMapping(value="admin/Admin_saveAdminPass.action")
	public String saveAdminPass(User paramsUser,
			ModelMap model,HttpServletRequest request,HttpServletResponse response,HttpSession httpSession){
		try {
			//验证用户会话是否失效
			if (!validateAdmin(httpSession)) {
				return "loginTip";
			}
			 //保存修改个人密码
			adminManager.updateUser(paramsUser);
			//更新session
			User admin = (User)httpSession.getAttribute("admin");
			if (admin!=null) {
				admin.setUser_pass(paramsUser.getUser_pass());
				httpSession.setAttribute("admin", admin);
			}

			setSuccessTip("修改成功", "modifyPwd.jsp", model);
		} catch (Exception e) {
			setErrorTip("修改异常", "modifyPwd.jsp", model);
		}
		return "infoTip";
	}
	
	/**
	 * @Title: listUsers
	 * @Description: 查询注册用户
	 * @return String
	 */
	@RequestMapping(value="admin/Admin_listUsers.action")
	public String listUsers(User paramsUser,PaperUtil paperUtil,
			ModelMap model,HttpServletRequest request,HttpServletResponse response,HttpSession httpSession){
		try {
			if (paramsUser==null) {
				paramsUser = new User();
			}
			if (paperUtil==null) {
				paperUtil = new PaperUtil();
			}
			//设置分页信息
			paperUtil.setPagination(paramsUser);
			//总的条数
			int[] sum={0};
			//查询注册用户列表
			paramsUser.setUser_type(1);
			List<User> users = adminManager.listUsers(paramsUser,sum); 
			model.addAttribute("users", users);
			model.addAttribute("paramsUser", paramsUser);
			paperUtil.setTotalCount(sum[0]);

		} catch (Exception e) {
			setErrorTip("查询注册用户异常", "main.jsp", model);
			return "infoTip";
		}
		
		return "userShow";
	}
	
	/**
	 * @Title: addUserShow
	 * @Description: 显示添加注册用户页面
	 * @return String
	 */
	@RequestMapping(value="admin/Admin_addUserShow.action")
	public String addUserShow(ModelMap model){
		return "userEdit";
	}
	
	/**
	 * @Title: addUser
	 * @Description: 添加注册用户
	 * @return String
	 */
	@RequestMapping(value="admin/Admin_addUser.action")
	public String addUser(User paramsUser,
			ModelMap model,HttpServletRequest request,HttpServletResponse response,HttpSession httpSession){
		try {
			//检查注册用户是否存在
			User user = new User();
			user.setUser_name(paramsUser.getUser_name());
			user = adminManager.getUser(user);
			if (user!=null) {
				model.addAttribute("tip","失败，该用户名已经存在！");
				model.addAttribute("user", paramsUser);
				
				return "userEdit";
			}
			 //添加注册用户
			paramsUser.setUser_type(1);
			paramsUser.setReg_date(DateUtil.getCurDateTime());
			adminManager.addUser(paramsUser);
			
			setSuccessTip("添加成功", "Admin_listUsers.action", model);
		} catch (Exception e) {
			setErrorTip("添加注册用户异常", "Admin_listUsers.action", model);
		}
		
		return "infoTip";
	}
	
	 
	/**
	 * @Title: editUser
	 * @Description: 编辑注册用户
	 * @return String
	 */
	@RequestMapping(value="admin/Admin_editUser.action")
	public String editUser(User paramsUser,
			ModelMap model,HttpServletRequest request,HttpServletResponse response,HttpSession httpSession){
		try {
			 //得到注册用户
			User user = adminManager.getUser(paramsUser);
			model.addAttribute("user", user);
			
		} catch (Exception e) {
			setErrorTip("查询注册用户异常", "Admin_listUsers.action", model);
			return "infoTip";
		}
		
		return "userEdit";
	}
	
	/**
	 * @Title: saveUser
	 * @Description: 保存编辑注册用户
	 * @return String
	 */
	@RequestMapping(value="admin/Admin_saveUser.action")
	public String saveUser(User paramsUser,
			ModelMap model,HttpServletRequest request,HttpServletResponse response,HttpSession httpSession){
		try {
			 //保存编辑注册用户
			adminManager.updateUser(paramsUser);
			
			setSuccessTip("编辑成功", "Admin_listUsers.action", model);
		} catch (Exception e) {
			setErrorTip("编辑注册用户异常", "Admin_listUsers.action", model);
			return "infoTip";
		}
		
		return "infoTip";
	}
	
	/**
	 * @Title: delUsers
	 * @Description: 删除注册用户
	 * @return String
	 */
	@RequestMapping(value="admin/Admin_delUsers.action")
	public String delUsers(User paramsUser,
			ModelMap model,HttpServletRequest request,HttpServletResponse response,HttpSession httpSession){
		try {
			 //删除注册用户
			adminManager.delUsers(paramsUser);
			
			setSuccessTip("删除注册用户成功", "Admin_listUsers.action", model);
		} catch (Exception e) {
			setErrorTip("删除注册用户异常", "Admin_listUsers.action", model);
		}
		
		return "infoTip";
	}
	
	/**
	 * @Title: listGoodsTypes
	 * @Description: 查询婚庆用品类别
	 * @return String
	 */
	@RequestMapping(value="admin/Admin_listGoodsTypes.action")
	public String listGoodsTypes(GoodsType paramsGoodsType,PaperUtil paperUtil,
			ModelMap model,HttpServletRequest request,HttpServletResponse response,HttpSession httpSession){
		try {
			if (paramsGoodsType==null) {
				paramsGoodsType = new GoodsType();
			}
			
			//设置分页信息
			if (paperUtil==null) {
				paperUtil = new PaperUtil();
			}
			paperUtil.setPagination(paramsGoodsType);
			//总的条数
			int[] sum={0};
			//查询婚庆用品类别列表
			List<GoodsType> goodsTypes = adminManager.listGoodsTypes(paramsGoodsType,sum); 
			
			model.addAttribute("goodsTypes", goodsTypes);
			model.addAttribute("paramsGoodsType", paramsGoodsType);
			paperUtil.setTotalCount(sum[0]);
			
		} catch (Exception e) {
			setErrorTip("查询婚庆用品类别异常", "main.jsp", model);
			return "infoTip";
		}
		
		return "goodsTypeShow";
	}
	
	/**
	 * @Title: addGoodsTypeShow
	 * @Description: 显示添加婚庆用品类别页面
	 * @return String
	 */
	@RequestMapping(value="admin/Admin_addGoodsTypeShow.action")
	public String addGoodsTypeShow(ModelMap model){
		return "goodsTypeEdit";
	}
	
	/**
	 * @Title: addGoodsType
	 * @Description: 添加婚庆用品类别
	 * @return String
	 */
	@RequestMapping(value="admin/Admin_addGoodsType.action")
	public String addGoodsType(GoodsType paramsGoodsType,
			ModelMap model,HttpServletRequest request,HttpServletResponse response,HttpSession httpSession){
		try {
			//检查婚庆用品类别是否存在
			GoodsType goodsType = new GoodsType();
			goodsType.setGoods_type_name(paramsGoodsType.getGoods_type_name());
			goodsType = adminManager.queryGoodsType(goodsType);
			if (goodsType!=null) {
				tip="失败，该婚庆用品类别已经存在！";
				model.addAttribute("tip", tip);
				model.addAttribute("goodsType", paramsGoodsType);
				
				return "goodsTypeEdit";
			}
			
			 //添加婚庆用品类别
			adminManager.addGoodsType(paramsGoodsType);
			
			setSuccessTip("添加成功", "Admin_listGoodsTypes.action",model);
		} catch (Exception e) {
			setErrorTip("添加婚庆用品类别异常", "Admin_listGoodsTypes.action", model);
		}
		
		return "infoTip";
	}
	
	 
	/**
	 * @Title: editGoodsType
	 * @Description: 编辑婚庆用品类别
	 * @return String
	 */
	@RequestMapping(value="admin/Admin_editGoodsType.action")
	public String editGoodsType(GoodsType paramsGoodsType,
			ModelMap model,HttpServletRequest request,HttpServletResponse response,HttpSession httpSession){
		try {
			 //得到婚庆用品类别
			GoodsType goodsType = adminManager.queryGoodsType(paramsGoodsType);
			model.addAttribute("goodsType", goodsType);
			
		} catch (Exception e) {
			setErrorTip("查询婚庆用品类别异常", "Admin_listGoodsTypes.action", model);
			return "infoTip";
		}
		
		return "goodsTypeEdit";
	}
	
	/**
	 * @Title: saveGoodsType
	 * @Description: 保存编辑婚庆用品类别
	 * @return String
	 */
	@RequestMapping(value="admin/Admin_saveGoodsType.action")
	public String saveGoodsType(GoodsType paramsGoodsType,
			ModelMap model,HttpServletRequest request,HttpServletResponse response,HttpSession httpSession){
		try {
			//检查婚庆用品类别是否存在
			GoodsType goodsType = new GoodsType();
			goodsType.setGoods_type_name(paramsGoodsType.getGoods_type_name());
			goodsType = adminManager.queryGoodsType(goodsType);
			if (goodsType!=null && goodsType.getGoods_type_id()!=paramsGoodsType.getGoods_type_id()) {
				tip="失败，该婚庆用品类别已经存在！";
				model.addAttribute("goodsType", paramsGoodsType);
				
				return "goodsTypeEdit";
			}
			
			 //保存编辑婚庆用品类别
			adminManager.updateGoodsType(paramsGoodsType);
			
			setSuccessTip("编辑成功", "Admin_listGoodsTypes.action",model);
		} catch (Exception e) {
			e.printStackTrace();
			setErrorTip("编辑失败", "Admin_listGoodsTypes.action",model);
		}
		
		return "infoTip";
	}
	
	/**
	 * @Title: delGoodsTypes
	 * @Description: 删除婚庆用品类别
	 * @return String
	 */
	@RequestMapping(value="admin/Admin_delGoodsTypes.action")
	public String delGoodsTypes(GoodsType paramsGoodsType,
			ModelMap model,HttpServletRequest request,HttpServletResponse response,HttpSession httpSession){
		try {
			 //删除婚庆用品类别
			adminManager.delGoodsTypes(paramsGoodsType);
			
			setSuccessTip("删除婚庆用品类别成功", "Admin_listGoodsTypes.action",model);
		} catch (Exception e) {
			setErrorTip("删除婚庆用品类别异常", "Admin_listGoodsTypes.action", model);
		}
		
		return "infoTip";
	}
	
	/**
	 * @Title: listGoodss
	 * @Description: 查询婚庆用品
	 * @return String
	 */
	@RequestMapping(value="admin/Admin_listGoodss.action")
	public String listGoodss(Goods paramsGoods,PaperUtil paperUtil,
			ModelMap model,HttpServletRequest request,HttpServletResponse response,HttpSession httpSession){
		try {
			if (paramsGoods==null) {
				paramsGoods = new Goods();
			}
			//设置分页信息
			if (paperUtil==null) {
				paperUtil = new PaperUtil();
			}
			paperUtil.setPagination(paramsGoods);
			int[] sum={0};
			List<Goods> goodss = adminManager.listGoodss(paramsGoods,sum); 
			model.addAttribute("goodss", goodss);
			paperUtil.setTotalCount(sum[0]);
			model.addAttribute("paramsGoods", paramsGoods);
			
			//查询婚庆用品类别
			GoodsType goodsType1 = new GoodsType();
			goodsType1.setStart(-1);
			List<GoodsType> goodsTypes1 = adminManager.listGoodsTypes(goodsType1, null);
			model.addAttribute("goodsTypes", goodsTypes1);

		} catch (Exception e) {
			setErrorTip("查询婚庆用品异常", "main.jsp", model);
			return "infoTip";
		}
		
		return "goodsShow";
	}
	
	/**
	 * @Title: queryGoods
	 * @Description: 查看婚庆用品
	 * @return String
	 */
	@RequestMapping(value="admin/Admin_queryGoods.action")
	public String queryGoods(Goods paramsGoods,ModelMap model){
		try {
			 //得到婚庆用品
			Goods goods = adminManager.queryGoods(paramsGoods);
			model.addAttribute("goods", goods);
			
		} catch (Exception e) {
			e.printStackTrace();
			setErrorTip("查询婚庆用品异常", "Admin_listGoodss.action", model);
			return "infoTip";
		}
		
		return "goodsDetail";
	}
	
	/**
	 * @Title: addGoodsShow
	 * @Description: 显示添加婚庆用品页面
	 * @return String
	 */
	@RequestMapping(value="admin/Admin_addGoodsShow.action")
	public String addGoodsShow(Goods paramsGoods,ModelMap model){
		//查询婚庆用品类别
		GoodsType goodsType1 = new GoodsType();
		goodsType1.setStart(-1);
		List<GoodsType> goodsTypes1 = adminManager.listGoodsTypes(goodsType1, null);
		model.addAttribute("goodsTypes", goodsTypes1);
		
		return "goodsEdit";
	}
	
	/**
	 * @Title: addGoods
	 * @Description: 添加婚庆用品
	 * @return String
	 */
	@RequestMapping(value="admin/Admin_addGoods.action")
	public String addGoods(Goods paramsGoods,
			ModelMap model,HttpServletRequest request,HttpServletResponse response,HttpSession httpSession){
		try {
			 //添加婚庆用品
			adminManager.addGoods(paramsGoods);

			setSuccessTip("添加婚庆用品成功", "Admin_listGoodss.action", model);
		} catch (Exception e) {
			setErrorTip("添加婚庆用品异常", "Admin_listGoodss.action", model);
		}
		return "infoTip";
	}
	
	/**
	 * @Title: editGoods
	 * @Description: 编辑婚庆用品
	 * @return String
	 */
	@RequestMapping(value="admin/Admin_editGoods.action")
	public String editGoods(Goods paramsGoods,
			ModelMap model,HttpServletRequest request,HttpServletResponse response,HttpSession httpSession){
		try {
			 //得到婚庆用品
			Goods goods = adminManager.queryGoods(paramsGoods);
			model.addAttribute("goods", goods);
			
			//查询婚庆用品类别
			GoodsType goodsType1 = new GoodsType();
			goodsType1.setStart(-1);
			List<GoodsType> goodsTypes1 = adminManager.listGoodsTypes(goodsType1, null);
			model.addAttribute("goodsTypes", goodsTypes1);
		} catch (Exception e) {
			setErrorTip("查询婚庆用品异常", "Admin_listGoodss.action", model);
			return "infoTip";
		}
		
		return "goodsEdit";
	}
	
	/**
	 * @Title: saveGoods
	 * @Description: 保存编辑婚庆用品
	 * @return String
	 */
	@RequestMapping(value="admin/Admin_saveGoods.action")
	public String saveGoods(Goods paramsGoods,
			ModelMap model,HttpServletRequest request,HttpServletResponse response,HttpSession httpSession){
		try {
			 //保存编辑婚庆用品
			adminManager.updateGoods(paramsGoods);
			setSuccessTip("编辑婚庆用品成功", "Admin_listGoodss.action", model);
			
		} catch (Exception e) {
			e.printStackTrace();
			setErrorTip("编辑婚庆用品失败", "Admin_listGoodss.action", model);
		}
		return "infoTip";
	}
	
	/**
	 * @Title: delGoodss
	 * @Description: 删除婚庆用品
	 * @return String
	 */
	@RequestMapping(value="admin/Admin_delGoodss.action")
	public String delGoodss(Goods paramsGoods,
			ModelMap model,HttpServletRequest request,HttpServletResponse response,HttpSession httpSession){
		try {
			 //删除婚庆用品
			adminManager.delGoodss(paramsGoods);

			setSuccessTip("删除婚庆用品成功", "Admin_listGoodss.action", model);
		} catch (Exception e) {
			setErrorTip("删除婚庆用品异常", "Admin_listGoodss.action", model);
		}
		return "infoTip";
	}
	
	/**
	 * @Title: listOrderss
	 * @Description: 查询婚庆用品订单
	 * @return String
	 */
	@RequestMapping(value="admin/Admin_listOrderss.action")
	public String listOrderss(Orders paramsOrders,PaperUtil paperUtil,
			ModelMap model,HttpServletRequest request,HttpServletResponse response,HttpSession httpSession){
		try {
			if (paramsOrders==null) {
				paramsOrders = new Orders();
			}
			//设置分页信息
			if (paperUtil==null) {
				paperUtil = new PaperUtil();
			}
			paperUtil.setPagination(paramsOrders);
			//总的条数
			int[] sum={0};
			//查询婚庆用品订单列表
			List<Orders> orderss = adminManager.listOrderss(paramsOrders,sum); 
			
			model.addAttribute("orderss", orderss);
			paperUtil.setTotalCount(sum[0]);
			model.addAttribute("paramsOrders", paramsOrders);
			
		} catch (Exception e) {
			setErrorTip("查询婚庆用品订单异常", "main.jsp", model);
			return "infoTip";
		}
		
		return "ordersShow";
	}
	
	/**
	 * @Title: queryOrders
	 * @Description: 查看订单详情
	 * @return String
	 */
	@RequestMapping(value="admin/Admin_queryOrders.action")
	public String queryOrders(Orders paramsOrders,ModelMap model){
		try {
			 //得到婚庆用品
			Orders orders = adminManager.queryOrders(paramsOrders);
			model.addAttribute("orders", orders);
			
		} catch (Exception e) {
			e.printStackTrace();
			setErrorTip("查看订单详情异常", "Admin_listOrderss.action", model);
			return "infoTip";
		}
		
		return "ordersDetail";
	}
	
	/**
	 * @Title: listOrderssSum
	 * @Description: 租赁信息统计
	 * @return String
	 */
	@RequestMapping(value="admin/Admin_listOrderssSum.action")
	public String listOrderssSum(Orders paramsOrders,PaperUtil paperUtil,
			ModelMap model,HttpServletRequest request,HttpServletResponse response,HttpSession httpSession){
		try {
			if (paramsOrders==null) {
				paramsOrders = new Orders();
			}
			//设置分页信息
			if (paperUtil==null) {
				paperUtil = new PaperUtil();
			}
			paperUtil.setPagination(paramsOrders);
			//总的条数
			int[] sum={0};
			//查询婚庆用品订单列表
			List<Orders> orderss = adminManager.listOrderssSum(paramsOrders,sum); 
			
			model.addAttribute("orderss", orderss);
			paperUtil.setTotalCount(sum[0]);
			model.addAttribute("paramsOrders", paramsOrders);
			
			//查询婚庆用品类别
			GoodsType goodsType1 = new GoodsType();
			goodsType1.setStart(-1);
			List<GoodsType> goodsTypes1 = adminManager.listGoodsTypes(goodsType1, null);
			model.addAttribute("goodsTypes", goodsTypes1);
			
		} catch (Exception e) {
			setErrorTip("查询租赁信息统计异常", "main.jsp", model);
			return "infoTip";
		}
		
		return "ordersSumShow";
	}
	
	/**
	 * @Title: sendOrders
	 * @Description: 确认取货
	 * @return String
	 */
	@RequestMapping(value="admin/Admin_sendOrders.action")
	public String sendOrders(Orders paramsOrders,
			ModelMap model,HttpServletRequest request,HttpServletResponse response,HttpSession httpSession){
		try {
			 //确认出菜
			adminManager.sendOrders(paramsOrders);
			
			setSuccessTip("确认取货成功", "Admin_listOrderss.action", model);
		} catch (Exception e) {
			setErrorTip("确认取货异常", "Admin_listOrderss.action", model);
		}
		
		return "infoTip";
	}
	
	/**
	 * @Title: confirmOrders
	 * @Description: 确认归还
	 * @return String
	 */
	@RequestMapping(value="admin/Admin_confirmOrders.action")
	public String confirmOrders(Orders paramsOrders,
			ModelMap model,HttpServletRequest request,HttpServletResponse response,HttpSession httpSession){
		try {
			 //确认归还
			adminManager.confirmOrders(paramsOrders);
			
			setSuccessTip("确认归还成功", "Admin_listOrderss.action", model);
		} catch (Exception e) {
			setErrorTip("确认归还异常", "Admin_listOrderss.action", model);
		}
		
		return "infoTip";
	}
	
	/**
	 * @Title: delOrderss
	 * @Description: 删除婚庆用品订单
	 * @return String
	 */
	@RequestMapping(value="admin/Admin_delOrderss.action")
	public String delOrderss(Orders paramsOrders,
			ModelMap model,HttpServletRequest request,HttpServletResponse response,HttpSession httpSession){
		try {
			 //删除婚庆用品订单
			adminManager.delOrderss(paramsOrders);
			
			setSuccessTip("删除婚庆用品订单成功", "Admin_listOrderss.action", model);
		} catch (Exception e) {
			setErrorTip("删除婚庆用品订单异常", "Admin_listOrderss.action", model);
		}
		
		return "infoTip";
	}
	
	private boolean validateAdmin(HttpSession httpSession){
		User admin = (User)httpSession.getAttribute("admin");
		if (admin!=null) {
			return true;
		}else {
			return false;
		}
	}
	
	private void setErrorTip(String tip,String url,ModelMap model){
		model.addAttribute("tipType", "error");
		model.addAttribute("tip", tip);
		model.addAttribute("url1", url);
		model.addAttribute("value1", "确 定");
	}
	
	private void setSuccessTip(String tip,String url,ModelMap model){
		model.addAttribute("tipType", "success");
		model.addAttribute("tip", tip);
		model.addAttribute("url1", url);
		model.addAttribute("value1", "确 定");
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}


}
