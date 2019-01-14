package com.nkl.admin.domain;

import com.nkl.common.domain.BaseDomain;

public class OrdersDetail extends BaseDomain {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = -6925524708882684408L;
	private int detail_id; // 
	private String orders_no; // 
	private int goods_id; // 
	private String goods_name; // 
	private double goods_price; // 
	private double goods_yj; // 
	private double goods_price2; // 
	private int goods_count; // 
	private String orders_date1; // 
	private String orders_date2; // 
	private double goods_money; // 
	
	private String ids;

	public int getDetail_id() {
		return detail_id;
	}

	public void setDetail_id(int detail_id) {
		this.detail_id = detail_id;
	}

	public String getOrders_no() {
		return orders_no;
	}

	public void setOrders_no(String orders_no) {
		this.orders_no = orders_no;
	}

	public int getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}

	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	public double getGoods_price() {
		return goods_price;
	}

	public void setGoods_price(double goods_price) {
		this.goods_price = goods_price;
	}

	public int getGoods_count() {
		return goods_count;
	}

	public void setGoods_count(int goods_count) {
		this.goods_count = goods_count;
	}

	public double getGoods_money() {
		return goods_money;
	}

	public void setGoods_money(double goods_money) {
		this.goods_money = goods_money;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public double getGoods_price2() {
		return goods_price2;
	}

	public String getOrders_date1() {
		return orders_date1;
	}

	public String getOrders_date2() {
		return orders_date2;
	}

	public void setGoods_price2(double goods_price2) {
		this.goods_price2 = goods_price2;
	}

	public void setOrders_date1(String orders_date1) {
		this.orders_date1 = orders_date1;
	}

	public void setOrders_date2(String orders_date2) {
		this.orders_date2 = orders_date2;
	}

	public double getGoods_yj() {
		return goods_yj;
	}

	public void setGoods_yj(double goods_yj) {
		this.goods_yj = goods_yj;
	}

}
