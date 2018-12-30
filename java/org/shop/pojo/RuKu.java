package org.shop.pojo;

public class RuKu {
    private Integer rukuId;

    private String shopName;

    private String shopFenlei;

    private Integer rukuShuliang;

    private String rukuData;

    public Integer getRukuId() {
        return rukuId;
    }

    public void setRukuId(Integer rukuId) {
        this.rukuId = rukuId;
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

    public Integer getRukuShuliang() {
        return rukuShuliang;
    }

    public void setRukuShuliang(Integer rukuShuliang) {
        this.rukuShuliang = rukuShuliang;
    }

    public String getRukuData() {
        return rukuData;
    }

    public void setRukuData(String rukuData) {
        this.rukuData = rukuData == null ? null : rukuData.trim();
    }

	@Override
	public String toString() {
		return "RuKu [rukuId=" + rukuId + ", shopName=" + shopName + ", shopFenlei=" + shopFenlei + ", rukuShuliang="
				+ rukuShuliang + ", rukuData=" + rukuData + "]";
	}
    
    
}