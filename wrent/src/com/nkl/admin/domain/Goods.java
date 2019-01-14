package com.nkl.admin.domain;

import com.nkl.common.domain.BaseDomain;
import com.nkl.common.util.StringUtil;
import com.nkl.common.util.Transcode;

public class Goods extends BaseDomain {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = -6925524708882684408L;
	private int goods_id; // 
	private int goods_type_id; // 
	private String goods_no; // 
	private String goods_name; // 
	private double goods_price; // 
	private double goods_yj; // 
	private double goods_price2; // 
	private int goods_count; // 
	private String goods_pic; // 
	private String goods_desc; // 
	private String goods_date; // 
	
	private String goods_type_name; // 
	private int goods_sale; // 
	private String goods_price_min; //
	private String goods_price_max; //
	private String ids;
	
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

	public String getGoods_pic() {
		return goods_pic;
	}

	public void setGoods_pic(String goods_pic) {
		this.goods_pic = goods_pic;
	}

	public String getGoods_descShow(){
		if (!StringUtil.isEmptyString(goods_desc)) {
			return Transcode.htmlDiscode(goods_desc);
		}
		return goods_desc;
	}
	
	public String getGoods_desc() {
		return goods_desc;
	}

	public void setGoods_desc(String goods_desc) {
		this.goods_desc = goods_desc;
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

	public void setGoods_price2(double goods_price2) {
		this.goods_price2 = goods_price2;
	}

	public String getGoods_date() {
		return goods_date;
	}

	public void setGoods_date(String goods_date) {
		this.goods_date = goods_date;
	}

	public int getGoods_type_id() {
		return goods_type_id;
	}

	public void setGoods_type_id(int goods_type_id) {
		this.goods_type_id = goods_type_id;
	}

	public String getGoods_type_name() {
		return goods_type_name;
	}

	public void setGoods_type_name(String goods_type_name) {
		this.goods_type_name = goods_type_name;
	}

	public int getGoods_count() {
		return goods_count;
	}

	public void setGoods_count(int goods_count) {
		this.goods_count = goods_count;
	}

	public String getGoods_no() {
		return goods_no;
	}

	public double getGoods_price() {
		return goods_price;
	}

	public void setGoods_no(String goods_no) {
		this.goods_no = goods_no;
	}

	public void setGoods_price(double goods_price) {
		this.goods_price = goods_price;
	}

	public int getGoods_sale() {
		return goods_sale;
	}

	public void setGoods_sale(int goods_sale) {
		this.goods_sale = goods_sale;
	}

	public double getGoods_yj() {
		return goods_yj;
	}

	public void setGoods_yj(double goods_yj) {
		this.goods_yj = goods_yj;
	}

	public String getGoods_price_min() {
		return goods_price_min;
	}

	public String getGoods_price_max() {
		return goods_price_max;
	}

	public void setGoods_price_min(String goods_price_min) {
		this.goods_price_min = goods_price_min;
	}

	public void setGoods_price_max(String goods_price_max) {
		this.goods_price_max = goods_price_max;
	}

}
