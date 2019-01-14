package com.nkl.page.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nkl.admin.dao.IGoodsDao;
import com.nkl.admin.dao.IGoodsTypeDao;
import com.nkl.admin.dao.IOrdersDao;
import com.nkl.admin.dao.IUserDao;
import com.nkl.admin.domain.Goods;
import com.nkl.admin.domain.GoodsType;
import com.nkl.admin.domain.Orders;
import com.nkl.admin.domain.OrdersDetail;
import com.nkl.admin.domain.User;
import com.nkl.common.util.DateUtil;
import com.nkl.common.util.Md5;
import com.nkl.common.util.StringUtil;

@Service
public class IndexManager {

	@Autowired
	IUserDao userDao;
	@Autowired
	IGoodsTypeDao goodsTypeDao;
	@Autowired
	IGoodsDao goodsDao;
	@Autowired
	IOrdersDao ordersDao;
	
	/**
	 * @Title: getUser
	 * @Description: 用户查询
	 * @param user
	 * @return User
	 */
	public User  getUser(User user){
		User _user = userDao.getUser(user);
		
		return _user;
	}
	 
	/**
	 * @Title: updateUser
	 * @Description: 更新用户信息
	 * @param user
	 * @return void
	 */
	public void  updateUser(User user){
		if (!StringUtil.isEmptyString(user.getUser_pass())) {
			user.setUser_pass(Md5.makeMd5(user.getUser_pass()));
		}
		userDao.updateUser(user);
		
	}
	
	/**
	 * @Title: listGoodsTypes
	 * @Description: 商品类型查询
	 * @param goodsType
	 * @return List<GoodsType>
	 */
	public List<GoodsType> listGoodsTypes(GoodsType goodsType, int[] sum) {
		
		if (sum != null) {
			sum[0] = goodsTypeDao.listGoodsTypesCount(goodsType);
		}
		List<GoodsType> goodsTypes = goodsTypeDao.listGoodsTypes(goodsType);

		
		return goodsTypes;
	}
	
	public List<GoodsType> listGoodsTypes(GoodsType goodsType) {
		
		List<GoodsType> goodsTypes = goodsTypeDao.listGoodsTypes(goodsType);
		
		return goodsTypes;
	}
	
	/**
	 * @Title: queryGoodsType
	 * @Description: 商品类型查询
	 * @param goodsType
	 * @return GoodsType
	 */
	public GoodsType queryGoodsType(GoodsType goodsType) {
		
		GoodsType _goodsType = goodsTypeDao.getGoodsType(goodsType);
		
		return _goodsType;
	}
	
	/**
	 * @Title: listGoodss
	 * @Description: 查询商品信息
	 * @param goods
	 * @return List<Goods>
	 */
	public List<Goods>  listGoodss(Goods goods,int[] sum){
		ordersDao.updateOrdersFlag();
		if (sum!=null) {
			sum[0] = goodsDao.listGoodssCount(goods);
		}
		List<Goods> goodss = goodsDao.listGoodss(goods);
		
		return goodss;
	}
	
	public List<Goods>  listGoodssTop(Goods goods){
		
		List<Goods> goodss = goodsDao.listGoodssTop(goods);
		
		return goodss;
	}
	
	/**
	 * @Title: queryGoods
	 * @Description: 商品查询
	 * @param goods
	 * @return Goods
	 */
	public Goods queryGoods(Goods goods) {
		
		Goods _goods = goodsDao.getGoods(goods);
		
		return _goods;
	}
	
