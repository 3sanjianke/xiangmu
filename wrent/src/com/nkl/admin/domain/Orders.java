package com.nkl.admin.domain;

import java.util.ArrayList;
import java.util.List;

import com.nkl.common.domain.BaseDomain;

public class Orders extends BaseDomain {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = -6925524708882684408L;
	private int orders_id; // 
	private String orders_no; // 
	private String orders_date; // 
	private int user_id; // 
	private String real_name; // 
	private String user_address; // 
	private String user_phone; // 
	private int goods_id; // 
	private String goods_name; // 
	private double goods_price; // 
	private double goods_yj; // 
	private double goods_price2; // 
	private int goods_count; // 
	private String orders_date1; // 
	private String orders_date2; // 
	private double goods_money; // 
	private String orders_date3; // 
	private double goods_money2; // 
	private int orders_flag; // 1:待取货 2:已取货 3:用户归还 4:确认归还 5:已作废

	private String orders_flags; // 
	private String orders_date_min;
	private String orders_date_max;
	private String orders_month_min;
	private String orders_month_max;
	private int goods_type_id; // 
	
	private List<OrdersDetail> ordersDetails = new ArrayList<OrdersDetail>();
	
	private String ids;
	
	public String getOrders_flagDesc() {
		switch (orders_flag) {
			case 1:
				return "待取货";
			case 2:
				return "已取货";
			case 3:
				return "用户归还";
			case 4:
				return "确认归还";
			case 5:
				return "已作废";
			default:
				return "";
		}
	}
	
	public int getOrders_flag() {
		return orders_flag;
	}

	public void setOrders_flag(int orders_flag) {
		this.orders_flag = orders_flag;
	}

	public int getOrders_id() {
		return orders_id;
	}

	public void setOrders_id(int orders_id) {
		this.orders_id = orders_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getOrders_date() {
		return orders_date;
	}

	public void setOrders_date(String orders_date) {
		this.orders_date = orders_date;
	}

	public String getReal_name() {
		return real_name;
	}

	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getOrders_no() {
		return orders_no;
	}

	public void setOrders_no(String orders_no) {
		this.orders_no = orders_no;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getOrders_date_min() {
		return orders_date_min;
	}

	public void setOrders_date_min(String orders_date_min) {
		this.orders_date_min = orders_date_min;
	}

	public String getOrders_date_max() {
		return orders_date_max;
	}

	public void setOrders_date_max(String orders_date_max) {
		this.orders_date_max = orders_date_max;
	}

	public List<OrdersDetail> getOrdersDetails() {
		return ordersDetails;
	}

	public void setOrdersDetails(List<OrdersDetail> ordersDetails) {
		this.ordersDetails = ordersDetails;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	public int getGoods_id() {
		return goods_id;
	}

	public String getGoods_name() {
		return goods_name;
	}

	public double getGoods_price() {
		return goods_price;
	}

	public double getGoods_price2() {
		return goods_price2;
	}

	public int getGoods_count() {
		return goods_count;
	}

	public String getOrders_date1() {
		return orders_date1;
	}

	public String getOrders_date2() {
		return orders_date2;
	}

	public double getGoods_money() {
		return goods_money;
	}

	public String getOrders_date3() {
		return orders_date3;
	}

	public double getGoods_money2() {
		return goods_money2;
	}

	public String getOrders_month_min() {
		return orders_month_min;
	}

	public String getOrders_month_max() {
		return orders_month_max;
	}

	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	public void setGoods_price(double goods_price) {
		this.goods_price = goods_price;
	}

	public void setGoods_price2(double goods_price2) {
		this.goods_price2 = goods_price2;
	}

	public void setGoods_count(int goods_count) {
		this.goods_count = goods_count;
	}

	public void setOrders_date1(String orders_date1) {
		this.orders_date1 = orders_date1;
	}

	public void setOrders_date2(String orders_date2) {
		this.orders_date2 = orders_date2;
	}

	public void setGoods_money(double goods_money) {
		this.goods_money = goods_money;
	}

	public void setOrders_date3(String orders_date3) {
		this.orders_date3 = orders_date3;
	}

	public void setGoods_money2(double goods_money2) {
		this.goods_money2 = goods_money2;
	}

	public void setOrders_month_min(String orders_month_min) {
		this.orders_month_min = orders_month_min;
	}

	public void setOrders_month_max(String orders_month_max) {
		this.orders_month_max = orders_month_max;
	}

	public String getOrders_flags() {
		return orders_flags;
	}

	public void setOrders_flags(String orders_flags) {
		this.orders_flags = orders_flags;
	}

	public double getGoods_yj() {
		return goods_yj;
	}

	public void setGoods_yj(double goods_yj) {
		this.goods_yj = goods_yj;
	}

	public int getGoods_type_id() {
		return goods_type_id;
	}

	public void setGoods_type_id(int goods_type_id) {
		this.goods_type_id = goods_type_id;
	}


}
