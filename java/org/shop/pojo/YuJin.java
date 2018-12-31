package org.shop.pojo;

public class YuJin {
    private Integer yujinId;

    private String shopName;

    private String shopFenlei;

    private String beizhu;

    private Integer yujingShuliang;

    public Integer getYujinId() {
        return yujinId;
    }

    public void setYujinId(Integer yujinId) {
        this.yujinId = yujinId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    public String getShopFenlei() {
        return shopFenlei;
    }

    public void setShopFenlei(String shopFenlei) {
        this.shopFenlei = shopFenlei == null ? null : shopFenlei.trim();
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu == null ? null : beizhu.trim();
    }

    public Integer getYujingShuliang() {
        return yujingShuliang;
    }

    public void setYujingShuliang(Integer yujingShuliang) {
        this.yujingShuliang = yujingShuliang;
    }

	@Override
	public String toString() {
		return "YuJin [yujinId=" + yujinId + ", shopName=" + shopName + ", shopFenlei=" + shopFenlei + ", beizhu="
				+ beizhu + ", yujingShuliang=" + yujingShuliang + "]";
	}
    
    
}