	/**
	 * @Title: listOrderssMap
	 * @Description: 商品订单统计
	 * @param orders
	 * @return List<Orders>
	 */
	public Map<Integer,Orders>  listOrderssMap(String orders_date_min,String orders_date_max){
		ordersDao.updateOrdersFlag();
		Map<Integer,Orders> ordersMap = new HashMap<Integer, Orders>();
		Orders orders = new Orders();
		orders.setOrders_date_min(orders_date_min);
		orders.setOrders_date_max(orders_date_max);
		orders.setOrders_flag(1);
		orders.setStart(-1);
		List<Orders> orderss = ordersDao.listOrderssSum(orders);
		if (orderss!=null) {
			for (Orders orders2 : orderss) {
				ordersMap.put(orders2.getGoods_id(), orders2);
			}
		}
		
		return ordersMap;
	}
	
	
	/**
	 * @Title: addCard
	 * @Description: 添加购物车
	 * @param ordersDetail
	 */
	@SuppressWarnings("unchecked")
	public String addCard(OrdersDetail ordersDetail,HttpSession httpSession) {
		String tip = null;
		//判断商品数量
		Goods goods = new Goods();
		goods.setGoods_id(ordersDetail.getGoods_id());
		goods = goodsDao.getGoods(goods);
		Map<Integer,Orders> ordersMap = listOrderssMap(ordersDetail.getOrders_date1(), ordersDetail.getOrders_date2());
		if (ordersMap.containsKey(goods.getGoods_id())) {
			goods.setGoods_count(Math.max(goods.getGoods_count() - ordersMap.get(goods.getGoods_id()).getGoods_count(), 0));
		}
		if (ordersDetail.getGoods_count() > goods.getGoods_count()) {
			return "租赁时间段内，商品库存只有"+goods.getGoods_count();
		}
		
		//查询购物车
		List<OrdersDetail> card = (List<OrdersDetail>) httpSession.getAttribute("card");
		if (card==null) {
			card = new ArrayList<OrdersDetail>();
		}
		OrdersDetail oldDetail = getGoodsFromCard(ordersDetail.getGoods_id(),httpSession);
		if (oldDetail==null) {//新增商品
			//计算总额
			int days = DateUtil.getDaysBetween(DateUtil.getDate(ordersDetail.getOrders_date1()), DateUtil.getDate(ordersDetail.getOrders_date2())) + 1;
			double goods_money = ordersDetail.getGoods_price() * days * ordersDetail.getGoods_count();
			ordersDetail.setGoods_money(goods_money);
			card.add(ordersDetail);
		}else {//修改购物车商品
			card.remove(oldDetail);
			oldDetail.setGoods_count(oldDetail.getGoods_count()+ordersDetail.getGoods_count());
			//计算总额
			int days = DateUtil.getDaysBetween(DateUtil.getDate(oldDetail.getOrders_date1()), DateUtil.getDate(oldDetail.getOrders_date2())) + 1;
			double goods_money = oldDetail.getGoods_price() * days * oldDetail.getGoods_count();
			oldDetail.setGoods_money(goods_money);
			card.add(oldDetail);
		}
		httpSession.setAttribute("card", card);
		
		return tip;
	}
	
	/**
	 * @Title: modifyCard
	 * @Description: 修改购物车商品
	 * @param ordersDetail
	 */
	@SuppressWarnings("unchecked")
	public void modifyCard(OrdersDetail ordersDetail,HttpSession httpSession) {
		//查询购物车
		List<OrdersDetail> card = (List<OrdersDetail>) httpSession.getAttribute("card");
		OrdersDetail oldDetail = getGoodsFromCard(ordersDetail.getGoods_id(),httpSession);
		
		//修改购物车商品
		card.remove(oldDetail);
		oldDetail.setGoods_count(ordersDetail.getGoods_count());
		//计算总额
		int days = DateUtil.getDaysBetween(DateUtil.getDate(oldDetail.getOrders_date1()), DateUtil.getDate(oldDetail.getOrders_date2())) + 1;
		double goods_money = oldDetail.getGoods_price() * days * oldDetail.getGoods_count();
		oldDetail.setGoods_money(goods_money);
		card.add(oldDetail);
		httpSession.setAttribute("card", card);
		
	}
	
	/**
	 * @Title: delGoodsFromCard
	 * @Description: 从购物车删除商品
	 * @param goods_id
	 */
	@SuppressWarnings("unchecked")
	public void delGoodsFromCard(int goods_id,HttpSession httpSession) {
		//查询购物车
		List<OrdersDetail> card = (List<OrdersDetail>) httpSession.getAttribute("card");
		if (card!=null) {
			for (OrdersDetail ordersDetail : card) {
				if (ordersDetail.getGoods_id()==goods_id) {
					card.remove(ordersDetail);
					break;
				}
			}
		}
		httpSession.setAttribute("card", card);
		
	}
	
	/**
	 * @Title: clearCard
	 * @Description: 清空购物车
	 */
	public void clearCard(HttpSession httpSession) {
		//清空购物车
		httpSession.removeAttribute("card");
		
	}
	
	@SuppressWarnings("unchecked")
	private OrdersDetail getGoodsFromCard(int goods_id,HttpSession httpSession) {
		//查询购物车
		List<OrdersDetail> card = (List<OrdersDetail>) httpSession.getAttribute("card");
		if (card!=null) {
			for (OrdersDetail ordersDetail : card) {
				if (ordersDetail.getGoods_id()==goods_id) {
					return ordersDetail;
				}
			}
		}else {
			return null;
		}
		return null;
	}
	
