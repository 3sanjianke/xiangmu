package org.shop.pojo;

public class KuCun {
    private Integer kucunId;

    private String shopName;

    private String shopFenlei;

    private Integer shopShuliang;

    public Integer getKucunId() {
        return kucunId;
    }

    public void setKucunId(Integer kucunId) {
        this.kucunId = kucunId;
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

    public Integer getShopShuliang() {
        return shopShuliang;
    }

    public void setShopShuliang(Integer shopShuliang) {
        this.shopShuliang = shopShuliang;
    }

	@Override
	public String toString() {
		return "KuCun [kucunId=" + kucunId + ", shopName=" + shopName + ", shopFenlei=" + shopFenlei + ", shopShuliang="
				+ shopShuliang + "]";
	}
    
    
}