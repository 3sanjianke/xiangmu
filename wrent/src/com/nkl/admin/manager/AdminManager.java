package com.nkl.admin.manager;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nkl.admin.dao.IGoodsDao;
import com.nkl.admin.dao.IGoodsTypeDao;
import com.nkl.admin.dao.IOrdersDao;
import com.nkl.admin.dao.IUserDao;
import com.nkl.admin.domain.Goods;
import com.nkl.admin.domain.GoodsType;
import com.nkl.admin.domain.Orders;
import com.nkl.admin.domain.User;
import com.nkl.common.util.DateUtil;
import com.nkl.common.util.Md5;
import com.nkl.common.util.StringUtil;
import com.nkl.common.util.Transcode;

@Service
public class AdminManager {
	@Autowired
	IUserDao userDao;
	@Autowired
	IGoodsTypeDao goodsTypeDao;
	@Autowired
	IGoodsDao goodsDao;
	@Autowired
	IOrdersDao ordersDao;
	
	/**
	 * @Title: listUsers
	 * @Description: 用户查询
	 * @param user
	 * @return List<User>
	 */
	public List<User>  listUsers(User user,int[] sum){
		if (sum!=null) {
			sum[0] = userDao.listUsersCount(user);
		}
		List<User> users = userDao.listUsers(user);
		
		return users;
	}
	
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
	 * @Title: addUser
	 * @Description: 添加用户
	 * @param user
	 * @return void
	 */
	public void  addUser(User user){
		if (!StringUtil.isEmptyString(user.getUser_pass())) {
			user.setUser_pass(Md5.makeMd5(user.getUser_pass()));
		}
		//默认头像
		if (StringUtil.isEmptyString(user.getUser_photo())) {
			user.setUser_photo("default.jpg");
		}
		user.setReg_date(DateUtil.dateToDateString(new Date(), "yyyy-MM-dd HH:mm:ss"));
		userDao.addUser(user);
		
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
	 * @Title: delUsers
	 * @Description: 删除用户信息
	 * @param user
	 * @return void
	 */
	public void  delUsers(User user){
		
		userDao.delUsers(user.getIds().split(","));
		
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
	 * @Title: addGoodsType
	 * @Description: 添加商品类型
	 * @param goodsType
	 * @return void
	 */
	public void addGoodsType(GoodsType goodsType) {
		
		goodsTypeDao.addGoodsType(goodsType);
		
	}

	/**
	 * @Title: updateGoodsType
	 * @Description: 更新商品类型信息
	 * @param goodsType
	 * @return void
	 */
	public void updateGoodsType(GoodsType goodsType) {
		
		goodsTypeDao.updateGoodsType(goodsType);
		
	}

	/**
	 * @Title: delGoodsType
	 * @Description: 删除商品类型信息
	 * @param goodsType
	 * @return void
	 */
	public void delGoodsTypes(GoodsType goodsType) {
		
		goodsTypeDao.delGoodsTypes(goodsType.getIds().split(","));
		
	}
	
	/**
	 * @Title: listGoodss
	 * @Description: 商品查询
	 * @param goods
	 * @return List<Goods>
	 */
	public List<Goods> listGoodss(Goods goods, int[] sum) {
		ordersDao.updateOrdersFlag();
		if (sum != null) {
			sum[0] = goodsDao.listGoodssCount(goods);
		}
		List<Goods> goodss = goodsDao.listGoodss(goods);

		
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
	 * @Title: addGoods
	 * @Description: 添加商品
	 * @param goods
	 * @return void
	 */
	public void addGoods(Goods goods) {
		if (!StringUtil.isEmptyString(goods.getGoods_desc())) {
			goods.setGoods_desc(Transcode.htmlEncode(goods.getGoods_desc()));
		}
		goods.setGoods_date(DateUtil.getCurDateTime());
		goodsDao.addGoods(goods);
		
	}

	/**
	 * @Title: updateGoods
	 * @Description: 更新商品信息
	 * @param goods
	 * @return void
	 */
	public void updateGoods(Goods goods) {
		if (!StringUtil.isEmptyString(goods.getGoods_desc())) {
			goods.setGoods_desc(Transcode.htmlEncode(goods.getGoods_desc()));
		}
		goodsDao.updateGoods(goods);
		
	}

	/**
	 * @Title: delGoods
	 * @Description: 删除商品信息
	 * @param goods
	 * @return void
	 */
	public void delGoodss(Goods goods) {
		
		goodsDao.delGoodss(goods.getIds().split(","));
		
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
	
	public List<Orders>  listOrderssSum(Orders orders,int[] sum){
		
		if (sum!=null) {
			sum[0] = ordersDao.listOrderssSumCount(orders);
		}
		List<Orders> orderss = ordersDao.listOrderssSum(orders);
		
		
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
	 * @Title: delOrderss
	 * @Description: 删除商品订单信息
	 * @param orders
	 * @return void
	 */
	public void  delOrderss(Orders orders){
		
		ordersDao.delOrderss(orders.getIds().split(","));
		
	}
	
	/**
	 * @Title: sendOrders
	 * @Description: 订单取货
	 * @param orders
	 * @return void
	 */
	public String sendOrders(Orders orders) {
		String tip = null;
		Orders _orders = ordersDao.getOrders(orders);
		
		//更新库存
		Goods goods = new Goods();
		goods.setGoods_id(_orders.getGoods_id());
		goods = goodsDao.getGoods(goods);
		if (goods.getGoods_count() < _orders.getGoods_count()) {
			tip = "商品库存数量不足，无法取货！";
			return tip;
		}else{
			goods.setGoods_count(goods.getGoods_count() - _orders.getGoods_count());
			goodsDao.updateGoods(goods);
			//订单取货
			orders.setOrders_flag(2);
			ordersDao.updateOrders(orders);
		}
		
		return tip;
	}
	
	/**
	 * @Title: confirmOrders
	 * @Description: 确认归还
	 * @param orders
	 * @return void
	 */
	public void confirmOrders(Orders orders) {
		//确认订单信息
		orders.setOrders_flag(4);//确认归还
		ordersDao.updateOrders(orders);
		
		//更新库存数量
		Orders _orders = ordersDao.getOrders(orders);
		Goods goods = new Goods();
		goods.setGoods_id(_orders.getGoods_id());
		goods = goodsDao.getGoods(goods);
		goods.setGoods_count(goods.getGoods_count() + _orders.getGoods_count());
		goodsDao.updateGoods(goods);
		
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