	/**
	 * @Title: addOrders
	 * @Description: 添加商品订单
	 * @param orders
	 * @return Orders
	 */
	@SuppressWarnings("unchecked")
	public String addOrders(Orders orders,HttpSession httpSession) {
		ordersDao.updateOrdersFlag();
		//查询购物车
		List<OrdersDetail> card = (List<OrdersDetail>) httpSession.getAttribute("card");
		String tip = null;
		for (int i = 0; i < card.size(); i++) {
			//判断商品数量
			OrdersDetail ordersDetail = card.get(i);
			Goods goods = new Goods();
			goods.setGoods_id(ordersDetail.getGoods_id());
			goods = goodsDao.getGoods(goods);
			Map<Integer,Orders> ordersMap = listOrderssMap(ordersDetail.getOrders_date1(), ordersDetail.getOrders_date2());
			if (ordersMap.containsKey(goods.getGoods_id())) {
				goods.setGoods_count(Math.max(goods.getGoods_count() - ordersMap.get(goods.getGoods_id()).getGoods_count(), 0));
			}
			if (ordersDetail.getGoods_count() > goods.getGoods_count()) {
				return "租赁时间段内，商品："+ordersDetail.getGoods_name()+" 库存只有"+goods.getGoods_count();
			}
		}
		
		//生成订单号
		String orders_no = DateUtil.dateToDateString(new Date(), "yyyyMMddHHmmss")+orders.getUser_id();
		//orders.setOrders_no(orders_no);
		//订单日期
		orders.setOrders_date(DateUtil.dateToDateString(new Date(), "yyyy-MM-dd"));
		//1：已租赁
		orders.setOrders_flag(1);
		for (int i = 0; i < card.size(); i++) {
			OrdersDetail ordersDetail = card.get(i);
			orders.setOrders_no(orders_no+ordersDetail.getGoods_id());//设置订单号
			orders.setGoods_id(ordersDetail.getGoods_id());
			orders.setGoods_name(ordersDetail.getGoods_name());
			orders.setGoods_count(ordersDetail.getGoods_count());
			orders.setGoods_price(ordersDetail.getGoods_price());
			orders.setGoods_yj(ordersDetail.getGoods_yj());
			orders.setGoods_price2(ordersDetail.getGoods_price2());
			orders.setOrders_date1(ordersDetail.getOrders_date1());
			orders.setOrders_date2(ordersDetail.getOrders_date2());
			orders.setGoods_money(ordersDetail.getGoods_money());
			//保存订单明细
			ordersDao.addOrders(orders);
		}
		
		//清空购物车
		httpSession.removeAttribute("card");
		return tip;
		
	}

	/**
	 * @Title: listCard
	 * @Description: 查询购物车
	 * @return List<OrdersDetail>
	 */
	@SuppressWarnings("unchecked")
	public List<OrdersDetail> listCard(HttpSession httpSession) {
		//查询购物车
		List<OrdersDetail> card = (List<OrdersDetail>) httpSession.getAttribute("card");
		if (card==null) {
			card = new ArrayList<OrdersDetail>();
		}
		return card;
	}
	
	/**
	 * @Title: listOrderss
	 * @Description: 商品订单查询
	 * @param orders
	 * @return List<Orders>
	 */
	public List<Orders>  listOrderss(Orders orders,int[] sum){
		ordersDao.updateOrdersFlag();
		if (sum!=null) {
			sum[0] = ordersDao.listOrderssCount(orders);
		}
		List<Orders> orderss = ordersDao.listOrderss(orders);
		
		
		return orderss;
	}
	
	/**
	 * @Title: queryOrders
	 * @Description: 商品订单查询
	 * @param orders
	 * @return Orders
	 */
	public Orders  queryOrders(Orders orders){
		
		Orders _orders = ordersDao.getOrders(orders);
		
		return _orders;
	}
	 
	
	/**
	 * @Title: cancelOrders
	 * @Description: 取消订单
	 * @param Orders
	 * @return void
	 */
	public void cancelOrders(Orders orders) {
		
		ordersDao.delOrders(orders.getIds());
		
		
	}
	
	/**
	 * @Title: finishOrders
	 * @Description: 用户归还
	 * @param Orders
	 * @return void
	 */
	public void finishOrders(Orders orders) {
		//用户归还
		orders = ordersDao.getOrders(orders);
		//计算归还日期
		orders.setOrders_date3(DateUtil.getCurDate());
		if (orders.getOrders_date3().compareTo(orders.getOrders_date2()) > 0) {
			int days = DateUtil.getDaysBetween(DateUtil.getDate(orders.getOrders_date2()), DateUtil.getDate(orders.getOrders_date3())) + 1;
			double goods_money2 = orders.getGoods_price2() * days;
			orders.setGoods_money2(goods_money2);
		}
		orders.setOrders_flag(3);
		ordersDao.updateOrders(orders);
		
		
	}
	
	public IUserDao getUserDao() {
		return userDao;
	}

	public IGoodsTypeDao getGoodsTypeDao() {
		return goodsTypeDao;
	}

	public IGoodsDao getGoodsDao() {
		return goodsDao;
	}

	public IOrdersDao getOrdersDao() {
		return ordersDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	public void setGoodsTypeDao(IGoodsTypeDao goodsTypeDao) {
		this.goodsTypeDao = goodsTypeDao;
	}

	public void setGoodsDao(IGoodsDao goodsDao) {
		this.goodsDao = goodsDao;
	}

	public void setOrdersDao(IOrdersDao ordersDao) {
		this.ordersDao = ordersDao;
	}
  
}
